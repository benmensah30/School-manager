package com.example.schoolmanager.Controllers;

import com.example.schoolmanager.HelloApplication;
import com.example.schoolmanager.IDBConfig.DatabaseDB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ConnectionController {

    @FXML
    private PasswordField passwordPF;

    @FXML
    private TextField usernameTF;

    private PreparedStatement preparedStatement;
    private Connection connection;
    private ResultSet resultSet;

    //methode qui permet de passer de la page de connexion a la page d'inscription
    public void signUpConnect() throws IOException {

        Parent good = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("connection.fxml")));
        Stage stg = new Stage();
        Scene scene = new Scene(good);
        stg.setScene(scene);
        stg.show();

        Stage connectscene = (Stage) usernameTF.getScene().getWindow();
        connectscene.close();
    }

    public void ConnectBtn() throws IOException {

        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        connection = DatabaseDB.connectDB();

        try {

            Alert alert;

            assert connection != null;
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usernameTF.getText());
            preparedStatement.setString(2, passwordPF.getText());

            resultSet = preparedStatement.executeQuery();

            if (usernameTF.getText().isEmpty() || passwordPF.getText().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("Remplir tout les champs");
                alert.showAndWait();

            } else if (resultSet.next()) {

                Parent good = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("acceuil.fxml")));
                Stage stg = new Stage();
                Scene scene = new Scene(good);
                stg.setScene(scene);
                stg.show();

                Stage connectscene = (Stage) usernameTF.getScene().getWindow();
                connectscene.close();

            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("nom d'utilisateur ou mot de passe incorrect");
                alert.showAndWait();
            }

        } catch (SQLException | IOException exception) {
            throw new RuntimeException(exception);
        }

    }

    public void close() {
        System.exit(0);
    }

}

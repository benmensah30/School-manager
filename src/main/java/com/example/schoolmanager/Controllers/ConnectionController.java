package com.example.schoolmanager.Controllers;

import com.example.schoolmanager.HelloApplication;
import com.example.schoolmanager.IDBConfig.DatabaseDB;
import com.example.schoolmanager.models.User;
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

        try {

            Alert alert;

            User user = new User();

            user.userLogin(user);

            if (usernameTF.getText().isEmpty() || passwordPF.getText().isEmpty()) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'erreur");
                alert.setHeaderText(null);
                alert.setContentText("Remplir tout les champs");
                alert.showAndWait();

            } else if ((user.getResultSet()).next()) {

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

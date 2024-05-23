package com.example.schoolmanager.Controllers;

import com.example.schoolmanager.IDBConfig.DatabaseDB;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class FormulaireController {


    @FXML
    private DatePicker date;

    @FXML
    private TextField etat;

    @FXML
    private TextField naissance;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private Button quitter;

    @FXML
    private Button save;

    public void addStudent() {
        String sql = "INSERT INTO student (firstname, lastname, dateOfBirth, placeOfBirth, state) VALUES (?, ?, ?, ?, ?)";
        Connection connection = DatabaseDB.connectDB();

        try {

            Alert alert;


            if (prenom.getText().isEmpty() || nom.getText().isEmpty() || String.valueOf(date.getValue()).isEmpty() || naissance.getText().isEmpty() || etat.getText().isEmpty()) {
                // si on ne rempli pas l'un des deux champ

                //Une alerte de type ERREUR
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message d'alert");
                alert.setHeaderText(null);
                alert.setContentText("Remplir tout les champs");
                alert.showAndWait();

            } else {

                assert connection != null;
                PreparedStatement prepStat = connection.prepareStatement(sql);
                prepStat.setString(1, prenom.getText());
                prepStat.setString(2, nom.getText());
                prepStat.setString(3, String.valueOf(date.getValue()));
                prepStat.setString(4, naissance.getText());
                prepStat.setString(5, etat.getText());
//                prepStat.setString(6, "info_S.getText()");

                prepStat.executeUpdate();

            }

        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }

//      le bloque de code qui permet d'effacer les champs a s'aisir

        prenom.setText("");
        date.setValue(LocalDate.ofEpochDay(0));
        etat.setText("");
        nom.setText("");
        naissance.setText("");

    }

    public void close() {
        System.exit(0);
    }
}
package com.example.schoolmanager.Controllers;

import com.example.schoolmanager.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AcceuilController {

    @FXML
    private Button addBtn;

    public void direction() throws IOException {

        Parent good = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("formulaire.fxml")));
        Stage stg = new Stage();
        Scene scene = new Scene(good);
        stg.setScene(scene);
        stg.show();

        Stage connectscene = (Stage) addBtn.getScene().getWindow();
        connectscene.close();

    }

}

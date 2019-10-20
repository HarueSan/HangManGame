package com.harue.hangman.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    FXMLLoader loader = new FXMLLoader();
    @FXML
    Button btnplay;

    Scene playScene;


    @FXML
    private void initialize() throws IOException {
        loader.setLocation(getClass().getResource("/resources/scenes/PlayScene.fxml"));
        Parent playParent = loader.load();
        playScene = new Scene(playParent);
    }


    public void btnplayClicked(){

        Stage stage = (Stage) btnplay.getScene().getWindow();
        stage.setScene(playScene);

    }


}

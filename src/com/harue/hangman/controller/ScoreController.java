package com.harue.hangman.controller;

import com.harue.hangman.GameController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ScoreController {

    GameController gameController = GameController.getInstance();

    @FXML
    AnchorPane anchorpane;

    @FXML
    Label score;

    @FXML
    Button home;

    @FXML
    private void initialize(){
        this.score.setText(gameController.getScore().toString());
        System.out.println("SCORE : ");
        System.out.println(gameController.getScore());
        anchorpane.getStyleClass().setAll("background-win");
    }

    public void btnHomeClick() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/scenes/HomeScene.fxml"));
        Parent playParent = loader.load();
        Scene homeScene = new Scene(playParent);
        Stage stage = (Stage) home.getScene().getWindow();
        stage.setScene(homeScene);

    }

}

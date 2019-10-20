package com.harue.hangman.controller;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class IntroController {

    FXMLLoader loader = new FXMLLoader();

    @FXML
    VBox intro;


    @FXML
    private void initialize() throws IOException {
//        System.out.println("hhhhhh");
        loader.setLocation(getClass().getResource("/resources/scenes/HomeScene.fxml"));
        Parent introparent = loader.load();
        Scene scene1 = new Scene(introparent);

        FadeTransition fadein = new FadeTransition(Duration.seconds(3), intro);
        fadein.setFromValue(0.0);
        fadein.setToValue(1.0);
        fadein.play();

        FadeTransition fadeout = new FadeTransition(Duration.seconds(3), intro);
        fadeout.setFromValue(1.0);
        fadeout.setToValue(0.0);

        fadein.setOnFinished((e)->{
            fadeout.play();
        });

        fadeout.setOnFinished((e)->{
            Stage stage = (Stage) intro.getScene().getWindow();
            stage.setScene(scene1);
            FadeTransition homeFadeIn = new FadeTransition(Duration.seconds(3),introparent);
            homeFadeIn.setFromValue(0.0);
            homeFadeIn.setToValue(1.0);
            homeFadeIn.play();

        });


    }
}

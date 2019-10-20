package com.harue.hangman;

import com.harue.hangman.domains.Question;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainGame extends Application {

    StackPane stack = null;

    GameController gameController = GameController.getInstance();

    @Override
    public void start(Stage stage) throws Exception {


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/scenes/IntroScene.fxml"));
        Parent introParent = loader.load();

        Scene scene = new Scene(introParent);
        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.initStyle(StageStyle.DECORATED);
        stage.setResizable(false);
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

package com.harue.hangman.controller;


import com.harue.hangman.GameController;
import com.harue.hangman.domains.Question;
import javafx.animation.FadeTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;


public class PlayController {

    FXMLLoader loader = new FXMLLoader();
    @FXML
    ImageView manimg;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Label textquest;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;



    Scene endScene;

    GameController gameController = GameController.getInstance();


    private int numwrong = 0;
    private String[] images = {
            "/resources/images/man/initial.PNG",
            "/resources/images/man/fail1.PNG",
            "/resources/images/man/fail2.PNG",
            "/resources/images/man/fail3.PNG",
            "/resources/images/man/fail4.PNG",
            "/resources/images/man/fail5.PNG",
            "/resources/images/man/fail6.PNG",
            "/resources/images/man/die.PNG"

    };


    public void incorrectAnswer() throws IOException {
        this.numwrong += 1;
        manimg.setImage(
                new Image(images[numwrong])
        );
        if(numwrong == 7){

            loader.setLocation(getClass().getResource("/resources/scenes/EndGameScene.fxml"));
            Parent failParent = loader.load();
            endScene = new Scene(failParent);

            Stage stage = (Stage) anchorpane.getScene().getWindow();
            FadeTransition fadeout = new FadeTransition(Duration.seconds(2),anchorpane);
            fadeout.setFromValue(1.0);
            fadeout.setToValue(1.0);
            fadeout.play();

            fadeout.setOnFinished((e)->{

                stage.setScene(endScene);
            });

        }

    }
    @FXML
    private void initialize() throws IOException {


        this.loadNextQustion();
    }

    private void loadNextQustion(){
        Question q = gameController.getQuestions()[gameController.getCurrent_question()];
        textquest.setText(q.getQuestion());
        button1.setText(q.getChoices()[0]);
        button2.setText(q.getChoices()[1]);
        button3.setText(q.getChoices()[2]);
        button4.setText(q.getChoices()[3]);

    }

    public void checkAnswer(Event e) throws IOException {
        int answer;
        if(e.getSource().equals(button1)){
            answer = 0;
        }else if(e.getSource().equals(button2)){
            answer = 1;
        }else if(e.getSource().equals(button3)){
            answer = 2;
        }else {
            answer = 3;
        }

        Question q = gameController.getQuestions()[gameController.getCurrent_question()];
        boolean result = q.checkAnswer(answer);
        if(result){
            gameController.increaseScore();
        }else{
            incorrectAnswer();
        }
        gameController.increaseQuestion();
        loadNextQustion();
        System.out.println(gameController.getScore());


    }


}

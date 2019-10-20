package com.harue.hangman;

import com.harue.hangman.domains.Question;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameController {

    private static GameController instance = null;

    private Question[] questions;

    private Integer current_question = 0;
    private Integer score = 0;


    public Question[] getQuestions() {
        return questions;
    }

    private GameController(){
        try {
            File file = new File(getClass().getResource("/resources/question/question").getFile());
            Scanner input = new Scanner(file);
            int numQuestions = Integer.parseInt(input.nextLine());
            this.questions = new Question[numQuestions];

            for(int i = 0; i < numQuestions; i++) {

                String questionText = input.nextLine();
                String choice0 = input.nextLine();
                String choice1 = input.nextLine();
                String choice2 = input.nextLine();
                String choice3 = input.nextLine();
                int answer = Integer.parseInt(input.nextLine());

                String[] choices = {choice0, choice1, choice2, choice3};
                Question q = new Question(questionText, choices, answer);
                q.print();
                this.questions[i] = q;
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
    //Singleton pattern
    public static GameController getInstance(){
        if(instance == null){
            instance = new GameController();
        }
        return instance;
    }

    public Integer getCurrent_question() {
        return current_question;
    }

    public void setCurrent_question(Integer current_question) {
        this.current_question = current_question;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void resetGame(){
        this.current_question = 0;
        this.score = 0;
    }

    public void increaseScore(){
        this.score++;
    }
    public void increaseQuestion(){
        this.current_question += 1;
    }


}

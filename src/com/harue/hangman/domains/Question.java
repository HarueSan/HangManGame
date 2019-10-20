package com.harue.hangman.domains;

public class Question {

    private String question;
    private String[] choices;
    private int answer;

    public Question(String question,String[] choices, int answer){
        this.question = question;
        this.choices = choices;
        this.answer = answer;
    }

    public boolean checkAnswer(int answer){
        return this.answer == answer;
    }

    public void print(){
        System.out.println("============================");
        System.out.println(this.question);
        for(String i : this.choices) {
            System.out.println(i);
        }
        System.out.println(this.answer);
        System.out.println("============================");

    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}

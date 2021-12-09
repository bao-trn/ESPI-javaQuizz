package quizz.questions;

public class Question<T>{
    String theme;
    String questionChoice;
    String questionType;
    int difficulty;
    String questionBody;
    T answer;

    public Question(String theme, int difficulty, T answer) {
    }

    public void displayDifficulty(){
        switch(difficulty){
            case 1:
                System.out.println("Difficulty : 1 EASY");
                break;
            case 2:
                System.out.println("Difficulty: 2 MEDIUM");
                break;
            case 3:
                System.out.println("Difficulty : 3 HARD");
                break;
            default:
                System.out.println("Difficulty goes from 1 to 3 only");
        }
    }

    public void displayAnswer(){
        System.out.println("CORRECT ANSWER: " + answer);
    }

    public void displayQuestion(){
        System.out.println("QUESTION : " + questionChoice);
    }

    public void displayTheme(){
        System.out.println("THEME : " + theme);
    }

    public void setQuestion(String question){
        this.questionChoice = question;
    }

    public void setQuestion(String a, String b, String c) {
        //empty because overridden in QCM.java
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getQuestionChoice() {
        return questionChoice;
    }

    public void setQuestionChoice(String questionChoice) {
        this.questionChoice = questionChoice;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestionBody() {
        return questionBody;
    }

    public void setQuestionBody(String questionBody) {
        this.questionBody = questionBody;
    }

    public T getAnswer() {
        return answer;
    }

    public void setAnswer(T answer) {
        this.answer = answer;
    }

    public String toString(){
        return questionType;
    }

}

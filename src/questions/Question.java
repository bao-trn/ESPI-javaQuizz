package questions;

public class Question<T>{
    String theme;
    String question;
    int difficulty;
    String questionBody;
    T answer;

    public Question(String theme, int difficulty, T answer) {
    }

    public void displayDifficulty(){
        switch(difficulty){
            case 1:
                System.out.println("Difficulty : EASY");
                break;
            case 2:
                System.out.println("Difficulty: MEDIUM");
                break;
            case 3:
                System.out.println("Difficulty : HARD");
                break;
            default:
                System.out.println("Please input a number between 1  and 3");
        }
    }

    public void displayAnswer(){
        System.out.println("Correct Answer: " + answer);
    }

    public void displayQuestion(){
        System.out.println("QUESTION : " + question);
    }

    public void displayTheme(){
        System.out.println("THEME : " + theme);
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public void setQuestion(String a, String b, String c) {
        //empty because overridden in QCM.java
    }
}

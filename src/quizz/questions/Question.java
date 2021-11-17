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


}

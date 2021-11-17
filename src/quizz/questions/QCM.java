package quizz.questions;

import java.util.ArrayList;

public class QCM<T> extends Question<T>{
    ArrayList<String> choices = new ArrayList<>();

    public QCM (String theme, int difficulty, T answer){
        super(theme, difficulty, answer);
        this.theme = theme;
        this.questionType = "QCM";
        this.difficulty = difficulty;
        this.questionBody = "Please select the correct answer (1-3):";
        this.answer = answer;

    }

    @Override
    public void setQuestion(String choice1, String choice2, String choice3){
        choices.add(choice1);
        choices.add(choice2);
        choices.add(choice3);
    }


    @Override
    public void displayQuestion() {
        for (int i = 0; i < choices.size(); i++){
            System.out.println((i+1) + ": " + choices.get(i));
        }
    }


}

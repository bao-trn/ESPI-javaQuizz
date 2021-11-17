package Questions;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class QCM extends Question{
    ArrayList<String> choices = new ArrayList<>();

    public QCM (String theme, int difficulty, String answer){
        super(theme, difficulty, answer);
        this.theme = theme;
        this.difficulty = difficulty;
        this.questionBody = "Please select the correct answer (1-3):";
        this.answer = answer;

    }

    public void addQCMchoices(String choice1, String choice2, String choice3){
        choices.add(choice1);
        choices.add(choice2);
        choices.add(choice3);
    }


    public void displayQuestion() {
        for (int i = 0; i < choices.size(); i++){
            System.out.println((i+1) + ": " + choices.get(i));
        }
    }


}

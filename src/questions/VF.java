package questions;

public class VF<T> extends Question<T>{

    public VF(String theme, int difficulty,T answer) {
        super(theme, difficulty, answer);
        this.theme = theme;
        this.difficulty = difficulty;
        this.questionBody = "Please select the correct answer (V/F):";
        this.answer = answer;
    }

}

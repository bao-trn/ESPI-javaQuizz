package Questions;

public class VF extends Question{

    public VF(String theme, int difficulty,Object answer) {
        super(theme, difficulty, answer);
        this.theme = theme;
        this.difficulty = difficulty;
        this.questionBody = "Please select the correct answer (V/F):";
        this.answer = answer;
    }

    public void setQuestion(String question){
        super.question = question;
    }


}

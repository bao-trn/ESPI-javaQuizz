package Questions;

public class RC extends Question{

    public RC(String theme, int difficulty, Object answer) {
        super(theme, difficulty ,answer);
        this.theme = theme;
        this.difficulty = difficulty;
        this.questionBody = "Please write a short answer:";
        this.answer = answer;
    }

    public void setQuestion(String question){
        super.question = question;
    }

}

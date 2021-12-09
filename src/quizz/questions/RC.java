package quizz.questions;

public class RC<T> extends Question<T>{

    public RC(String theme, int difficulty, T answer) {
        super(theme, difficulty ,answer);
        this.theme = theme;
        this.questionType = "RC";
        this.difficulty = difficulty;
        this.questionBody = "Please write a short answer:";
        this.answer = answer;
        this.questionChoice = "Placeholder question";
    }

}

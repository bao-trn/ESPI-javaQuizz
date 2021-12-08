package quizz;

import quizz.theme.Themes;
import quizz.questions.QCM;
import quizz.questions.Question;
import quizz.questions.RC;
import quizz.questions.VF;
import quizz.constants.themeConstants;

import java.io.ObjectStreamException;

public class Main {

    public static void main(String[] args){
        Question<Object> testQCM = new QCM<>(themeConstants.SPORT.name(),2,"1");
        Question<Object> testVF = new VF<>(themeConstants.ART.name(),1,true);
        Question<Object> testRC = new RC<>(themeConstants.ANIME.name(),3,"This is a short text");



        testQCM.setQuestion("first choice","second choice","third choice");
        testVF.setQuestion("Am I bald?");
        testRC.setQuestion("Describe yourself in 10 words");

        testQCM.displayQuestion();
        testQCM.displayAnswer();
        testQCM.displayTheme();
        testQCM.displayDifficulty();

        Themes<Object> theme = new Themes<>();
        theme.addTheme(themeConstants.SPORT.name());
        theme.addTheme(themeConstants.ANIME.name());
        theme.addTheme(themeConstants.GAMES.name());
        theme.addTheme(themeConstants.GEOGRAPHY.name());
        theme.addTheme(themeConstants.LOGIC.name());
        theme.addTheme(themeConstants.MATHEMATICS.name());
        theme.addTheme(themeConstants.MUSIC.name());
        theme.addTheme(themeConstants.SCIENCE.name());
        theme.addTheme(themeConstants.MOVIES.name());
        theme.addTheme(themeConstants.ART.name());

        theme.addQuestion(themeConstants.SPORT.name(),testQCM);
        theme.addQuestion(themeConstants.SPORT.name(),testRC);
        theme.addQuestion(themeConstants.SPORT.name(),testVF);
        theme.displayThemesAndIndex();
        System.out.println(theme.selectFiveRandomThemes());
        System.out.println(theme.getThemes().get(themeConstants.SPORT.name()));

        Question<Object> newQCM = new QCM<>(themeConstants.GAMES.name(), 3, 2);
        theme.addQuestion(themeConstants.GAMES.name(),newQCM);
        theme.addQuestion(themeConstants.GAMES.name(),testQCM);
        System.out.println(theme.getThemes().get(themeConstants.GAMES.name()).size());
        theme.deleteQuestion(themeConstants.GAMES.name(),0);
        System.out.println(theme.getThemes().get(themeConstants.GAMES.name()).size());




    }

}

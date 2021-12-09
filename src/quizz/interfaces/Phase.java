package quizz.interfaces;

import quizz.Utils.GameUtils;
import quizz.Utils.RandomUtils;
import quizz.constants.themeConstants;
import quizz.joueurs.Player;
import quizz.joueurs.Players;
import quizz.questions.Question;
import quizz.theme.Themes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface Phase {


    default void phaseOneRules(){
        System.out.println("Welcome to the first phase of this game!");
        System.out.println("4 players will be randomly selected amongst the participants.");
        System.out.println("Players will answer an EASY question for each of the 10 different THEMES.");
    }

    default void phaseStart(Themes<Object> themes, Players players, int numberOfThemes, int questionsPerPlayer, int difficulty){
        int themeWheel = RandomUtils.selectRandom(numberOfThemes);
        int themeCounter = 0;
        for (int i = 0; i < numberOfThemes; i++){
            String currentTheme = themeConstants.values()[themeWheel].name();
            LinkedList<Question<Object>> questionList = themes.getThemes().get(currentTheme);
            List<Question<Object>> diffQuestions = new ArrayList<>();

            System.out.println("Current THEME is : " + currentTheme);

            if (themeCounter == numberOfThemes){
                break;
            }

            for (Question<Object> question : questionList) {
                if (question.getDifficulty() == difficulty) {
                    diffQuestions.add(question);
                }
            }

            GameUtils.playerAction(players, diffQuestions, questionsPerPlayer);

            System.out.println(diffQuestions);
            System.out.println("END OF QUESTIONS FOR THEME : " + currentTheme);

            if (themeWheel < numberOfThemes){
                themeWheel++;
            }
            if (themeWheel == numberOfThemes){
                themeWheel = 0;
            }
            themeCounter++;
        }
    }



}

package quizz.interfaces;

import quizz.Game;
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

    default void phaseTwoRules(){
        System.out.println("Welcome to the second phase of this game!");
        System.out.println("There are 3 remaining players.");
        System.out.println("Players will pick TWO THEMES and answer a MEDIUM question for each of them.");
    }

    default void phaseStart(Themes<Object> themes, Players players, int numberOfThemes, int difficulty){
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

            for (int j = 0; j < players.getSelectedPlayers().size(); j++) {
                Player currentPlayer = players.getSelectedPlayers().get(j);
                if (difficulty == 2){
                    System.out.println("REMAINING THEMES ARE : ");
                    System.out.println(themes.getThemes().keySet());
                    currentTheme = currentPlayer.userInput();
                    GameUtils.resetQuestionList(questionList);
                    themes.getThemes().remove(currentTheme);
                }
                GameUtils.playerAction(currentPlayer, GameUtils.fetchQuestionsOfDifficulty(questionList, diffQuestions, difficulty));
            }


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

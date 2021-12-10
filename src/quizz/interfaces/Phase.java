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
        System.out.println("**** WELCOME TO PHASE 1 ****");
        System.out.println("4 players will be randomly selected amongst the participants.");
        System.out.println("Players will answer an EASY question for each of the 10 different THEMES." + System.lineSeparator());
    }

    default void phaseTwoRules(){
        System.out.println("**** WELCOME TO PHASE 2 ****");
        System.out.println("There are 3 remaining players.");
        System.out.println("Players will pick TWO THEMES and answer a MEDIUM question for each of them." + System.lineSeparator());
    }

    default void phaseThreeRules(){
        System.out.println("**** WELCOME TO THE FINAL ****");
        System.out.println("There are 2 remaning players.");
        System.out.println("3 THEMES are picked by me, you will answer 2 HARD questions for 2 THEMES." + System.lineSeparator());
    }

    default void phaseStart(Themes<Object> themes, Players players, int numberOfThemes, int difficulty){
        int themeWheel = RandomUtils.selectRandom(numberOfThemes);
        for (int i = 0; i < numberOfThemes; i++){
            String currentTheme = themeConstants.values()[themeWheel].name();
            List<Question<Object>> questionList = themes.getThemes().get(currentTheme);
            List<Question<Object>> diffQuestions = new ArrayList<>();

            for (int j = 0; j < players.getSelectedPlayers().size(); j++){
                Player currentPlayer = players.getSelectedPlayers().get(j);
                if (difficulty == 1){
                    System.out.println("Current THEME is : " + currentTheme);
                    GameUtils.playerAction(currentPlayer, GameUtils.fetchQuestionsOfDifficulty(questionList, diffQuestions, difficulty), difficulty);
                    System.out.println("END OF QUESTIONS FOR THEME : " + currentTheme);
                    if (themeWheel < numberOfThemes){
                        themeWheel++;
                    }
                    if (themeWheel == numberOfThemes){
                        themeWheel = 0;
                    }
                } else {
                    int numQuestions = 2;
                    if (difficulty == 3){
                        numQuestions = 1;
                    }
                    for (int k = 0; k < numQuestions; k++){
                        if (difficulty == 3){
                            System.out.println("THE 3 THEMES ARE : ");
                            k++;
                        }else{
                            System.out.println("REMAINING THEMES ARE : ");
                        }
                        System.out.println(themes.getThemes().keySet());
                        System.out.print("Please select a THEME : ");
                        String themeSelected = GameUtils.checkUserInput(themes, currentPlayer);
                        System.out.println("Current THEME is : " + themeSelected);
                        questionList = themes.getThemes().get(themeSelected);
                        GameUtils.playerAction(currentPlayer, GameUtils.fetchQuestionsOfDifficulty(questionList, diffQuestions, difficulty), difficulty);
                        System.out.println("END OF QUESTIONS FOR THEME : " + themeSelected);
                        themes.getThemes().remove(themeSelected);
                    }
                }
            }
            if(difficulty > 1){
                break;
            }
        }
    }

    default void endPhase(Players players, Themes<Object> themes, Themes<Object> truncated, int bound, boolean prepLastPhase){
        System.out.println("Winners of PHASE : " + GameUtils.getWinners(players, GameUtils.getMaxScore(players)));
        System.out.println("Loser of PHASE : " + GameUtils.getLoser(players) + System.lineSeparator());
        players.getSelectedPlayers().remove(GameUtils.getLoser(players));
        if (prepLastPhase){
            GameUtils.initSelectedThemes(truncated, "ANIME", "LOGIC", "GEOGRAPHY");
            GameUtils.initQuestions(truncated);
        }else {
            GameUtils.initTruncatedThemes(themes, truncated, bound);
            GameUtils.initQuestions(truncated);
        }
    }

}

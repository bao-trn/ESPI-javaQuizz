package quizz;

import quizz.Utils.GameUtils;
import quizz.Utils.RandomUtils;
import quizz.constants.themeConstants;
import quizz.interfaces.Phase;
import quizz.joueurs.Player;
import quizz.joueurs.Players;
import quizz.questions.Question;
import quizz.theme.Themes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game implements Phase {
    Players players = new Players();
    Themes<Object> themes = new Themes<>();
    Themes<Object> truncatedThemes = new Themes<>();
    private int phase = 1;
    Player winner = null;

    public void start(){
        while(winner == null){
            switch (phase){
                case 1:
                    GameUtils.initAll(themes, truncatedThemes, players);
                    phaseOneRules();
                    phaseStart(truncatedThemes, players, 1, phase);
                    truncatedThemes = new Themes<>();
                    endPhase(players, themes, truncatedThemes, 6, 1);
                    phase++;
                    break;
                case 2:
                    phaseTwoRules();
                    phaseStart(truncatedThemes, players, 6, phase);
                    truncatedThemes = new Themes<>();
                    endPhase(players, themes, truncatedThemes, 3, 2);
                    phase++;
                    break;
                case 3:
                    phaseThreeRules();
                    truncatedThemes = new Themes<>();
                    GameUtils.initSelectedThemes(truncatedThemes, "ANIME", "LOGIC", "GEOGRAPHY");
                    GameUtils.initQuestions(truncatedThemes);
                    phaseStart(truncatedThemes, players, 3, phase);
                    System.out.print("SUPER WINNER IS : ");
                    System.out.println(GameUtils.getWinners(players, GameUtils.getMaxScore(players)).get(0));
                    winner = GameUtils.getWinners(players, GameUtils.getMaxScore(players)).get(0);
                    break;
                default:
                    break;
            }
        }
    }

}

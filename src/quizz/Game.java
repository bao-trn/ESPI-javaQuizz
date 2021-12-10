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
    boolean winner = false;

    public void start(){
        while(winner == false){
            switch (phase){
                case 1:
                    GameUtils.initAll(themes, truncatedThemes, players);
                    phaseOneRules();
                    players.displayPlayers(players.getPlayerList());
                    players.resetState();
                    phaseStart(truncatedThemes, players, 3, phase);
                    truncatedThemes = new Themes<>();
                    endPhase(players, themes, truncatedThemes, 6, false);
                    phase++;
                    break;
                case 2:
                    phaseTwoRules();
                    players.displayPlayers(players.getSelectedPlayers());
                    phaseStart(truncatedThemes, players, 6, phase);
                    truncatedThemes = new Themes<>();
                    endPhase(players, themes, truncatedThemes, 3, true);
                    phase++;
                    break;
                case 3:
                    phaseThreeRules();
                    players.displayPlayers(players.getSelectedPlayers());
                    phaseStart(truncatedThemes, players, 3, phase);
                    players.getSelectedPlayers().remove(players.getLoser());
                    System.out.print("CONGRATULATIONS ! ");
                    players.getSelectedPlayers().get(0).setState("SUPER WINNER");
                    players.displayPlayers(players.getSelectedPlayers());
                    winner = true;
                    break;
                default:
                    break;
            }
        }
    }

}

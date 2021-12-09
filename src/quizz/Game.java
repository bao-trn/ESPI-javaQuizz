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
    private int questionsPerPlayer = 1;
    Player winner = null;

    public List<Player> start(){
        GameUtils.initPlayers(players);
        GameUtils.initThemes(themes);
        GameUtils.initTruncatedThemes(themes, truncatedThemes, themes.getThemes().size());
        GameUtils.initQuestions(truncatedThemes, 10);

        players.selectPlayers();
        while(winner == null){
            switch (phase){
                case 1:
                    phaseOneRules();
                    phaseStart(truncatedThemes, players, 3, phase);
                    System.out.println("Winners of PHASE ONE : " + GameUtils.getWinners(players, GameUtils.getMaxScore(players)));
                    System.out.println("Loser of PHASE ONE : " + GameUtils.getLoser(players) + System.lineSeparator());
                    players.getSelectedPlayers().remove(GameUtils.getLoser(players));
                    truncatedThemes = new Themes<>();
                    GameUtils.initTruncatedThemes(themes, truncatedThemes, 6);
                    GameUtils.initQuestions(truncatedThemes, 6);
                    questionsPerPlayer = 2;
                    phase++;
                    break;
                case 2:
                    phaseTwoRules();
                    phaseStart(truncatedThemes, players, 6, phase);
                    System.out.println("Winners of PHASE ONE : " + GameUtils.getWinners(players, GameUtils.getMaxScore(players)));
                    System.out.println("Loser of PHASE ONE : " + GameUtils.getLoser(players));
                    break;
                case 3:

                default:
                    break;
            }
        }



        return players.getPlayerList();
    }


}

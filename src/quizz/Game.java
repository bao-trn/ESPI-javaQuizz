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
    private int numberOfThemes = 0;
    private int questionsPerPlayer = 1;
    Player winner = null;

    public List<Player> start(){
        GameUtils.initPlayers(players);
        GameUtils.initThemes(themes);
        GameUtils.initTruncatedThemes(themes, truncatedThemes, themes.getThemes().size());
        GameUtils.initQuestions(truncatedThemes);

        players.selectPlayers();
        switch (phase){
            case 1:
                phaseOneRules();
                phaseStart(truncatedThemes, players, truncatedThemes.getThemes().size(), questionsPerPlayer, phase);
            System.out.println("Winners of PHASE ONE : " + GameUtils.getWinners(players, GameUtils.getMaxScore(players)));
            System.out.println("Loser of PHASE ONE : " + GameUtils.getLoser(players));
            break;
            case 2:
            case 3:
        }


        return players.getPlayerList();
    }


}

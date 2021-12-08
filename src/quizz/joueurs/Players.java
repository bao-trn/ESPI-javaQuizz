package quizz.joueurs;

import quizz.constants.themeConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Players {
    public static final List<Player> playerList = new ArrayList<>();
    public static final List<Player> selectedPlayers = new ArrayList<>();
    private int playerNumberIncrement = 100;



    public void addPlayer(Player player){
        player.setId(playerNumberIncrement);
        playerList.add(player);
        playerNumberIncrement += 10;
    }

    public int selectRandomPlayer(){
        Random random = new Random();
        return random.nextInt(playerList.size());
    }

    /**
     *
     * @return a list of 4 Unique players
     */
    public List<Player> selectPlayers(){
        Random random = new Random();
        while(selectedPlayers.size() < 4){
            int myRandom = random.nextInt(playerList.size());
            if (!selectedPlayers.contains(playerList.get(myRandom))){
                selectedPlayers.add(playerList.get(myRandom));
            }
        }
        return selectedPlayers;
    }



}

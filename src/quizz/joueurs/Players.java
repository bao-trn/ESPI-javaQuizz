package quizz.joueurs;

import quizz.Utils.RandomUtils;
import quizz.constants.themeConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Players {
    private final List<Player> playerList = new ArrayList<>(20);
    private final List<Player> selectedPlayers = new ArrayList<>(4);
    private int playerNumberIncrement = 100;


    public List<Player> getPlayerList() {
        return playerList;
    }

    public List<Player> getSelectedPlayers() {
        return selectedPlayers;
    }

    public int getPlayerNumberIncrement() {
        return playerNumberIncrement;
    }

    public void setPlayerNumberIncrement(int playerNumberIncrement) {
        this.playerNumberIncrement = playerNumberIncrement;
    }

    public void addPlayer(Player player){
        player.setId(playerNumberIncrement);
        playerList.add(player);
        playerNumberIncrement += 10;
    }

    public int selectRandomPlayer(){
        return RandomUtils.selectRandom(playerList.size());
    }

    /**
     *
     * @return a list of 4 Unique players
     */
    public List<Player> selectPlayers(){
        while(selectedPlayers.size() < 4){
            int myRandom = RandomUtils.selectRandom(playerList.size());
            if (!selectedPlayers.contains(playerList.get(myRandom))){
                playerList.get(myRandom).setState("selected");
                selectedPlayers.add(playerList.get(myRandom));
            }
        }
        return selectedPlayers;
    }



}

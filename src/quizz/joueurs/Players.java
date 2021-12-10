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

    public List<Player> getSelectedPlayers() {
        return selectedPlayers;
    }
    public List<Player> getPlayerList() { return playerList; }

    public void addPlayer(Player player){
        player.setId(playerNumberIncrement);
        playerList.add(player);
        playerNumberIncrement += 10;
    }


    /**
     *
     * @return a list of 4 random Unique players
     */
    public List<Player> selectPlayers(){
        while(selectedPlayers.size() < 4){
            int myRandom = RandomUtils.selectRandom(playerList.size());
            if (!selectedPlayers.contains(playerList.get(myRandom))){
                playerList.get(myRandom).setState("SELECTED");
                selectedPlayers.add(playerList.get(myRandom));
            }
        }
        return selectedPlayers;
    }

    public void displayPlayers(List<Player> list){
        for (Player player : list){
            System.out.println("["+ player.getName() +"] | " + player.getState() + " | score : " + player.getScore());
        }
        System.out.println(System.lineSeparator());
    }

    public int getMaxScore() {
        int max = 0;
        for (int i = 0; i < selectedPlayers.size(); i++) {
            if (selectedPlayers.get(i).getScore() >= max) {
                max = selectedPlayers.get(i).getScore();
            }
        }
        return max;
    }

    public void getWinners() {
        for (Player selectedPlayer : selectedPlayers) {
            if (selectedPlayer.getScore() == getMaxScore()) {
                selectedPlayer.setState("Winner");
            }
        }
    }

    public Player getLoser() {
        int min = 999;
        Player loser = null;
        for (Player selectedPlayer : selectedPlayers) {
            if (selectedPlayer.getScore() <= min) {
                min = selectedPlayer.getScore();
                loser = selectedPlayer;
            }
        }
        assert loser != null;
        loser.setState("LOSER");
        return loser;
    }

    public void resetState() {
        for (Player player : selectedPlayers){
            player.setState("");
        }
    }

}

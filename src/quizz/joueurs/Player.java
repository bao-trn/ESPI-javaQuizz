package quizz.joueurs;

import java.util.Scanner;


public class Player {
    private int score;
    private int id;
    private String state;

    public Player(){
        this.state = "waiting";
    }

    public String userInput(){
        Scanner myObj = new Scanner(System.in);
        String answer = myObj.nextLine();
        return answer;
    }

    @Override
    public String toString(){
        return "[id: " + id +" | Score: " + score + "]";
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

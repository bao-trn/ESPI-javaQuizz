package quizz.joueurs;

import java.util.Scanner;


public class Player {
    private String name;
    private int score;
    private int id;
    private String state;

    public Player(String name){
        this.name = name;
        this.state = "waiting";
    }

    public String userInput(){
        Scanner myObj = new Scanner(System.in);
        return myObj.nextLine();
    }


    public String getName() { return name; }

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

    public String getState() { return state; }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString(){
        return "[Name: "+ name + " | Id: " + id + " | Score: " + score + "]";
    }
}

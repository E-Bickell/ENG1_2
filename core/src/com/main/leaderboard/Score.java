package com.main.leaderboard;
//new code
public class Score {
    private String name;
    private int score;
    public Score() {
        this.name = "";
        this.score = 0;
    }
    public Score(String name, int score){
        this.name = name;
        this.score = score;
    }
    public String getName(){
        return name;
    }
    public int getScore(){
        return score;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setScore(int score) {
        this.score = score;
    }
}

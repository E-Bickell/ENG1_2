package com.main.leaderboard;

import java.util.ArrayList;
//new code
public class Leaderboard {
    private ArrayList<Score> scores;
    public ArrayList<Score> getScores() {
        return this.scores;
    }
    public void setScores(ArrayList<Score> scores){
        this.scores = scores;
    }
}

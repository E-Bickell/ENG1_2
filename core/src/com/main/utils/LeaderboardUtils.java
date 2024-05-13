package com.main.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.main.leaderboard.Leaderboard;
import com.main.leaderboard.Score;
import com.badlogic.gdx.utils.Json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class LeaderboardUtils {
    public static ArrayList<Score> LoadLeaderboard(String filename){
        Json json = new Json();
        FileHandle lbFile = Gdx.files.local(filename);
        String jsonLb = lbFile.readString();
        Leaderboard loadedLeaderboard = json.fromJson(Leaderboard.class, jsonLb);
        return loadedLeaderboard.getScores();
    }

    public static void writeToLeaderboard(ArrayList<Score> leaderboard, String name, int score, String filename) {
        Json json = new Json();
        Score playerScore = new Score();
        Leaderboard loadedLeaderboard = new Leaderboard();
        FileHandle lbFile = Gdx.files.local(filename);
        playerScore.setName(name);
        playerScore.setScore(score);
        leaderboard.add(playerScore);
        loadedLeaderboard.setScores(leaderboard);
        lbFile.writeString(json.toJson(loadedLeaderboard), false);
    }

    public static ArrayList<Score> sortLeaderboard(ArrayList<Score> leaderboard){
        Comparator<Score> comp = new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                int val1 = o1.getScore();
                int val2 = o2.getScore();
                if (val1 < val2){
                    return 1;
                } else if (val1 == val2) {
                    return 0;
                } else {
                    return -1;
                }
            }
        };
        leaderboard.sort(comp);
        return leaderboard;
    }
}

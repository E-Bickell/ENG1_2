package de.tomgrill.gdxtesting.utils;

import com.main.leaderboard.Score;
import com.main.utils.LeaderboardUtils;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class LeaderboardTests {
    @Test
    public void LeaderboardExists(){
        ArrayList<Score> scores = LeaderboardUtils.LoadLeaderboard("scores/GameLeaderboard.json");
        assertFalse("Leaderboard File Exists", scores.isEmpty());
    }

    @Test
    public void checkWriteToLeaderboard() {
        ArrayList<Score> scores1 = new ArrayList<Score>();
        scores1.add(new Score("Test1", 1));
        scores1.add(new Score("Test2", 3));
        LeaderboardUtils.writeToLeaderboard(scores1, "Test3", 2, "scores/TestLeaderboard.json");
        scores1.add(new Score("Test3", 2));
        ArrayList<Score> scores2 = LeaderboardUtils.LoadLeaderboard("scores/TestLeaderboard.json");
        for (int i = 0; i < 3; i++) {
            assertEquals(scores1.get(i).getName(), scores2.get(i).getName());
            assertEquals(scores1.get(i).getScore(), scores2.get(i).getScore());
        }
    }

    @Test
    public void checkSort() {
        ArrayList<Score> scores1 = LeaderboardUtils.LoadLeaderboard("scores/TestLeaderboard.json");
        ArrayList<Score> scores2 = new ArrayList<Score>();
        scores2.add(new Score("Test2", 3));
        scores2.add(new Score("Test3", 2));
        scores2.add(new Score("Test1", 1));
        scores1 = LeaderboardUtils.sortLeaderboard(scores1);
        for (int i = 0; i < 3; i++) {
            assertEquals(scores1.get(i).getName(), scores2.get(i).getName());
            assertEquals(scores1.get(i).getScore(), scores2.get(i).getScore());
        }
    }
}

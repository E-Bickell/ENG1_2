package de.tomgrill.gdxtesting.utils;

import com.badlogic.gdx.Gdx;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class LeaderboardTests {
    @Test
    public void leaderboardExists(){
        assertTrue("The leaderboard file exists", Gdx.files.local("/scores/GameLeaderboard.json").exists());
    }
}

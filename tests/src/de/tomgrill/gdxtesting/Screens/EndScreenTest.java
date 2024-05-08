package de.tomgrill.gdxtesting.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.main.Main;
import com.main.screens.EndScreen;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class EndScreenTest {
    Main game = new Main();
    ArrayList<String> streaks = new ArrayList<>();
    EndScreen end = new EndScreen(game, 0, streaks);

    @Test
    public void pressPlayAgain() {
        int playAgainX = (int)end.getButtonX();
        int playAgainY = (int)end.getPlayAgainButtonY();

        boolean boolResult = end.touchDown(playAgainX, playAgainY, 0, 0);
        assertTrue("true", boolResult);
    }

    @Test
    public void pressExitButton(){
        int exitX = (int)end.getButtonX();
        int exitY = (int)end.getExitButtonY();
        assertTrue("true", end.touchDown(exitX, exitY, 0, 0));
    }

}

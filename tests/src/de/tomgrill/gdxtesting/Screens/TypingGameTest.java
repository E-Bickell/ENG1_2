package de.tomgrill.gdxtesting.Screens;

import com.main.Main;
import com.main.screens.TypingGame;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class TypingGameTest {
    Main game = new Main();
    int studyDuration = 3;
    TypingGame TypingGameScreen = new TypingGame(game, studyDuration);

    @Test
    public void testGuessButton() {
        int x = (int)TypingGameScreen.getGuessButtonX();
        int y = (int)TypingGameScreen.getGuessButtonY();
        boolean boolResult = TypingGameScreen.touchDown(x,y,0,0);
        assertTrue("true", boolResult);

    }


}

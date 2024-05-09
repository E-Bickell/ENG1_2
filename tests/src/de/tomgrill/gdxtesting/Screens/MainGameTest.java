package de.tomgrill.gdxtesting.Screens;

import com.main.Main;
import com.main.screens.MainGameScreen;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class MainGameTest {
    Main game = new Main();
    MainGameScreen MainGame = new MainGameScreen(game);

    //Home button, popup button, within popup: back button, go/study button, duration up/down

    //durationUpButtonX, durationDownButtonX, durationButtonY: (Y's are the same) for durations
    //menuButtonY, menuButtonX: home button?
    //menuBackButtonX, activityButtonX, durationMenuButtonY: for popup menu buttons, Y is the same
    //where even is the popup button for the activity?
    @Test
    public void testDurationUp() {
        int x = (int) MainGame.getDurationUpButtonX();
        int y = (int) MainGame.getDurationButtonY();
        boolean boolResult = MainGame.touchDown(x, y, 0, 0);
        assertTrue("true", boolResult);
    }
    @Test
    public void testDurationDown() {
        int x = (int) MainGame.getDurationDownButtonX();
        int y = (int) MainGame.getDurationButtonY();
        boolean boolResult = MainGame.touchDown(x, y, 0, 0);
        assertTrue("true", boolResult);
    }
    @Test
    public void testBackButton() {
        int x = (int) MainGame.getMenuBackButtonX();
        int y = (int) MainGame.getDurationMenuButtonY();
        boolean boolResult = MainGame.touchDown(x, y, 0, 0);
        assertTrue("true", boolResult);
    }
    @Test
    public void testActivityButton() {
        int x = (int) MainGame.getActivityButtonX();
        int y = (int) MainGame.getDurationMenuButtonY();
        boolean boolResult = MainGame.touchDown(x, y, 0, 0);
        assertTrue("true", boolResult);
    }
    @Test
    public void testMenuButton() {
        int x = (int) MainGame.getMenuButtonX();
        int y = (int) MainGame.getMenuButtonY();
        boolean boolResult = MainGame.touchDown(x, y, 0, 0);
        assertTrue("true", boolResult);
    }
}
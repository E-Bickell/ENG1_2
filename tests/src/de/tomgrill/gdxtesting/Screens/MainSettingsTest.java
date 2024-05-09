package de.tomgrill.gdxtesting.Screens;

import com.main.Main;
import com.main.screens.MainSettingsScreen;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class MainSettingsTest {
    Main game = new Main();
    MainSettingsScreen MainSettings = new MainSettingsScreen(game);

    @Test
    public void testMusicDown() {
        int x = (int)MainSettings.getMusicDownButtonX();
        int y = (int)MainSettings.getMusicDownButtonY();
        boolean boolResult = MainSettings.touchDown(x,y,0,0);
        assertTrue("true", boolResult);
    }
    @Test
    public void testMusicUp() {
        int x = (int)MainSettings.getMusicUpButtonX();
        int y = (int)MainSettings.getMusicUpButtonY();
        boolean boolResult = MainSettings.touchDown(x,y,0,0);
        assertTrue("true", boolResult);
    }
    @Test
    public void testSoundDown() {
        int x = (int)MainSettings.getSoundDownButtonX();
        int y = (int)MainSettings.getSoundDownButtonY();
        boolean boolResult = MainSettings.touchDown(x,y,0,0);
        assertTrue("true", boolResult);
    }
    @Test
    public void testSoundUp() {
        int x = (int)MainSettings.getSoundUpButtonX();
        int y = (int)MainSettings.getSoundUpButtonY();
        boolean boolResult = MainSettings.touchDown(x,y,0,0);
        assertTrue("true", boolResult);
    }
    @Test
    public void testBackButton() {
        int x = (int)MainSettings.getBackButtonX();
        int y = (int)MainSettings.getBackButtonY();
        boolean boolResult = MainSettings.touchDown(x,y,0,0);
        assertTrue("true", boolResult);
    }
    @Test
    public void testBoyButton() {
        int x = (int)MainSettings.getBoyButtonX();
        int y = (int)MainSettings.getBoyButtonY();
        boolean boolResult = MainSettings.touchDown(x,y,0,0);
        assertTrue("true", boolResult);
    }
    @Test
    public void testGirlButton() {
        int x = (int)MainSettings.getGirlButtonX();
        int y = (int)MainSettings.getGirlButtonY();
        boolean boolResult = MainSettings.touchDown(x,y,0,0);
        assertTrue("true", boolResult);
    }


}

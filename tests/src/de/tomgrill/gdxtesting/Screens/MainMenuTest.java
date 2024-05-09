package de.tomgrill.gdxtesting.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.main.Main;
import com.main.screens.MainMenuScreen;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(GdxTestRunner.class)
public class MainMenuTest {
    Main game = new Main();
    MainMenuScreen mainMenu = new MainMenuScreen(game);

    @Test
    public void testPlayButton(){
        int x = mainMenu.getX();
        int y = (int)mainMenu.getPlayButtonY();

        boolean boolResult = mainMenu.touchDown(x, y, 0,0);

        assertTrue("true", boolResult);
    }
    @Test
    public void testExitButton(){
        int x = mainMenu.getX();
        int y = (int)mainMenu.getExitButtonY();

        boolean boolResult = mainMenu.touchDown(x, y, 0,0);

        assertTrue("true", boolResult);
    }
    @Test
    public void testControlsButton(){
        int x = mainMenu.getX();
        int y = (int)mainMenu.getControlsButtonY();

        boolean boolResult = mainMenu.touchDown(x, y, 0,0);

        assertTrue("true", boolResult);
    }
    @Test
    public void testSettingsButton(){
        int x = mainMenu.getX();
        int y = (int)mainMenu.getSettingsButtonY();

        boolean boolResult = mainMenu.touchDown(x, y, 0,0);

        assertTrue("true", boolResult);
    }
}

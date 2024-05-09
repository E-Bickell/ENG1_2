package de.tomgrill.gdxtesting.Screens;

import com.main.Main;
import com.main.screens.MainControlScreen;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;
@RunWith(GdxTestRunner.class)
public class MainControlTest {
    Main game = new Main();
    MainControlScreen MainControl = new MainControlScreen(game);

    @Test
    public void testBackButton() {
        int x = (int)MainControl.getBackButtonX();
        int y = (int)MainControl.getBackButtonY();
        boolean boolResult = MainControl.touchDown(x,y,0,0);
        assertTrue("true", boolResult);
    }


}

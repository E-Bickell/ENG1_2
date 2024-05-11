package de.tomgrill.gdxtesting.utils;

import com.main.Main;
import com.main.screens.MainGameScreen;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(GdxTestRunner.class)

public class ScoringTests {

    Main game = new Main();
    MainGameScreen gameScreen = new MainGameScreen(game);
    @Test
    public void testNoActions(){
        gameScreen.setCurrentHour(24);
         gameScreen.setdayNum(7);
         assertEquals(gameScreen.getScore(),0);
    }
    @Test
    public void testPerfect(){
        ArrayList<String> studied = new ArrayList<String>();
        studied.add(0,"1");
        studied.add(1,"0");
        gameScreen.addStudyTimes(studied);
        gameScreen.addStudyTimes(studied);
        gameScreen.addStudyTimes(studied);
        studied.add(1,"1");
        ArrayList<String> eaten= new ArrayList<String>();
        eaten.add(0,"1");
        eaten.add(1,"0");
        gameScreen.addeatTimes(eaten);
        gameScreen.addeatTimes(eaten);
        gameScreen.addRecTimes(eaten);
        gameScreen.addRecTimes(eaten);
        gameScreen.addRecTimes(eaten);
        for (int i=1;i<8;i++){
            studied.add(0,Integer.toString(i));

            gameScreen.addStudyTimes(studied);
            eaten.add(0,Integer.toString(i));
            gameScreen.addeatTimes(eaten);
            gameScreen.addeatTimes(eaten); 
            gameScreen.addRecTimes(eaten);
        }
        gameScreen.setCurrentHour(24);
        gameScreen.setdayNum(7);
        assertEquals(gameScreen.getScore(),96);

    }
}




package de.tomgrill.gdxtesting.utils;

import com.main.Main;
import com.main.screens.MainGameScreen;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)

public class streakTests {
    Main game = new Main();
    MainGameScreen gameScreen = new MainGameScreen(game);
    @Test
    public void GymRat(){
        ArrayList<String> gyms=new ArrayList<String>();
        gyms.add("1");
        gyms.add("Gym_door");
        for (int i=0;i<10;i++){
            gameScreen.addRecTimes(gyms);;
        }
        gameScreen.setCurrentHour(24);
        gameScreen.setdayNum(7);
        assertTrue(gameScreen.inStreaks("Gym Rat"));

    }

    @Test
    public void PiazzaStreak(){
        ArrayList<String> gyms=new ArrayList<String>();
        gyms.add("1");
        gyms.add("Piazza_door");
        for (int i=0;i<10;i++){
            gameScreen.addStudyTimes(gyms);
        }
        gameScreen.setCurrentHour(24);
        gameScreen.setdayNum(7);
        assertTrue(gameScreen.inStreaks("The Pizza Building"));

    }

    @Test
    public void CompSciStreak(){
        ArrayList<String> gyms=new ArrayList<String>();
        gyms.add("1");
        gyms.add("Comp_sci_door");
        for (int i=0;i<10;i++){
            gameScreen.addStudyTimes(gyms);
        }
        gameScreen.setCurrentHour(24);
        gameScreen.setdayNum(7);
        assertTrue(gameScreen.inStreaks("Hi,I'm Pepper"));

    }
}

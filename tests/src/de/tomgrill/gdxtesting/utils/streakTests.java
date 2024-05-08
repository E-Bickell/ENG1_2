package de.tomgrill.gdxtesting.utils;

import com.main.screens.MainGameScreen.java;
import com.badlogic.gdx.Game;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(GdxTestRunner.class)

public class streakTests {
    Game game=new Game();
    MainGameScreen gameScreen=new MainGameScreen(game);
    @Test
    public void GymRat(){
        ArrayList<String> gyms=new ArrayList<String>();
        gyms.add("1");
        gyms.add("Gym_door");
        for (int i=0;i<10;i++){
            gameScreen.recActivtities.add(gyms);
        }
        gameScreen.dayNum=7;
        assertEquals(true,gameScreen.streaks.contains("Gym Rat"));

    }

    @Test
    public void PiazzaStreak(){
        ArrayList<String> gyms=new ArrayList<String>();
        gyms.add("1");
        gyms.add("Piazza_door");
        for (int i=0;i<10;i++){
            gameScreen.studyTimes.add(gyms);
        }
        gameScreen.dayNum=7;
        assertEquals(true,gameScreen.streaks.contains("The Pizza Building"));

    }

    @Test
    public void CompSciStreak(){
        ArrayList<String> gyms=new ArrayList<String>();
        gyms.add("1");
        gyms.add("Comp_sci_door");
        for (int i=0;i<10;i++){
            gameScreen.studyTimes.add(gyms);
        }
        gameScreen.dayNum=7;
        assertEquals(true,gameScreen.streaks.contains("Hi,I'm Pepper"));

    }
}

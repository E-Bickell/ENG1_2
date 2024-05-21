package de.tomgrill.gdxtesting.utils;

import com.main.Main;
import com.main.screens.MainGameScreen;
import com.main.utils.ScoreUtils;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)

public class streakTests {

    @Test
    public void piazzaDor(){
        ScoreUtils score = new ScoreUtils();
        ArrayList<String> gyms=new ArrayList<String>();
        gyms.add("1");
        gyms.add("Piazza_door");
        for (int i=0;i<10;i++){
            score.study(gyms);
        }
        score.calculateFinalScore();
        assertTrue("streak size="+(score.getStudyTimes().size()),score.getStreaks().contains("The Pizza Building"));

    }

    @Test
    public void GymRat(){
        ScoreUtils score = new ScoreUtils();
        ArrayList<String> gyms=new ArrayList<String>();
        gyms.add("1");
        gyms.add("Gym_door");
        for (int i=0;i<10;i++){
            score.addRecActivtity(gyms);
        }
        score.calculateFinalScore();
        assertTrue(score.getStreaks().contains("Gym Rat"));

    }
    @Test
    public void CompSciStreak(){
        ScoreUtils score = new ScoreUtils();
        ArrayList<String> gyms=new ArrayList<String>();
        gyms.add("1");
        gyms.add("Comp_sci_door");
        for (int i=0;i<10;i++){
            score.study(gyms);
        }
        score.calculateFinalScore();
        assertTrue(score.getStreaks().contains("Hi,I'm Pepper"));

    }
}

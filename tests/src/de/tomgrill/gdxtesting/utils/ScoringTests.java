package de.tomgrill.gdxtesting.utils;

import com.main.Main;
import com.main.screens.MainGameScreen;
import com.main.utils.ScoreUtils;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(GdxTestRunner.class)

public class ScoringTests {

    @Test
    public void testNoActions(){
        ScoreUtils score = new ScoreUtils();
        assertEquals(score.calculateFinalScore(), 0);
    }
    @Test
    public void testPerfect(){
        ArrayList<String> studied = new ArrayList<String>();
        ScoreUtils score = new ScoreUtils();
        studied.add(0,"1");
        studied.add(1,"0");
        score.study(studied);
        score.study(studied);
        score.study(studied);
        studied.add(1,"1");
        ArrayList<String> eaten= new ArrayList<String>();
        eaten.add(0,"1");
        eaten.add(1,"0");
        score.eat(eaten);
        score.eat(eaten);
        score.eat(eaten);
        score.eat(eaten);
        score.eat(eaten);
        for (int i=1;i<8;i++){
            studied.add(0,Integer.toString(i));

            score.study(studied);
            eaten.add(0,Integer.toString(i));
            score.eat(eaten);
            score.eat(eaten);
            score.eat(eaten);
        }
        assertEquals(score.calculateFinalScore(),96);

    }
}




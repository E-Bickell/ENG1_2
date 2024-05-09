package de.tomgrill.gdxtesting.utils;

import com.main.screens.MainGameScreen.java;
import com.badlogic.gdx.Game;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(GdxTestRunner.class)

public class ScoringTests {
<<<<<<< Updated upstream
    Game game=new Game();
    MainGameScreen gameScreen=new MainGameScreen(game);
    @Test
    public void testNoActions(){
         gameScreen.dayNum=7;
         assertEquals(gameScreen.score,0);
    }
    @Test
    public void testPerfect(){
        ArrayList<String> studied = new ArrayList<String>();
        studied.add(0,"1");
        studied.add(1,"0");
        gameScreen.studyTimes.add(studied);
        gameScreen.studyTimes.add(studied);
        gameScreen.studyTimes.add(studied);
        studied.add(1,"1");
        ArrayList<String> eaten= new ArrayList<String>();
        eaten.add(0,"1");
        eaten.add(1,"0");
        gameScreen.meals.add(eaten);
        gameScreen.meals.add(eaten);
        gameScreen.recActivtities.add(eaten);
        gameScreen.recActivtities.add(eaten);
        gameScreen.recActivtities.add(eaten);
        for (int i=1;i<8;i++){
            studied.add(0,Integer.toString(i));

            gameScreen.studyTimes.add(studied);
            eaten.add(0,Integer.toString(i));
            gameScreen.meals.add(eaten);
            gameScreen.meals.add(eaten); 
            gameScreen.recActivtities.add(eaten);
        }
        gameScreen.dayNum=7;
        assertEquals(gameScreen.score,96);

    }
=======
    // MainGameScreen gameScreen=new MainGameScreen(game);
    // @Test
    // public void testNoActions(){
    //     game.dayNum=7;
    //     assertEquals(game.score,0);
    // }
>>>>>>> Stashed changes

}

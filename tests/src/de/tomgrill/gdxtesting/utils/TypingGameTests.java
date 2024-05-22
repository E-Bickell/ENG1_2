package de.tomgrill.gdxtesting.utils;

import com.main.utils.TypingGameUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class TypingGameTests {
    @Test
    public void noCorrect(){
        TypingGameUtils typeUtils = new TypingGameUtils(3);
        typeUtils.generateNumber();
        typeUtils.setUserGuess("0");
        assertFalse("No correct guesses", typeUtils.validate());
    }

    @Test
    public void oneCorrect(){
        TypingGameUtils typeUtils = new TypingGameUtils(3);
        typeUtils.generateNumber();
        String userGuess = String.valueOf(typeUtils.getCurrentNumber());
        typeUtils.setUserGuess(userGuess);
        assertTrue("Correct Guess", typeUtils.validate());
    }

    @Test
    public void multipleCorrect(){
        TypingGameUtils typeUtils = new TypingGameUtils(3);
        for (int i = 0; i < 3; i++) {
            typeUtils.generateNumber();
            String userGuess = String.valueOf(typeUtils.getCurrentNumber());
            typeUtils.setUserGuess(userGuess);
            typeUtils.validate();
            typeUtils.resetGame();
        }
        assertEquals(typeUtils.getCorrect(), 3);
    }

    @Test
    public void mixedCorrect(){
        TypingGameUtils typeUtils = new TypingGameUtils(3);

        typeUtils.generateNumber();
        String userGuess = String.valueOf(typeUtils.getCurrentNumber());
        typeUtils.setUserGuess(userGuess);
        typeUtils.validate();
        typeUtils.resetGame();

        typeUtils.generateNumber();
        typeUtils.setUserGuess("0");
        typeUtils.validate();

        assertEquals(typeUtils.getCorrect(), 1);
    }
}

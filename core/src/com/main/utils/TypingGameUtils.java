package com.main.utils;

import java.util.concurrent.ThreadLocalRandom;

public class TypingGameUtils {
    private final int studyDuration;
    private int attempts = 0;
    private int currentNumber = 0;
    private int correct = 0;
    private String userGuess = "";

    public TypingGameUtils(int studyDuration){
        this.studyDuration = studyDuration;
    }
    public void resetGame(){
        userGuess = "";
    }
    public void generateNumber() {
        int startingNumLength = 5;
        int startingNum = (int) (10 * Math.pow(10, startingNumLength - 1));
        int lowerLimit = (int) (startingNum * Math.pow(10, attempts - 1));
        currentNumber = ThreadLocalRandom.current().nextInt(lowerLimit, lowerLimit * 10 - 1);
        attempts++;
    }
    public void adjustGuess(char character){
        if (character == '\b' && !userGuess.isEmpty()) { // Handles backspace
            userGuess = userGuess.substring(0, userGuess.length() - 1);
        } else if (Character.isDigit(character) && userGuess.length() < String.valueOf(currentNumber).length()) {
            userGuess += character;
        }
    }
    public boolean validate() {
        if (Integer.parseInt(userGuess) == currentNumber) {
            correct = correct + 1;
            return true;
        } else {
            return false;
        }
    }
    public int getStudyDuration() {
        return studyDuration;
    }
    public void setUserGuess(String userGuess) {
        this.userGuess = userGuess;
    }
    public int getAttempts(){
        return attempts;
    }
    public int getCurrentNumber(){
        return currentNumber;
    }
    public int getCorrect(){
        return correct;
    }
    public String getUserGuess(){
        return userGuess;
    }
}

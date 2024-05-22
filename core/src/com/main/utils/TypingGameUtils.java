package com.main.utils;

import java.util.concurrent.ThreadLocalRandom;

public class TypingGameUtils {
    private final int studyDuration;
    private int attempts = 0;
    private int currentNumber = 0;
    private int correct = 0;
    private String userGuess = "";

    /** Constructs a new TypingGameUtils class - new code
     * @param studyDuration max time to study
     */
    public TypingGameUtils(int studyDuration){
        this.studyDuration = studyDuration;
    }

    /** Resets the userGuess to blank - new code
     */
    public void resetGame(){
        userGuess = "";
    }

    /** Generates a new number - new code
     */
    public void generateNumber() {
        int startingNumLength = 5;
        int startingNum = (int) (10 * Math.pow(10, startingNumLength - 1));
        int lowerLimit = (int) (startingNum * Math.pow(10, attempts - 1));
        currentNumber = ThreadLocalRandom.current().nextInt(lowerLimit, lowerLimit * 10 - 1);
        attempts++;
    }

    /** Adds a character to the string - new code
     * @param character character to be added
     */
    public void adjustGuess(char character){
        if (character == '\b' && !userGuess.isEmpty()) { // Handles backspace
            userGuess = userGuess.substring(0, userGuess.length() - 1);
        } else if (Character.isDigit(character) && userGuess.length() < String.valueOf(currentNumber).length()) {
            userGuess += character;
        }
    }

    /** Checks if the guess is equal to the generated number - new code
     * @return boolean for whether they are equal or not
     */
    public boolean validate() {
        if (Integer.parseInt(userGuess) == currentNumber) {
            correct = correct + 1;
            return true;
        } else {
            return false;
        }
    }

    /** returns study duration - new code
     * @return int studyDuration
     */
    public int getStudyDuration() {
        return studyDuration;
    }

    /** replaces the user guess (for testing purposes) - new code
     * @param userGuess the new user guess
     */
    public void setUserGuess(String userGuess) {
        this.userGuess = userGuess;
    }

    /** returns number of attempts - new code
     * @return int attempts
     */
    public int getAttempts(){
        return attempts;
    }

    /** returns current generated number - new code
     * @return int currentNumber
     */
    public int getCurrentNumber(){
        return currentNumber;
    }

    /** returns how many you got correct - new code
     * @return int correct
     */
    public int getCorrect(){
        return correct;
    }

    /** returns the current user guess - new code
     * @return String userGuess
     */
    public String getUserGuess(){
        return userGuess;
    }
}

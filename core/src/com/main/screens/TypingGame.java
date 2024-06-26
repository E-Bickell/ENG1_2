package com.main.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.Timer;
import com.main.Main;
import com.main.utils.ScreenType;
import com.main.utils.TypingGameUtils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The TypingGame class implements a mini-game for the player to increase their
 * study hours.
 * Players are shown a number that they need to memorize and then type it
 * correctly to succeed.
 */
public class TypingGame implements Screen, InputProcessor {
    private final Main game;
    private final Texture guessButton;
    private TypingGameUtils typeUtils;
    Boolean acceptInput = false, displayCorrect = false, displayWrong = false;
    BitmapFont displayText;
    private float displayTextY, displayTextHeight;
    private float gameObjectiveY;
    private float guessButtonX, guessButtonY, guessButtonWidth, guessButtonHeight;
    private final Texture title;
    private float titleX, titleY, titleWidth, titleHeight;
    String gameObjective;

    /**
     * Constructs a TypingGame screen with the game instance and study duration.
     *
     * @param game          The main game instance.
     * @param studyDuration The duration of the study session in attempts.
     */
    public TypingGame(Main game, int studyDuration) {
        this.game = game;
        displayText = new BitmapFont(Gdx.files.internal("font/WhitePeaberry.fnt"));
        guessButton = new Texture("mini_games/guess_button.png");
        title = new Texture("mini_games/number_memoriser_label.png");

        calculateDimensions();
        calculatePositions();

        Gdx.input.setInputProcessor(this);
        typeUtils = new TypingGameUtils(studyDuration);

        gameObjective = "Remember the number given and try to input the number from memory";

        playGame();
    }

    private void calculateDimensions() {
        displayText.getData().setScale(3f * game.scaleFactorX, 3f * game.scaleFactorY);
        displayTextHeight = 100 * game.scaleFactorY;
        gameObjectiveY = game.screenHeight - 280 * game.scaleFactorY;
        guessButtonWidth = 156 * game.scaleFactorX;
        guessButtonHeight = 84 * game.scaleFactorY;
        titleWidth = title.getWidth() * game.scaleFactorX * 11;
        titleHeight = title.getHeight() * game.scaleFactorY * 11;
    }

    private void calculatePositions() {
        displayTextY = game.screenHeight / 2f - displayTextHeight;
        guessButtonX = (game.screenWidth - guessButtonWidth) / 2f;
        guessButtonY = (game.screenHeight - guessButtonHeight) / 2f - 300 * game.scaleFactorY;
        titleX = (game.screenWidth - titleWidth) / 2f;
        titleY = (game.screenHeight - titleHeight) / 2f + 400 * game.scaleFactorY;
    }

    /**
     * Begins a new challenge by generating a number for the player to memorize.
     * Handles the logic for correct and incorrect guesses and progresses the game.
     * Adjusted to move some code to TypingGameUtils
     */
    public void playGame() {
        typeUtils.resetGame();
        displayWrong = false;
        displayCorrect = false;
        if (typeUtils.getAttempts() < typeUtils.getStudyDuration()) {
            typeUtils.generateNumber();
            delay(5, this::makeUserGuess);
        } else {
            game.screenManager.setScreen(ScreenType.GAME_SCREEN);
        }
    }

    /**
     * Allows the player to input their guess after a short delay.
     */
    public void makeUserGuess() {
        acceptInput = true;
    }

    /**
     * Implements a delay before executing a given runnable task.
     *
     * @param seconds  The delay in seconds before running the task.
     * @param runnable The task to execute after the delay.
     */
    public void delay(int seconds, Runnable runnable) {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                runnable.run();
            }
        }, seconds);
    }

    @Override
    public void show() {
        game.batch.setProjectionMatrix(game.defaultCamera.combined);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.3f, 0.55f, 0.7f, 1);
        game.batch.setProjectionMatrix(game.defaultCamera.combined);
        game.batch.begin();
        game.batch.draw(title, titleX, titleY, titleWidth, titleHeight);
        displayText.draw(game.batch, gameObjective, 0, gameObjectiveY, game.screenWidth, Align.center, false);
        if (acceptInput) {
            displayText.draw(game.batch, typeUtils.getUserGuess(), 0, displayTextY, game.screenWidth, Align.center, false);
            game.batch.draw(guessButton, guessButtonX, guessButtonY, guessButtonWidth, guessButtonHeight);
        } else if (displayCorrect) {
            displayText.draw(game.batch, "Correct well done.", 0, displayTextY, game.screenWidth, Align.center, false);
        } else if (displayWrong) {
            displayText.draw(game.batch, "Incorrect. Answer: " + typeUtils.getCurrentNumber(), 0, displayTextY, game.screenWidth,
                    Align.center, false);
        } else {
            displayText.draw(game.batch, String.valueOf(typeUtils.getCurrentNumber()), 0, displayTextY, game.screenWidth, Align.center,
                    false);
        }
        game.batch.end();
    }

    public float getGuessButtonX() {return guessButtonX;}
    public float getGuessButtonY() {return guessButtonY;}

    @Override
    public void resize(int width, int height) {
        calculateDimensions();
        calculatePositions();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        guessButton.dispose();
        title.dispose();
        displayText.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        if (acceptInput) {
            typeUtils.adjustGuess(character);
        }
        return true;
    }

    @Override
    public boolean touchDown(int worldX, int worldY, int pointer, int button) {
        worldY = game.screenHeight - worldY;

        if (worldX >= guessButtonX && worldX <= guessButtonX + guessButtonWidth &&
                worldY >= guessButtonY && worldY <= guessButtonY + guessButtonHeight) {

            if (!typeUtils.getUserGuess().isEmpty()) {
                acceptInput = false;
                if (typeUtils.validate()) {
                    displayCorrect = true;
                } else {
                    displayWrong = true;
                }
                delay(2, this::playGame);
            }

        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}

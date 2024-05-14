package com.main.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.main.Main;
import com.badlogic.gdx.InputProcessor;
import com.main.utils.ScreenType;

/**
 * The MainMenuScreen class represents the main menu screen for the game.
 * It handles the display and interaction with the main menu, including navigating to different parts of the game
 * such as starting the gameplay, viewing controls, adjusting settings, or exiting the game.
 */
public class MainMenuScreen implements Screen, InputProcessor {

    Main game;

    Texture heslingtonHustleLabel, playButton, controlsButton, settingsButton, exitButton, leaderboardButton;

    int heslingtonHustleLabelHeight, playButtonHeight, controlsButtonHeight, settingsButtonHeight, exitButtonHeight, leaderButtonHeight;
    int heslingtonHustleLabelWidth, playButtonWidth, controlsButtonWidth, settingsButtonWidth, exitButtonWidth, leaderButtonWidth;

    int x;
    float heslingtonHustleLabelX, leaderButtonX;
    float heslingtonHustleLabelY, playButtonY, controlsButtonY, settingsButtonY, exitButtonY, leaderButtonY;

    boolean exitFlag;

    /**
     * Constructs a MainMenuScreen with the specified game instance.
     * Initializes UI elements and calculates their positions.
     *
     * @param game the game instance this screen belongs to.
     */
    public MainMenuScreen(Main game) {
        this.game = game;

        loadTextures();
        calculateDimensions();
        calculatePositions();
    }

    /**
     * Loads textures for UI elements from the assets directory.
     */
    private void loadTextures() {
        heslingtonHustleLabel = new Texture("menu_gui/heslington_hustle_label.png");
        playButton = new Texture("menu_gui/play_button.png");
        controlsButton = new Texture("menu_gui/controls_button.png");
        settingsButton = new Texture("menu_gui/settings_button.png");
        exitButton = new Texture("menu_gui/exit_button.png");
        leaderboardButton = new Texture("leaderboard_gui/Leaderboard_icon.png");
    }

    /**
     * Calculates the dimensions of buttons based on their textures.
     */
    private void calculateDimensions() {
        heslingtonHustleLabelHeight = (int) (heslingtonHustleLabel.getHeight() * 10 * game.scaleFactorY);
        heslingtonHustleLabelWidth = (int) (heslingtonHustleLabel.getWidth() * 10 * game.scaleFactorX);
        playButtonHeight = (int) (playButton.getHeight() * 10 * game.scaleFactorY);
        playButtonWidth = (int) (playButton.getWidth() * 10 * game.scaleFactorX);
        controlsButtonHeight = (int) (controlsButton.getHeight() * 10 * game.scaleFactorY);
        controlsButtonWidth = (int) (controlsButton.getWidth() * 10 * game.scaleFactorX);
        settingsButtonHeight = (int) (settingsButton.getHeight() * 10 * game.scaleFactorY);
        settingsButtonWidth = (int) (settingsButton.getWidth() * 10 * game.scaleFactorX);
        exitButtonHeight = (int) (exitButton.getHeight() * 10 * game.scaleFactorY);
        exitButtonWidth = (int) (exitButton.getWidth() * 10 * game.scaleFactorX);
        leaderButtonHeight = (int) (leaderboardButton.getHeight() * 10 * game.scaleFactorY);
        leaderButtonWidth = (int) (leaderboardButton.getWidth() * 10 * game.scaleFactorX);
    }

    /**
     * Calculates the positions of buttons to be drawn on the screen.
     */
    private void calculatePositions() {
        heslingtonHustleLabelX = (game.screenWidth - heslingtonHustleLabelWidth) / 2f;
        x = (int) ((game.screenWidth - playButtonWidth) / 2f); // this is to make sure the buttons are centered
        leaderButtonX = game.screenWidth - (leaderButtonWidth + (50 * game.scaleFactorX));
        heslingtonHustleLabelY = game.screenHeight - heslingtonHustleLabelHeight * 1.25f;
        playButtonY = game.screenHeight - playButtonHeight * 2.5f;
        controlsButtonY = game.screenHeight - controlsButtonHeight * 3.75f;
        settingsButtonY = game.screenHeight - settingsButtonHeight * 5f;
        exitButtonY = game.screenHeight - exitButtonHeight * 6.25f;
        leaderButtonY = 50 * game.scaleFactorY;
    }

    public float getPlayButtonY(){
        return playButtonY;
    }
    public float getExitButtonY(){
        return exitButtonY;
    }
    public float getControlsButtonY(){
        return controlsButtonY;
    }
    public float getSettingsButtonY(){
        return settingsButtonY;
    }
    public int getX(){
        return x;
    }


    @Override
    public void show() {
        game.batch.setProjectionMatrix(game.defaultCamera.combined);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        if (exitFlag) return;
        ScreenUtils.clear(0.3f, 0.55f, 0.7f, 1);
        game.batch.setProjectionMatrix(game.defaultCamera.combined);
        game.batch.setProjectionMatrix(game.defaultCamera.combined);
        game.batch.begin();
        game.batch.draw(heslingtonHustleLabel, heslingtonHustleLabelX, heslingtonHustleLabelY, heslingtonHustleLabelWidth, heslingtonHustleLabelHeight);
        game.batch.draw(playButton, x, playButtonY, playButtonWidth, playButtonHeight);
        game.batch.draw(controlsButton, x, controlsButtonY, controlsButtonWidth, controlsButtonHeight);
        game.batch.draw(settingsButton, x, settingsButtonY, settingsButtonWidth, settingsButtonHeight);
        game.batch.draw(exitButton, x, exitButtonY, exitButtonWidth, exitButtonHeight);
        game.batch.draw(leaderboardButton, leaderButtonX, leaderButtonY, leaderButtonWidth, leaderButtonHeight);
        game.batch.end();
    }

    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    public boolean touchDown(int touchX, int touchY, int pointer, int button) {
        touchY = game.screenHeight - touchY;

        if (touchX >= x && touchX <= x + playButtonWidth &&
                touchY >= playButtonY && touchY <= playButtonY + playButtonHeight) {
            game.gameData.buttonClickedSoundActivate();
            game.screenManager.setScreen(ScreenType.GAME_SCREEN);
        }
        else if (touchX >= x && touchX <= x + controlsButtonWidth &&
                touchY >= controlsButtonY && touchY <= controlsButtonY + controlsButtonHeight) {
            game.gameData.buttonClickedSoundActivate();
            game.screenManager.setScreen(ScreenType.CONTROLS);
        }
        else if (touchX >= x && touchX <= x + settingsButtonWidth &&
                touchY >= settingsButtonY && touchY <= settingsButtonY + settingsButtonHeight) {
            game.gameData.buttonClickedSoundActivate();
            game.screenManager.setScreen(ScreenType.SETTINGS);
        }
        else if (touchX >= x && touchX <= x + exitButtonWidth &&
                touchY >= exitButtonY && touchY <= exitButtonY + exitButtonHeight) {
            game.gameData.buttonClickedSoundActivate();
            game.screenManager.clearMemory();
            exitFlag = true;
            dispose();
            Gdx.app.exit();
        }
        else if (touchX >= leaderButtonX && touchX <= leaderButtonX + leaderButtonWidth && touchY >= leaderButtonY && touchY <= leaderButtonY + leaderButtonHeight) {
            game.gameData.buttonClickedSoundActivate();
            game.screenManager.setScreen(ScreenType.ADD_LEADERBOARD_ENTRY_SCREEN, 10);
        }
        return true;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }

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
        playButton.dispose();
        controlsButton.dispose();
        settingsButton.dispose();
        exitButton.dispose();
        heslingtonHustleLabel.dispose();
        leaderboardButton.dispose();
    }
}

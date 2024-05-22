package com.main.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.main.Main;
import com.main.leaderboard.Score;
import com.main.utils.LeaderboardUtils;
import com.main.utils.ScreenType;

import java.util.ArrayList;
//new code
public class AddLeaderboardEntryScreen implements Screen, InputProcessor {
    Main game;
    int score;
    String name = "";
    Texture enterButton, backButton, leaderboardLabel, nameBack;
    float enterButtonX, enterButtonY, backButtonX, backButtonY, labelX, labelY, textY, nameX, nameY;
    float enterButtonWidth, enterButtonHeight, backButtonWidth, backButtonHeight, labelWidth, labelHeight, nameWidth, nameHeight;
    BitmapFont font;
    ArrayList<Score> leaderboard;

    /**
     * Constructs an Add leaderboard Entry screen with the game instance.
     *
     * @param game          The main game instance.
     */
    public AddLeaderboardEntryScreen(Main game, int score){
        this.game = game;
        this.score = score;
        leaderboard = LeaderboardUtils.LoadLeaderboard("scores/GameLeaderboard.json");
        Gdx.input.setInputProcessor(this);

        loadAssets();
        calculateDimensions();
        calculatePositions();
    }

    /**
     * Loads textures for UI elements from the assets directory.
     */
    private void loadAssets(){
        font = new BitmapFont(Gdx.files.internal("font/WhitePeaberry.fnt"));
        font.setColor(Color.BLACK);
        enterButton = new Texture("add_to_leaderboard_gui/enter_button.png");
        backButton = new Texture("add_to_leaderboard_gui/back_button.png");
        leaderboardLabel = new Texture("add_to_leaderboard_gui/leaderboard_label.png");
        nameBack = new Texture("add_to_leaderboard_gui/Name_Tag_Base.png");
    }

    /**
     * Calculates the dimensions of the textures.
     */
    private void calculateDimensions(){
        enterButtonWidth = 200 * game.scaleFactorX;
        enterButtonHeight = 100 * game.scaleFactorY;
        backButtonWidth = 200 * game.scaleFactorX;
        backButtonHeight = 100 * game.scaleFactorY;
        labelWidth = leaderboardLabel.getWidth() * 5 * game.scaleFactorX;
        labelHeight = leaderboardLabel.getHeight() * 5 * game.scaleFactorY;
        nameWidth = nameBack.getWidth() * 5 * game.scaleFactorX;
        nameHeight = nameBack.getHeight() * 5 * game.scaleFactorY;
    }

    /**
     * Calculates the positions of the textures to be drawn on screen.
     */
    private void calculatePositions(){
        enterButtonX = (game.screenWidth - enterButtonWidth) / 2;
        enterButtonY = (float) game.screenHeight / 6 + (50 * game.scaleFactorY);
        backButtonX = (game.screenWidth - backButtonWidth) / 2;
        backButtonY = (float) game.screenHeight / 6 - (100 * game.scaleFactorY);
        labelX = (game.screenWidth - labelWidth) / 2;
        labelY = game.screenHeight - (labelHeight * 2);
        nameX = (game.screenWidth - nameWidth) / 2;
        nameY = labelY - (300 * game.scaleFactorY);
        textY = nameY + nameHeight;
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
    public boolean keyTyped(char character) {
        if (character == '\b' && !name.isEmpty()) { // Handles backspace
            name = name.substring(0, name.length() - 1);
        } else if (name.length() < 16) {
            name += character;
        }
        return true;
    }

    @Override
    public boolean touchDown(int touchX, int touchY, int pointer, int button) {
        touchY = (game.screenHeight - touchY);

        if (touchX >= backButtonX && touchX <= backButtonX + backButtonWidth &&
                touchY >= backButtonY && touchY <= backButtonY + backButtonHeight) {
            game.screenManager.setScreen(ScreenType.MAIN_MENU);
            game.gameData.buttonClickedSoundActivate();
        } else if (touchX >= enterButtonX && touchX <= enterButtonX + enterButtonWidth &&
                touchY >= enterButtonY && touchY <= enterButtonY + enterButtonHeight) {
            LeaderboardUtils.writeToLeaderboard(leaderboard, name, score, "scores/GameLeaderboard.json");
            game.screenManager.setScreen(ScreenType.LEADERBOARD_SCREEN);
            game.gameData.buttonClickedSoundActivate();
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
    public void show() {
        game.batch.setProjectionMatrix(game.defaultCamera.combined);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0.3f, 0.55f, 0.7f, 1);
        game.batch.setProjectionMatrix(game.defaultCamera.combined);
        game.batch.begin();
        game.batch.draw(leaderboardLabel, labelX, labelY, labelWidth, labelHeight);
        game.batch.draw(nameBack, nameX, nameY, nameWidth, nameHeight);
        game.batch.draw(enterButton, enterButtonX, enterButtonY, enterButtonWidth, enterButtonHeight);
        game.batch.draw(backButton, backButtonX, backButtonY, backButtonWidth, backButtonHeight);
        font.draw(game.batch, name, 0, textY, game.screenWidth, Align.center, false);
        game.batch.end();
    }

    @Override
    public void resize(int i, int i1) {
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
        font.dispose();
        leaderboardLabel.dispose();
        nameBack.dispose();
        enterButton.dispose();
        backButton.dispose();
    }
}

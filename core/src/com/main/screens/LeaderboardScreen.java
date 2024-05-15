package com.main.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;
import com.main.Main;
import com.main.leaderboard.Score;
import com.main.utils.LeaderboardUtils;
import com.main.utils.ScreenType;

import java.util.logging.FileHandler;

public class LeaderboardScreen implements Screen, InputProcessor {
    Main game;
    BitmapFont font;
    private Texture leaderboardLabel, positionBack, nameBack, scoreBack, backButton;
    private float backButtonX, backButtonY, leaderboardLabelX, leaderboardLabelY, textX;
    private float[] positionX, nameX, scoreX, boxY, textY;
    private float backButtonWidth, backButtonHeight, leaderboardLabelWidth, leaderboardLabelHeight, positionWidth, positionHeight, nameWidth, nameHeight, scoreWidth, scoreHeight;
    FileHandle lbFile;
    ArrayList<Score> leaderboard;
    public LeaderboardScreen(Main game){
        this.game = game;

        leaderboard = LeaderboardUtils.LoadLeaderboard("scores/GameLeaderboard.json");
        leaderboard = LeaderboardUtils.sortLeaderboard(leaderboard);

        loadAssets();
        calculateDimensions();
        calculatePositions();
    }

    private void loadAssets(){
        font = new BitmapFont(Gdx.files.internal("font/WhitePeaberry.fnt"));
        font.setColor(Color.BLACK);
        leaderboardLabel = new Texture(Gdx.files.internal("leaderboard_gui/leaderboard_label.png"));
        positionBack = new Texture(Gdx.files.internal("leaderboard_gui/Position_Base.png"));
        nameBack = new Texture(Gdx.files.internal("leaderboard_gui/Name_Tag_Base.png"));
        scoreBack = new Texture(Gdx.files.internal("leaderboard_gui/Score_Base.png"));
        backButton = new Texture(Gdx.files.internal("leaderboard_gui/back_button.png"));
    }

    private void calculateDimensions(){
        font.getData().setScale(1.5f * game.scaleFactorX, 1.5f * game.scaleFactorY);
        backButtonWidth = 200 * game.scaleFactorX;
        backButtonHeight = 100 * game.scaleFactorY;
        leaderboardLabelWidth = leaderboardLabel.getWidth() * 10 * game.scaleFactorX;
        leaderboardLabelHeight = leaderboardLabel.getHeight() * 10 * game.scaleFactorY;
        positionWidth = positionBack.getWidth() * 5 * game.scaleFactorX;
        positionHeight = positionBack.getHeight() * 5 * game.scaleFactorY;
        nameWidth = nameBack.getWidth() * 5 * game.scaleFactorX;
        nameHeight = nameBack.getHeight() * 5 * game.scaleFactorY;
        scoreWidth = scoreBack.getWidth() * 5 * game.scaleFactorX;
        scoreHeight = scoreBack.getHeight() * 5 * game.scaleFactorY;
    }

    private void calculatePositions(){
        backButtonX = (game.screenWidth - backButtonWidth) / 2;
        backButtonY = (float) game.screenHeight / 6 - (100 * game.scaleFactorY);
        leaderboardLabelX = (game.screenWidth - leaderboardLabelWidth) / 2;
        leaderboardLabelY =  game.screenHeight - (leaderboardLabelHeight * 2);

        positionX = new float[2];
        positionX[0] = (50 * game.scaleFactorX);
        positionX[1] = ((float) game.screenWidth / 2);

        nameX = new float[2];
        nameX[0] = positionX[0] + positionWidth + (25 * game.scaleFactorX);
        nameX[1] = positionX[1] + positionWidth + (25 * game.scaleFactorX);

        scoreX = new float[2];
        scoreX[0] = nameX[0] + nameWidth + (25 * game.scaleFactorX);
        scoreX[1] = nameX[1] + nameWidth + (25 * game.scaleFactorX);

        boxY = new float[5];
        textY = new float[5];
        boxY[0] = leaderboardLabelY - (90 * game.scaleFactorY);
        textY[0] = boxY[0] + positionHeight;
        for (int i = 1; i < 5; i++){
            boxY[i] = boxY[i-1] - (75 * game.scaleFactorY);
            textY[i] = boxY[i] + positionHeight;
        }

        textX = (positionWidth / 22 * 4);
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

    @Override
    public boolean touchDown(int touchX, int touchY, int pointer, int button) {
        touchY = (game.screenHeight - touchY);

        if (touchX >= backButtonX && touchX <= backButtonX + backButtonWidth &&
                touchY >= backButtonY && touchY <= backButtonY + backButtonHeight) {
            game.screenManager.setScreen(ScreenType.MAIN_MENU);
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
        game.batch.draw(leaderboardLabel, leaderboardLabelX, leaderboardLabelY, leaderboardLabelWidth, leaderboardLabelHeight);
        int num = 0;
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 5; j++) {
                game.batch.draw(positionBack, positionX[i], boxY[j], positionWidth, positionHeight);
                game.batch.draw(nameBack, nameX[i], boxY[j], nameWidth, nameHeight);
                game.batch.draw(scoreBack, scoreX[i], boxY[j], scoreWidth, scoreHeight);
                int val = num + 1;
                font.draw(game.batch, String.valueOf(val), positionX[i] + textX, textY[j]);
                font.draw(game.batch, String.valueOf(leaderboard.get(num).getName()), nameX[i] + textX, textY[j]);
                font.draw(game.batch, String.valueOf(leaderboard.get(num).getScore()), scoreX[i] + textX, textY[j]);
                num += 1;
            }
        }
        game.batch.draw(backButton, backButtonX, backButtonY, backButtonWidth, backButtonHeight);
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
        positionBack.dispose();
        nameBack.dispose();
        scoreBack.dispose();
        backButton.dispose();
    }
}

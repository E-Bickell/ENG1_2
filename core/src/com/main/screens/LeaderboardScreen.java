package com.main.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.main.Main;
import java.util.logging.FileHandler;

public class LeaderboardScreen implements Screen, InputProcessor {
    Main game;
    BitmapFont font;
    private final Texture leaderboardLabel, positionBack, nameBack, scoreBack, backButton;
    private float backButtonX, backButtonY, leaderboardLabelX, leaderboardLabelY;
    private float[] positionX, positionY, nameX, nameY, scoreX, scoreY;
    private float backButtonWidth, backButtonHeight, leaderboardLabelWidth, leaderboardLabelHeight, positionWidth, positionHeight, nameWidth, nameHeight, scoreWidth, scoreHeight;
    FileHandle lbFile;
    ArrayList<String[]> leaderboard;
    public LeaderboardScreen(Main game){
        this.game = game;
        font = new BitmapFont(Gdx.files.internal("font/WhitePeaberry.fnt"));

        leaderboard = new ArrayList<>();
        LoadLeaderboard();

        leaderboardLabel = new Texture(Gdx.files.internal("leaderboard_gui/leaderboard_label.png"));
        positionBack = new Texture(Gdx.files.internal("leaderboard_gui/Position_Base.png"));
        nameBack = new Texture(Gdx.files.internal("leaderboard_gui/Name_Tag_Base.png"));
        scoreBack = new Texture(Gdx.files.internal("leaderboard_gui/Score_Base.png"));
        backButton = new Texture(Gdx.files.internal("leaderboard_gui/back_button.png"));

        calculateDimensions();
    }

    private void LoadLeaderboard(){
        lbFile = Gdx.files.internal("GameLeaderboard.csv");
        String text = lbFile.readString();

        String textArray[] = text.split("\\n");
        for (String line : textArray) {
            String[] values = line.split(",");
            leaderboard.add(values);
        }
    }

    private void calculateDimensions(){
        font.getData().setScale(1.5f * game.scaleFactorX, 1.5f * game.scaleFactorY);
        backButtonWidth = backButton.getWidth() * 10 * game.scaleFactorX;
        backButtonHeight = backButton.getHeight() * 10 * game.scaleFactorY;
        leaderboardLabelWidth = leaderboardLabel.getWidth() * 10 * game.scaleFactorX;
        leaderboardLabelHeight = leaderboardLabel.getHeight() * 10 * game.scaleFactorY;
        positionWidth = positionBack.getWidth() * 10 * game.scaleFactorX;
        positionHeight = positionBack.getHeight() * 10 * game.scaleFactorY;
        nameWidth = nameBack.getWidth() * 10 * game.scaleFactorX;
        nameHeight = nameBack.getHeight() * 10 * game.scaleFactorY;
        scoreWidth = scoreBack.getWidth() * 10 * game.scaleFactorX;
        scoreHeight = scoreBack.getHeight() * 10 * game.scaleFactorY;
    }

    private void calculatePositions(){
        backButtonX = (game.screenWidth - backButtonWidth) / 2;
        backButtonY = (float) game.screenHeight / 6 - (100 * game.scaleFactorY);
        leaderboardLabelX = (game.screenWidth - leaderboardLabelWidth) / 2;
        leaderboardLabelY =  game.screenHeight - (leaderboardLabelHeight * 2);

        positionX = new float[2];
        positionY = new float[5];
        nameX = new float[2];
        nameY = new float[5];
        scoreX = new float[2];
        scoreY = new float[5];
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
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
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

    }

    @Override
    public void render(float v) {

    }

    @Override
    public void resize(int i, int i1) {

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

    }
}

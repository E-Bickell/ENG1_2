package com.main.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.main.Main;
import com.main.leaderboard.Score;
import com.main.utils.LeaderboardUtils;

import java.util.ArrayList;

public class AddLeaderboardEntryScreen implements Screen, InputProcessor {
    Main game;
    int score;
    String name;
    BitmapFont font;
    FileHandle lbFile;
    ArrayList<Score> leaderboard;

    public AddLeaderboardEntryScreen(Main game, int score){
        this.game = game;
        this.score = score;
        leaderboard = LeaderboardUtils.LoadLeaderboard("scores/GameLeaderboard.json");
        name = "";
        Gdx.input.setInputProcessor(this);

        loadAssets();
        calculateDimensions();
        calculatePositions();
    }

    private void loadAssets(){
        font = new BitmapFont(Gdx.files.internal("font/WhitePeaberry.fnt"));
    }

    private void calculateDimensions(){

    }

    private void calculatePositions(){

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

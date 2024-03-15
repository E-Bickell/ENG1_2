package com.main.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import com.main.Main;
import com.main.utils.ScreenType;


public class MainSettingsScreen implements Screen, InputProcessor {

    Main game;
    boolean gender;
    private final Texture backButton;
    private final float backButtonX;
    private final float backButtonY;
    private final float backButtonWidth = 200;
    private final float backButtonHeight = 100;

    private final Texture settingsLabel;

    private final float settingsLabelX;
    private final float settingsLabelY;
    private final float settingsLabelWidth = 500;
    private final float settingsLabelHeight = 130;

    private final Texture musicUpButton;

    private final float musicUpButtonX;
    private final float musicUpButtonY;
    private final float musicUpButtonWidth = 75;
    private final float musicUpButtonHeight = 75;


    private final Texture musicDownButton;

    private final float musicDownButtonX;
    private final float musicDownButtonY;
    private final float musicDownButtonWidth = 75;
    private final float musicDownButtonHeight = 75;

    private final Texture musicLabel;

    private final float musicLabelX;
    private final float musicLabelY;
    private final float musicLabelWidth = 200;
    private final float musicLabelHeight = 50;

    private Texture musicBar;

    private final float musicBarX;
    private final float musicBarY;
    private final float musicBarWidth = 250;
    private final float musicBarHeight = 50;

    private final Texture soundUpButton;

    private final float soundUpButtonX;
    private final float soundUpButtonY;
    private final float soundUpButtonWidth = 75;
    private final float soundUpButtonHeight = 75;

    private final Texture soundLabel;

    private final float soundLabelX;
    private final float soundLabelY;
    private final float soundLabelWidth = 200;
    private final float soundLabelHeight = 50;

    private final Texture soundDownButton;

    private final float soundDownButtonX;
    private final float soundDownButtonY;
    private final float soundDownButtonWidth = 75;
    private final float soundDownButtonHeight = 75;

    private Texture soundBar;

    private final float soundBarX;
    private final float soundBarY;
    private final float soundBarWidth = 250;
    private final float soundBarHeight = 50;

    private Texture boyButton;

    private final float boyButtonX;
    private final float boyButtonY;
    private final float boyButtonWidth = 150;
    private final float boyButtonHeight = 150;

    private Texture girlButton;

    private final float girlButtonX;
    private final float girlButtonY;
    private final float girlButtonWidth = 150;
    private final float girlButtonHeight = 150;


    public MainSettingsScreen(Main game) {
        this.game = game;
        gender = game.gameData.getGender();

        Gdx.input.setInputProcessor(this);
        /*
        group them maybe but up to you.
         */
        backButton = new Texture("assets/settings_gui/back_button.png");
        settingsLabel = new Texture("assets/settings_gui/settings_label.png");
        musicUpButton = new Texture("assets/settings_gui/arrow_right_button.png");
        musicDownButton = new Texture("assets/settings_gui/arrow_left_button.png");
        musicLabel = new Texture("assets/settings_gui/music_label.png");
        musicBar = new Texture("assets/settings_gui/bar_" + 25 * game.gameData.getMusicLevel() +".png");
        soundUpButton = new Texture("assets/settings_gui/arrow_right_button.png");
        soundLabel = new Texture("assets/settings_gui/sound_label.png");
        soundDownButton = new Texture("assets/settings_gui/arrow_left_button.png");
        soundBar = new Texture("assets/settings_gui/bar_" + 25 * game.gameData.getSoundLevel() +".png");
        if (gender) {
            boyButton = new Texture("assets/settings_gui/boy_button_indented.png");
            girlButton = new Texture("assets/settings_gui/girl_button.png");
        }
        else {
            girlButton = new Texture("assets/settings_gui/girl_button_indented.png");
            boyButton = new Texture("assets/settings_gui/boy_button.png");
        }

        backButtonX = (game.screenWidth - backButtonWidth) /2;
        backButtonY = (float) game.screenHeight / 6 - 100;
        settingsLabelX = (game.screenWidth - settingsLabelWidth) / 2;
        settingsLabelY =  game.screenHeight - (settingsLabelHeight * 2);
        musicUpButtonX = (game.screenWidth - musicUpButtonWidth) / 2 + 200;
        musicUpButtonY = game.screenHeight - musicUpButtonHeight - 350;
        musicDownButtonX = (game.screenWidth - musicUpButtonWidth) / 2 - 200;
        musicDownButtonY = game.screenHeight - musicUpButtonHeight - 350;
        musicLabelX = (game.screenWidth - musicLabelWidth) / 2;
        musicLabelY = game.screenHeight - musicLabelHeight - 290;
        musicBarX = (game.screenWidth - musicBarWidth) / 2;
        musicBarY = game.screenHeight - musicBarHeight - 375;
        soundUpButtonX = (game.screenWidth - soundUpButtonWidth) / 2 + 200;
        soundUpButtonY = game.screenHeight - soundUpButtonHeight - 530;
        soundLabelX = (game.screenWidth - soundLabelWidth) / 2;
        soundLabelY = game.screenHeight - soundLabelHeight - 470;
        soundDownButtonX = (game.screenWidth - soundDownButtonWidth) / 2 - 200;
        soundDownButtonY = game.screenHeight - soundDownButtonHeight - 530;
        soundBarX = (game.screenWidth - soundBarWidth) / 2;
        soundBarY = game.screenHeight - soundBarHeight - 555;
        boyButtonX = (game.screenWidth - boyButtonWidth) / 2 - 100;
        boyButtonY = game.screenHeight - boyButtonHeight - 650;
        girlButtonX = (game.screenWidth - boyButtonWidth) / 2 + 100;
        girlButtonY = game.screenHeight - boyButtonHeight - 650;


    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.3f, 0.55f, 0.7f, 1);
        game.batch.begin();
        game.batch.draw(backButton, backButtonX, backButtonY, backButtonWidth, backButtonHeight);
        game.batch.draw(settingsLabel, settingsLabelX, settingsLabelY, settingsLabelWidth, settingsLabelHeight);
        game.batch.draw(musicUpButton, musicUpButtonX, musicUpButtonY, musicUpButtonWidth, musicUpButtonHeight);
        game.batch.draw(musicDownButton, musicDownButtonX, musicDownButtonY, musicDownButtonWidth, musicDownButtonHeight);
        game.batch.draw(musicLabel, musicLabelX, musicLabelY, musicLabelWidth, musicLabelHeight);
        game.batch.draw(musicBar, musicBarX, musicBarY, musicBarWidth, musicBarHeight);
        game.batch.draw(soundUpButton, soundUpButtonX, soundUpButtonY, soundUpButtonWidth, soundUpButtonHeight);
        game.batch.draw(soundLabel, soundLabelX, soundLabelY, soundLabelWidth, soundLabelHeight);
        game.batch.draw(soundDownButton, soundDownButtonX, soundDownButtonY, soundDownButtonWidth, soundDownButtonHeight);
        game.batch.draw(soundBar, soundBarX, soundBarY, soundBarWidth, soundBarHeight);
        game.batch.draw(boyButton, boyButtonX, boyButtonY, boyButtonWidth, boyButtonHeight);
        game.batch.draw(girlButton, girlButtonX, girlButtonY, girlButtonWidth, girlButtonHeight);




        game.batch.end();
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
        return false;
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        float worldX = screenX * game.defWidth / (float) game.screenWidth;
        float worldY = (game.screenHeight - screenY) * game.defHeight / (float) game.screenHeight;

        if (worldX >= backButtonX && worldX <= backButtonX + backButtonWidth &&
                worldY >= backButtonY && worldY <= backButtonY + backButtonHeight) {
            game.screenManager.setScreen(ScreenType.MAIN_MENU);
        } else if (worldX >= musicUpButtonX && worldX <= musicUpButtonX + musicUpButtonWidth &&
                worldY >= musicUpButtonY && worldY <= musicUpButtonY + musicUpButtonHeight) {
            if (game.gameData.getMusicLevel() <= 3){
                game.gameData.incrementMusicLevel();
                musicBar = new Texture("assets/settings_gui/bar_" + 25 * game.gameData.getMusicLevel() +".png");
            }
        } else if (worldX >= musicDownButtonX && worldX <= musicDownButtonX + musicDownButtonWidth &&
                worldY >= musicDownButtonY && worldY <= musicDownButtonY + musicDownButtonHeight){

            if (game.gameData.getMusicLevel() >= 1){
                game.gameData.decrementMusicLevel();
                musicBar = new Texture("assets/settings_gui/bar_" + 25 * game.gameData.getMusicLevel() +".png");
            }
        } else if (worldX >= soundUpButtonX && worldX <= soundUpButtonX + soundUpButtonWidth &&
                worldY >= soundUpButtonY && worldY <= soundUpButtonY + soundUpButtonHeight) {

            if (game.gameData.getSoundLevel() <= 3){
                //game.gameData.incrementMusicLevel();
                soundBar = new Texture("assets/settings_gui/bar_" + 25 * game.gameData.getSoundLevel() +".png");
            }
        } else if (worldX >= soundDownButtonX && worldX <= soundDownButtonX + soundDownButtonWidth &&
                worldY >= soundDownButtonY && worldY <= soundDownButtonY + soundDownButtonHeight){

            if (game.gameData.getSoundLevel() >= 1){
                //game.gameData.decrementMusicLevel();
                soundBar = new Texture("assets/settings_gui/bar_" + 25 *game.gameData.getSoundLevel()+".png");
            }
        } else if (worldX >= boyButtonX && worldX <= boyButtonX + boyButtonWidth &&
                worldY >= boyButtonY && worldY <= boyButtonY + boyButtonHeight){
            gender = true;
            boyButton = new Texture("assets/settings_gui/boy_button_indented.png");
            girlButton = new Texture("assets/settings_gui/girl_button.png");
        } else if (worldX >= girlButtonX && worldX <= girlButtonX + girlButtonWidth &&
                worldY >= girlButtonY && worldY <= girlButtonY + girlButtonHeight){
            gender = false;
            girlButton = new Texture("assets/settings_gui/girl_button_indented.png");
            boyButton = new Texture("assets/settings_gui/boy_button.png");
        }

        game.gameData.setGender(gender);

        return true;
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

    @Override
    public void resize(int width, int height) {

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
        backButton.dispose();
        settingsLabel.dispose();
        musicUpButton.dispose();
        musicDownButton.dispose();
        musicLabel.dispose();
        musicBar.dispose();
        soundUpButton.dispose();
        soundLabel.dispose();
        soundDownButton.dispose();
        soundBar.dispose();
        boyButton.dispose();
        girlButton.dispose();
    }
}

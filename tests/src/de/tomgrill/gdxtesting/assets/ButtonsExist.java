package de.tomgrill.gdxtesting.assets;

import com.badlogic.gdx.Gdx;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class ButtonsExist {
    @Test
    public void MenuButtons() {
        assertTrue("Heslington Hustle Label Exists", Gdx.files.internal("menu_gui/heslington_hustle_label.png").exists());
        assertTrue("Play Button Exists", Gdx.files.internal("menu_gui/play_button.png").exists());
        assertTrue("Control Button Exists", Gdx.files.internal("menu_gui/controls_button.png").exists());
        assertTrue("Settings Button Exists", Gdx.files.internal("menu_gui/settings_button.png").exists());
        assertTrue("Exit Button Exists", Gdx.files.internal("menu_gui/exit_button.png").exists());
        assertTrue("Leaderboard Icon Exists", Gdx.files.internal("leaderboard_gui/Leaderboard_icon.png").exists());
    }

    @Test
    public void ControlButtons() {
        assertTrue("Controls Label Exists", Gdx.files.internal("controls_gui/controls_label.png").exists());
        assertTrue("Controls Exists", Gdx.files.internal("controls_gui/controls.png").exists());
    }

    @Test
    public void SettingsButtons() {
        assertTrue("Back Button Exists", Gdx.files.internal("settings_gui/back_button.png").exists());
        assertTrue("Settings Label Exists", Gdx.files.internal("settings_gui/settings_label.png").exists());
        assertTrue("Arrow Right Button Exists", Gdx.files.internal("settings_gui/arrow_right_button.png").exists());
        assertTrue("Arrow Left Button Exists", Gdx.files.internal("settings_gui/arrow_left_button.png").exists());
        assertTrue("Music Label Exists", Gdx.files.internal("settings_gui/music_label.png").exists());
        assertTrue("Sound Label Exists", Gdx.files.internal("settings_gui/sound_label.png").exists());
        assertTrue("Bar 0 Exists", Gdx.files.internal("settings_gui/bar_0.png").exists());
        assertTrue("Bar 25 Exists", Gdx.files.internal("settings_gui/bar_25.png").exists());
        assertTrue("Bar 50 Exists", Gdx.files.internal("settings_gui/bar_50.png").exists());
        assertTrue("Bar 75 Exists", Gdx.files.internal("settings_gui/bar_75.png").exists());
        assertTrue("Bar 100 Exists", Gdx.files.internal("settings_gui/bar_100.png").exists());
        assertTrue("Boy Button Exists", Gdx.files.internal("settings_gui/boy_button.png").exists());
        assertTrue("Boy Button Indented Exists", Gdx.files.internal("settings_gui/boy_button_indented.png").exists());
        assertTrue("Girl Button Exists", Gdx.files.internal("settings_gui/girl_button.png").exists());
        assertTrue("Girl Button Indented Exists", Gdx.files.internal("settings_gui/girl_button_indented.png").exists());
    }

    @Test
    public void LeaderboardButtons() {
        assertTrue("Leaderboard Label Exists", Gdx.files.internal("leaderboard_gui/leaderboard_label.png").exists());
        assertTrue("Position Base Exists", Gdx.files.internal("leaderboard_gui/Position_Base.png").exists());
        assertTrue("Name Tag Base Exists", Gdx.files.internal("leaderboard_gui/Name_Tag_Base.png").exists());
        assertTrue("Score Base Exists", Gdx.files.internal("leaderboard_gui/Score_Base.png").exists());
        assertTrue("Back Button Exists", Gdx.files.internal("leaderboard_gui/back_button.png").exists());
    }

    @Test
    public void AddToLeaderboardButtons() {
        assertTrue("Enter Button Exists", Gdx.files.internal("add_to_leaderboard_gui/enter_button.png").exists());
        assertTrue("Back Button Exists", Gdx.files.internal("add_to_leaderboard_gui/back_button.png").exists());
        assertTrue("Leaderboard Label Exists", Gdx.files.internal("add_to_leaderboard_gui/leaderboard_label.png").exists());
        assertTrue("Name Tag Base Exists", Gdx.files.internal("add_to_leaderboard_gui/Name_Tag_Base.png").exists());
    }

    @Test
    public void FontExists() {
        assertTrue("Font Exists", Gdx.files.internal("font/WhitePeaberry.fnt").exists());
    }
}

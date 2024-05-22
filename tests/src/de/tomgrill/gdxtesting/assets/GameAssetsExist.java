package de.tomgrill.gdxtesting.assets;

import com.badlogic.gdx.Gdx;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class GameAssetsExist {
    @Test
    public void BoyCharacterAssetsExist(){
        assertTrue("Boy Character Idle Exists", Gdx.files.internal("character/boy_idle.png").exists());
        assertTrue("Boy Character Walk Exists", Gdx.files.internal("character/boy_walk.png").exists());
    }
    @Test
    public void GirlCharacterAssetsExist(){
        assertTrue("Girl Character Idle Exists", Gdx.files.internal("character/girl_idle.png").exists());
        assertTrue("Girl Character Walk Exists", Gdx.files.internal("character/girl_walk.png").exists());
    }
    @Test
    public void mapExists() {
        assertTrue("Map Exists", Gdx.files.internal("map/MainMap.tmx").exists());
    }
    @Test
    public void TypingGameAssetsExist() {
        assertTrue("Guess Button Exists", Gdx.files.internal("mini_games/guess_button.png").exists());
        assertTrue("Number Memoriser Label", Gdx.files.internal("mini_games/number_memoriser_label.png").exists());
    }
}

package de.tomgrill.gdxtesting.Sound;

import com.badlogic.gdx.Gdx;
import com.main.sound.GameMusic;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class MusicTests {
    GameMusic gameMusic = new GameMusic();

    @Test
    public void testMusicExists() {
        assertTrue("This sound exists", Gdx.files.internal("sfx/high_note.mp3").exists());
        //System.out.println(Gdx.files.internal("sfx/high_note.mp3"));
    }
    @Test
    public void testVolume() {
        gameMusic.decrementVolume();
        gameMusic.decrementVolume();
        gameMusic.incrementVolume();
        assertEquals(3, gameMusic.getMusicLevel());
    }
}

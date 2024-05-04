package de.tomgrill.gdxtesting.Sound;

import com.badlogic.gdx.Gdx;
import com.main.sound.GameSound;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals ;
import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class SoundTests {
    GameSound gameSound = new GameSound();

    @Test
    public void testSoundsExists() {
        assertTrue("This sound exists", Gdx.files.internal("sfx/high_note.mp3").exists());
        assertTrue("This sound exists", Gdx.files.internal("sfx/low_note.mp3").exists());
        assertTrue("This sound exists", Gdx.files.internal("sfx/button_press.mp3").exists());
        assertTrue("This sound exists", Gdx.files.internal("sfx/eating_sound.wav").exists());
        //System.out.println(Gdx.files.internal("sfx/high_note.mp3"));
    }
    @Test
    public void testVolume() {
        gameSound.decrementVolume();
        gameSound.decrementVolume();
        gameSound.incrementVolume();
        assertEquals(3, gameSound.getSoundLevel());
    }
}

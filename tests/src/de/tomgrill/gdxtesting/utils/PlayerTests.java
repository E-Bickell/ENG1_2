package de.tomgrill.gdxtesting.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.main.map.GameMap;
import com.main.utils.CollisionHandler;
import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(GdxTestRunner.class)
public class PlayerTests {
    OrthographicCamera camera = new OrthographicCamera();
    GameMap gameMap = new GameMap(this.camera); 
    
    Player player=  new Player(game,gameMap,camera);
    
}

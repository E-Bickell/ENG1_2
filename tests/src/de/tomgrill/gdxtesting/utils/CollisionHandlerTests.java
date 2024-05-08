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
public class CollisionHandlerTests {
    OrthographicCamera camera = new OrthographicCamera();
    GameMap gameMap = new GameMap(this.camera);
    CollisionHandler collisionHandler = new CollisionHandler(gameMap.getMap(), gameMap.getTileSize(), gameMap.getTileSize(), 24, 38 * 0.5f, 0.7f, 0.7f);
    @Test
    public void testMoveNoCollision(){
        /* 336, 800 --> 336, 640 **/
        /* 800, 1120 --> 800, 800 **/
//        Vector2 v1 = new Vector2((float) 336, (float) 640);
//        Vector2 v2 = new Vector2((float) 800, (float) 800);
//        assertEquals(v1, collisionHandler.adjustPos(336, 800, 336, 640));
//        assertEquals(v2, collisionHandler.adjustPos(800, 1120, 800, 800));
    }
    @Test
    public void testMoveWithCollision(){
        /* 1168, 832 --> 1280, 832 **/
        /* 1184, 1120 --> 1280, 1120 **/
//        Vector2 v3 = new Vector2((float) 1168, (float) 832);
//        Vector2 v4 = new Vector2((float) 1184, (float) 1120);
//        assertEquals(v3, collisionHandler.adjustPos(1168, 832,1280, 832));
//        assertEquals(v4, collisionHandler.adjustPos(1184, 1120,1280, 1120));
    }
    @Test
    public void testMoveThroughBuilding(){
        /* 1168, 832 --> 1616, 832 **/
        /* 1184, 1120 --> 1616, 1120 **/
//        Vector2 v5 = new Vector2((float) 1168, (float) 832);
//        Vector2 v6 = new Vector2((float) 1184, (float) 1120);
//        assertEquals(v5, collisionHandler.adjustPos(1168, 832,1616, 832));
//        assertEquals(v6, collisionHandler.adjustPos(1184, 1120,1616, 1120));
    }
}

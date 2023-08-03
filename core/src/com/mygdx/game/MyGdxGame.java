package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Vector;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	public static World world;

	Box2DDebugRenderer debugRenderer;

	public static OrthographicCamera camera;


	Player player;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		debugRenderer = new Box2DDebugRenderer();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 20, 20);
		Box2D.init();

		world = new World(new Vector2(0, -10), true);

		Ground ground = new Ground();
		Ball ball = new Ball(new Vector2(camera.viewportWidth/2, camera.viewportHeight/2), 0.3f);
		Ball ball2 = new Ball(new Vector2(camera.viewportWidth/2, camera.viewportHeight/2 -3), 0.3f);
		Ball ball3 = new Ball(new Vector2(camera.viewportWidth/2, camera.viewportHeight/2 - 5), 0.3f);

	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.end();
		debugRenderer.render(world, camera.combined);
		world.step(1/60f, 6, 2);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}

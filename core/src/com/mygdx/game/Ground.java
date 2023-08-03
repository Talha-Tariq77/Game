package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Ground {
    Body groundBody;

    public Ground() {
        BodyDef groundBodyDef = new BodyDef();

        groundBody = MyGdxGame.world.createBody(groundBodyDef);

        groundBodyDef.position.set(new Vector2(0, 2));

        PolygonShape groundBox = new PolygonShape();
        groundBox.setAsBox(MyGdxGame.camera.viewportWidth, 2f);

        groundBody.createFixture(groundBox, 0.0f);

        groundBox.dispose();
    }
}

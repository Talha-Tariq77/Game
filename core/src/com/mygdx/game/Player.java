package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import static com.mygdx.game.MyGdxGame.world;


public class Player {
    BodyDef bodyDef;
    FixtureDef fixtureDef;

    public Player(Vector2 init_pos) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.KinematicBody;

        bodyDef.position.set(init_pos);

        Body body = world.createBody(bodyDef);
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(50, 50);

        fixtureDef = new FixtureDef();
        fixtureDef.shape = polygonShape;
        Fixture fixture = body.createFixture(fixtureDef);
        polygonShape.dispose();
    }
}

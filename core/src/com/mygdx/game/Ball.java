package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class Ball {
    Body ballBody;

    Ball(Vector2 initPos, float radius) {
        BodyDef ballBodyDef = new BodyDef();
        ballBodyDef.position.set(initPos);
        ballBodyDef.type = BodyDef.BodyType.DynamicBody;

        ballBody = MyGdxGame.world.createBody(ballBodyDef);

        CircleShape ballShape = new CircleShape();
        ballShape.setRadius(radius);

        FixtureDef ballFixtureDef = new FixtureDef();
        ballFixtureDef.shape = ballShape;
        ballFixtureDef.density = 100;
        ballFixtureDef.friction = 0.4f;
        ballFixtureDef.restitution = 0.8f;

        Fixture fixture = ballBody.createFixture(ballFixtureDef);

        ballShape.dispose();
    }
}

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

class Triangle extends Entity {
    private float x1, x2, x3, y1, y2, y3;

    public Triangle() {
        this(null, 0, 0, 2, 0, 0, 0, 0, 0, 0);
    }

    public Triangle(Color color, float x, float y, float speed) {
        this(color, x, y, speed, -25, 25, 0, -25, -25, 25);
    }

    public Triangle(Color color, float x, float y, float speed, float x1, float y1, float x2, float y2, float x3, float y3) {
        super(x, y, speed, color);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public void draw(ShapeRenderer shape) {
        shape.setColor(getColor());
        shape.triangle(
                getX() + x1, getY() + y1,
                getX() + x2, getY() + y2,
                getX() + x3, getY() + y3
        );
    }

    @Override
    public void movement() {
        if (Gdx.input.isKeyPressed(Keys.A)) setX(getX() - getSpeed() * Gdx.graphics.getDeltaTime());
        if (Gdx.input.isKeyPressed(Keys.D)) setX(getX() + getSpeed() * Gdx.graphics.getDeltaTime());
    }

    @Override
    public void update() {
        // Implementation for updating the state of the triangle
    }
}
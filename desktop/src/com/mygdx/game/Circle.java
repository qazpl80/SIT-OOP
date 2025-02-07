package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

class Circle extends Entity {
    private float radius;

    public Circle() {
        this(null, 0, 0, 0, 2);
    }

    public Circle(Color color, float radius, float x, float y, float speed) {
        super(x, y, speed, color);
        this.radius = radius;
    }

    public float getRadius() { return radius; }
    public void setRadius(float radius) { this.radius = radius; }

    @Override
    public void draw(ShapeRenderer shape) {
        shape.setColor(getColor());
        shape.circle(getX(), getY(), radius);
    }

    @Override
    public void movement() {
        if (Gdx.input.isKeyPressed(Keys.UP)) setY(getY() + getSpeed() * Gdx.graphics.getDeltaTime());
        if (Gdx.input.isKeyPressed(Keys.DOWN)) setY(getY() - getSpeed() * Gdx.graphics.getDeltaTime());
    }

    @Override
    public void update() {
        if (radius == 5 && x == 50 && y == 50) {
            System.out.println("In circle of radius 5 at 50,50 position");
        }
    }
}
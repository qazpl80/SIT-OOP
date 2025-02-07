package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public abstract class Entity implements iMovable {
	protected float x;
	protected float y;
	protected float speed;
	protected Color color;

	public Entity() {
		x = 0;
		y = 0;
		speed = 2;
		color = null;
	}

	public Entity(float x, float y, float speed, Color color) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public void draw(ShapeRenderer shape) {}

	public void draw(SpriteBatch batch) {}

	@Override
	public abstract void movement();

	protected abstract void update();
}
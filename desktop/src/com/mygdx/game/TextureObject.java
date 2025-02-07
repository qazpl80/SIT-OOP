package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class TextureObject extends Entity {
    private final Texture tex;
    private final float SCREEN_BOTTOM = 0;
    private final float SCREEN_LEFT = 0;
    private final float SCREEN_TOP = 480;
    private final float SCREEN_RIGHT = 640;

    public TextureObject(String texturePath) {
        this(texturePath, 0, 0, 2);
    }

    public TextureObject(String texturePath, float x, float y, float speed) {
        super(x, y, speed, null);
        this.tex = new Texture(Gdx.files.internal(texturePath));
    }

    public float getWidth() { return tex.getWidth(); }
    public float getHeight() { return tex.getHeight(); }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(tex, getX(), getY());
    }

    @Override
    public void movement() {
        if (Gdx.input.isKeyPressed(Keys.LEFT)) setX(getX() - getSpeed());
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) setX(getX() + getSpeed());
    }

    public void dispose() {
        tex.dispose();
    }

    @Override
    public void update() {
        if (tex.toString().contains("droplet.png")) {
            System.out.println("In textureObject of droplet.png at 50,50 position");
        }
    }

    // User movement
    public void userMovement() {
        if (Gdx.input.isKeyPressed(Keys.W)) setY(getY() + getSpeed());
        if (Gdx.input.isKeyPressed(Keys.S)) setY(getY() - getSpeed());
    }

    // AI movement
    public void aiMovement() {
        // Move the droplet down
        setY(getY() - getSpeed());

        // Reset droplet position when it moves out of bounds
        if (getY() < SCREEN_BOTTOM) {
            setY(SCREEN_TOP);
            setX((float) (Math.random() * (SCREEN_RIGHT - 64)));
        }
    }
}
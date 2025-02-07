package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameMaster extends ApplicationAdapter {
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private EntityManager droplets;

    private Entity bucket;
    private Entity circle;
    private Entity triangle;
    private final float SCREEN_BOTTOM = 0;
    private final float SCREEN_LEFT = 0;
    private final float SCREEN_TOP = 480;
    private final float SCREEN_RIGHT = 640;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();

        // Create a circle
        circle = new Circle(Color.RED, 50, 320, 240, 150);

        // Create a triangle
        triangle = new Triangle(Color.YELLOW, 100, 200, 100, -100, -100, 100, -100, 0, 100);

        // Create the bucket
        bucket = new TextureObject("bucket.png", 287, 0, 5);

        // Initialize the EntityManager
        droplets = new EntityManager();

        // Create multiple droplets
        for (int i = 0; i < 10; i++) {
            float randomX = (float) (Math.random() * (SCREEN_RIGHT - 64));
            float randomY = (float) (Math.random() * (SCREEN_TOP - 64));
            droplets.addEntity(new TextureObject("droplet.png", randomX, randomY, 2));
        }
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        // Render the circle and triangle
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        circle.draw(shapeRenderer);
        triangle.draw(shapeRenderer);
        shapeRenderer.end();

        // Render the droplets
        batch.begin();
        droplets.draw(batch, shapeRenderer);
        batch.end();

        // Render the bucket
        batch.begin();
        ((TextureObject) bucket).draw(batch);
        bucket.movement();
        circle.movement();
        triangle.movement();
        batch.end();

        // Handle movement and boundary conditions
        handleBucketBounds();
        updateDroplets();
    }

    private void handleBucketBounds() {
        if (bucket.getX() < SCREEN_LEFT) {
            bucket.setX(SCREEN_LEFT);
        } else if (bucket.getX() > SCREEN_RIGHT - 64) {
            bucket.setX(SCREEN_RIGHT - 64);
        }
    }

    private void updateDroplets() {
        for (Entity drop : droplets) {
            TextureObject textureDrop = (TextureObject) drop;
            textureDrop.aiMovement(); // Call the AI movement for each droplet
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();

        // Dispose of the bucket
        ((TextureObject) bucket).dispose();

        // Dispose of the droplets
        for (Entity drop : droplets) {
            ((TextureObject) drop).dispose();
        }
    }
}
package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class EntityManager implements Iterable<Entity> {
    private List<Entity> entityList;

    public EntityManager() {
        entityList = new ArrayList<>();
    }

    public void addEntity(Entity entity) {
        entityList.add(entity);
    }

    public void draw(SpriteBatch batch, ShapeRenderer shape) {
        for (Entity entity : entityList) {
            if (entity instanceof Circle) {
                ((Circle) entity).draw(shape);
            } else if (entity instanceof Triangle) {
                ((Triangle) entity).draw(shape);
            } else if (entity instanceof TextureObject) {
                ((TextureObject) entity).draw(batch);
            }
        }
    }

    public void movement() {
        for (Entity entity : entityList) {
            entity.movement();
        }
    }

    public void update() {
        for (Entity entity : entityList) {
            entity.update();
        }
    }

    @Override
    public Iterator<Entity> iterator() {
        return entityList.iterator();
    }
}
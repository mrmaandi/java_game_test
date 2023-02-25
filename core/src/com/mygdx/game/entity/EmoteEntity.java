package com.mygdx.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static com.mygdx.game.config.GameConfig.*;

public class EmoteEntity implements GameEntity {
    private final SpriteBatch batch;
    private final Texture img;
    private final Vector2 position = new Vector2();

    public EmoteEntity(GameEntityType emote) {
        batch = new SpriteBatch();
        img = new Texture(emote.img);
        init();
    }

    private void init() {
        position.x = (float) Math.random() * SCREEN_WIDTH;
        position.y = SCREEN_HEIGHT;
    }

    @Override
    public void setPosition(float x, float y) {
        position.x = x;
        position.y = y;
    }

    @Override
    public void draw() {
        batch.begin();
        batch.draw(img, position.x, position.y);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    @Override
    public void move() {
        float newY = position.y - ENTITY_SPEED * Gdx.graphics.getDeltaTime();
        setPosition(position.x, newY);
    }
}

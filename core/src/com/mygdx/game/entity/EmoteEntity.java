package com.mygdx.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static com.mygdx.game.config.GameConfig.*;

public class EmoteEntity implements GameEntity {
    private final SpriteBatch batch;
    private final Emote emote;
    public final Vector2 position = new Vector2();

    public EmoteEntity(Emote emote) {
        this.emote = emote;
        batch = new SpriteBatch();
        init();
    }

    private void init() {
        int inBoundaryWidth = SCREEN_WIDTH - (int) emote.width;
        position.x = (float) Math.random() * inBoundaryWidth;
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
        batch.draw(emote.texture, position.x, position.y, emote.width, emote.height);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        emote.texture.dispose();
    }

    @Override
    public void move() {
        float newY = position.y - ENTITY_SPEED * Gdx.graphics.getDeltaTime();
        setPosition(position.x, newY);
    }
}

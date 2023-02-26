package com.mygdx.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static com.mygdx.game.config.GameConfig.*;

public class EmoteEntity implements GameEntity {
    private final Emote emote;
    public final Vector2 position;
    private final SpriteBatch batch;

    public Emote getEmote() {
        return emote;
    }

    public EmoteEntity(Emote emote) {
        this.emote = emote;
        int inBoundaryWidth = SCREEN_WIDTH - (int) this.emote.width;
        position = new Vector2((float) Math.random() * inBoundaryWidth, SCREEN_HEIGHT);
        batch = new SpriteBatch();
    }

    @Override
    public void move() {
        float newY = position.y - ENTITY_SPEED * Gdx.graphics.getDeltaTime();
        setPosition(position.x, newY);
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
}

package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Texture;

public interface GameEntity {
    void setPosition(float x, float y);
    void draw();
    void dispose();
    void move();
}

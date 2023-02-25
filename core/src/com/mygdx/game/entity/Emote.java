package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.util.SpriteUtil;

import static com.mygdx.game.config.GameConfig.SPRITE_HEIGHT;

public enum Emote {
    _4HEAD("4head", "4Head.png"),
    KAPPA("kappa", "Kappa.png"),
    FRANKERZ("frankerz", "FrankerZ.png");

    Emote(String textValue, String img) {
        this.textValue = textValue;
        this.texture = new Texture(img);
        this.width = SpriteUtil.calculateSpriteWidth(texture.getHeight(), texture.getWidth());
    }

    public final String textValue;
    public final Texture texture;
    public final float width;
    public final float height = SPRITE_HEIGHT;
}

package com.mygdx.game.util;

import static com.mygdx.game.config.GameConfig.SPRITE_HEIGHT;

public class SpriteUtil {
    public static float calculateSpriteWidth(int height, int width) {
        float ratio = Integer.divideUnsigned(SPRITE_HEIGHT, height);
        return ratio * width;
    }
}

package com.mygdx.game.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpriteUtilTest {

    @ParameterizedTest
    @MethodSource("arguments")
    public void calculateSpriteWidth(int width, int height, float expectedWidth) {
        assertEquals(expectedWidth, SpriteUtil.calculateSpriteWidth(height, width));
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(Arguments.of(20, 30, 21.3f));
    }
}
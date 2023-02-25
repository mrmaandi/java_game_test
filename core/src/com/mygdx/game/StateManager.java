package com.mygdx.game;

import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.entity.EmoteEntity;
import com.mygdx.game.entity.GameEntityType;
import com.mygdx.game.util.RandomEnumGenerator;

import java.util.ArrayList;
import java.util.List;

import static com.mygdx.game.config.GameConfig.MAX_ENTITIES;
import static com.mygdx.game.config.GameConfig.SPAWN_RATE;

public class StateManager {
    private static final RandomEnumGenerator<GameEntityType> generator = new RandomEnumGenerator<>(GameEntityType.class);

    public static final List<EmoteEntity> entities = new ArrayList<>();
    public static long lastEntitySpawnTime;

    public static void init() {
        lastEntitySpawnTime = TimeUtils.millis();
    }

    public static void trySpawnEntity() {
        if (!isAbleToSpawn()) return;

        EmoteEntity entity = new EmoteEntity(generator.randomEnum());
        entities.add(entity);
        lastEntitySpawnTime = TimeUtils.millis();
        System.out.println("Spawned entity");
    }

    private static boolean isAbleToSpawn() {
        long timeSinceLastSpawn = TimeUtils.timeSinceMillis(lastEntitySpawnTime);
        return timeSinceLastSpawn > SPAWN_RATE && entities.size() < MAX_ENTITIES;
    }
}

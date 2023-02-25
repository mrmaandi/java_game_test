package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.entity.Emote;
import com.mygdx.game.entity.EmoteEntity;
import com.mygdx.game.util.RandomEnumGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.mygdx.game.config.GameConfig.MAX_ENTITIES;
import static com.mygdx.game.config.GameConfig.SPAWN_RATE;

public class StateManager {
    private static final RandomEnumGenerator<Emote> emoteGenerator = new RandomEnumGenerator<>(Emote.class);
    public static final Sound SPAWN_SOUND = Gdx.audio.newSound(Gdx.files.internal("sounds/spawn.wav"));
    public static final Sound DESTROY_SOUND = Gdx.audio.newSound(Gdx.files.internal("sounds/destroy.wav"));
    public static final List<EmoteEntity> entities = new ArrayList<>();
    public static long lastEntitySpawnTime;

    public static void init() {
        lastEntitySpawnTime = TimeUtils.millis();
    }

    public static void trySpawnEntity() {
        if (!isAbleToSpawn()) return;

        EmoteEntity entity = new EmoteEntity(emoteGenerator.randomEnum());
        entities.add(entity);
        lastEntitySpawnTime = TimeUtils.millis();
        SPAWN_SOUND.play();
        System.out.println("Spawned entity");
    }

    private static boolean isAbleToSpawn() {
        long timeSinceLastSpawn = TimeUtils.timeSinceMillis(lastEntitySpawnTime);
        return timeSinceLastSpawn > SPAWN_RATE && entities.size() < MAX_ENTITIES;
    }

    public static void removeOffscreenEntities() {
        if (entities.stream().noneMatch(entity -> entity.position.y <= 0)) {
            return;
        }
        for (Iterator<EmoteEntity> iter = entities.iterator(); iter.hasNext(); ) {
            EmoteEntity nextEntity = iter.next();
            if (nextEntity.position.y <= 0) {
                iter.remove();
                // nextEntity.dispose();
            }
        }
        DESTROY_SOUND.play();
    }
}

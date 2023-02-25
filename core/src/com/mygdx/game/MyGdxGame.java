package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.entity.EmoteEntity;

import static com.mygdx.game.StateManager.DESTROY_SOUND;
import static com.mygdx.game.StateManager.SPAWN_SOUND;

public class MyGdxGame extends ApplicationAdapter {

    @Override
    public void create() {
        StateManager.init();
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 0, 0, 1);
        StateManager.trySpawnEntity();
        StateManager.entities.forEach(entity -> {
            entity.draw();
            entity.move();
        });
        StateManager.removeOffscreenEntities();
    }

    @Override
    public void dispose() {
        StateManager.entities.forEach(EmoteEntity::dispose);
        SPAWN_SOUND.dispose();
        DESTROY_SOUND.dispose();
    }
}

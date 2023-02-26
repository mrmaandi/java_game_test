package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.entity.Emote;
import com.mygdx.game.entity.EmoteEntity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.badlogic.gdx.graphics.GL20.GL_COLOR_BUFFER_BIT;
import static com.mygdx.game.StateManager.DESTROY_SOUND;
import static com.mygdx.game.StateManager.SPAWN_SOUND;

public class MyGdxGame extends ApplicationAdapter {
    Stage stage;
    SpriteBatch batch;
    private BitmapFont font;
    private TextField textField;

    @Override
    public void create() {
        StateManager.init();

        batch = new SpriteBatch();
        stage = new Stage();
        Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        textField = new TextField("", skin);
        textField.setPosition(0, 0);
        textField.addListener(event -> {
            List<String> emoteValues = Arrays.stream(Emote.values()).map(Emote::getTextValue).collect(Collectors.toList());
            if (emoteValues.contains(textField.getText().toLowerCase())) {
                StateManager.onValidInput(textField.getText().toLowerCase());
                textField.setText("");
            }
            return false;
        });

        stage.addActor(textField);
        Gdx.input.setInputProcessor(stage);

        font = new BitmapFont();
        font.setColor(Color.BLACK);
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
        Gdx.gl.glClear(GL_COLOR_BUFFER_BIT);

        StateManager.trySpawnEntity();
        StateManager.entities.forEach(entity -> {
            entity.draw();
            entity.move();
        });
        StateManager.removeOffscreenEntities();

        batch.begin();
        stage.draw();
        font.draw(batch, String.format("Score: %s", StateManager.score), 160, 18);
        batch.end();
    }

    @Override
    public void dispose() {
        StateManager.entities.forEach(EmoteEntity::dispose);
        SPAWN_SOUND.dispose();
        DESTROY_SOUND.dispose();
        stage.dispose();
        font.dispose();
        batch.dispose();
    }
}

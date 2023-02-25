package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

import static com.mygdx.game.config.GameConfig.SCREEN_HEIGHT;
import static com.mygdx.game.config.GameConfig.SCREEN_WIDTH;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(144);
		config.setWindowedMode(SCREEN_WIDTH, SCREEN_HEIGHT);
		config.setTitle("Kappa Game");
		new Lwjgl3Application(new MyGdxGame(), config);
	}
}

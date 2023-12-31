package com.pricklesoft;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.pricklesoft.Main;

import com.badlogic.gdx.graphics.Color;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main(String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setWindowedMode(1200, 900);
		config.useVsync(true);
		config.setTitle("The Pet Game");
		config.setWindowIcon("images/logo.png");
		config.setInitialBackgroundColor(Color.WHITE);
		Main mainApp = new Main();
		new Lwjgl3Application(mainApp, config);
	}
}

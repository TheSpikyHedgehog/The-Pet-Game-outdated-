package com.pricklesoft;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.pricklesoft.states.GameStateManager;
import com.pricklesoft.states.MainMenuState;

public class Main extends ApplicationAdapter {
	public GameStateManager gsm;
	public SpriteBatch spriteBatch;
	public Stage stage;


	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		this.stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		this.gsm = new GameStateManager();
		this.gsm.push(new MainMenuState(this.gsm, this.stage));
		Gdx.app.log("GAME", "Game has been launched.");
		Gdx.app.log("WARNING", "Resizing the window can lead to many different bugs.");
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(spriteBatch, this.stage);
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
		stage.dispose();
		gsm.dispose();
	}
}

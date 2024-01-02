package com.pricklesoft.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pricklesoft.entities.Player;
import com.pricklesoft.input.KeyHandler;

import java.security.Key;

public class PlayState extends State{
    public Player player;
    KeyHandler keyHandler;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        keyHandler = new KeyHandler();
        this.player = new Player(keyHandler);
    }

    @Override
    public void handleInput() {
        this.keyHandler.checkForInput();
    }

    @Override
    public void update(float dt) {
        this.handleInput();
        this.player.update();
    }

    @Override
    public void render(SpriteBatch sb, Stage stage) {

    }

    @Override
    public void dispose() {

    }
}

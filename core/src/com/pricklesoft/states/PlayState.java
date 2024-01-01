package com.pricklesoft.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pricklesoft.entities.Player;

public class PlayState extends State{
    public Player player;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        this.player = new Player();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        this.handleInput();
    }

    @Override
    public void render(SpriteBatch sb, Stage stage) {

    }

    @Override
    public void dispose() {

    }
}

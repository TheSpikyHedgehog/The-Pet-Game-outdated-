package com.pricklesoft.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.pricklesoft.entities.Player;
import com.pricklesoft.input.InputHandler;
import com.pricklesoft.maps.MapManager;


public class PlayState extends State{
    public Player player;
    InputHandler inputHandler;
    public MapManager mapManager;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        inputHandler = new InputHandler();
        this.player = new Player(inputHandler);
        mapManager = new MapManager();
    }

    @Override
    public void handleInput() {
        this.inputHandler.checkForInput();
    }

    @Override
    public void update(float dt) {
        this.handleInput();
        this.player.update();
    }

    @Override
    public void render(SpriteBatch sb, Stage stage) {
        sb.begin();
        player.draw(sb);
        mapManager.render();
        sb.end();
    }
    @Override
    public void dispose() {
        mapManager.dispose();
    }
}

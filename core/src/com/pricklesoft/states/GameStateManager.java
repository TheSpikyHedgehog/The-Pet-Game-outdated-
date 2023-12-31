package com.pricklesoft.states;

import java.util.Stack;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameStateManager {
    public Stack<State> states;
    public GameStateManager() {
        states = new Stack<State>();
    }

    public void push(State state) {
        this.states.push(state);
    }

    public void pop(){
        this.states.pop();
    }

    public void set(State state){
        this.states.pop();
        this.states.push(state);
    }

    public void update(float dt){
        this.states.peek().update(dt);
    }

    public void render(SpriteBatch sb, Stage stage){
        this.states.peek().render(sb, stage);
    }

}

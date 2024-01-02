package com.pricklesoft.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class KeyHandler {
    public boolean up, down, left, right;

    public void checkForInput() {
        up = Gdx.input.isKeyPressed(Input.Keys.W);
        down = Gdx.input.isKeyPressed(Input.Keys.S);
        left = Gdx.input.isKeyPressed(Input.Keys.A);
        right = Gdx.input.isKeyPressed(Input.Keys.D);
    }
}

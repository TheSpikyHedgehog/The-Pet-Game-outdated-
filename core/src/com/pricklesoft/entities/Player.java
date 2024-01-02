package com.pricklesoft.entities;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.pricklesoft.input.KeyHandler;

public class Player extends Sprite {
    // Player class
    public TextureAtlas atlas;
    public int x, y;
    public KeyHandler keyHandler;

    public Player(KeyHandler keyHandler) {
        // Constructor.
        this.atlas = new TextureAtlas(); // Add in atlas path ltr.
        this.keyHandler = keyHandler;

    }



    public void setTexture(String textureName) {
        setRegion(atlas.findRegion(textureName));
    }

    public void update() {
        System.out.println(this.keyHandler.up);
        System.out.println(this.keyHandler.down);
        System.out.println(this.keyHandler.left);
        System.out.println(this.keyHandler.right);
    }

    public void draw(SpriteBatch batch) {

    }


}

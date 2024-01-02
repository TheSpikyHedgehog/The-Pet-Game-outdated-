package com.pricklesoft.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.pricklesoft.input.KeyHandler;

public class Player extends Sprite {
    // Player class
    public TextureAtlas atlas;
    public Texture test;
    public int x, y;
    public int speed;
    public KeyHandler keyHandler;

    public Player(KeyHandler keyHandler) {
        // Constructor.
        this.x = 100;
        this.y = 100;
        this.atlas = new TextureAtlas(); // Add in atlas path ltr.
        this.test = new Texture(Gdx.files.internal("images/entity_sprites/test.png"));
        this.keyHandler = keyHandler;
        this.speed = 4;

    }



    public void setTexture(String textureName) {
        setRegion(atlas.findRegion(textureName));
    }

    public void update() {
        if (keyHandler.up) {
            y += speed;
        }
        if (keyHandler.down) {
            y -= speed;
        }
        if (keyHandler.left) {
            x -= speed;
        }
        if (keyHandler.right) {
            x += speed;
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(test, x, y);
    }


}

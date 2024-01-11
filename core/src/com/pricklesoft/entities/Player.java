package com.pricklesoft.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.pricklesoft.input.InputHandler;
import com.pricklesoft.maps.MapManager;
import com.pricklesoft.define_values.Admin_Player_Properties;

public class Player extends Sprite {
    // Player class
    public TextureAtlas atlas;
    public Texture test;
    public float x, y;
    public float speed;
    public boolean isAdmin = true;
    public InputHandler inputHandler;
    public int health;
    public int maxHealth;

    public Player(InputHandler inputHandler) {
        // Constructor.
//        this.x = 329f;
//        this.y = 929f;
        this.x = 515 + 12;
        this.y = 515 + 12;
        this.atlas = new TextureAtlas(); // Add in atlas path ltr.
        this.test = new Texture(Gdx.files.internal("images/entity_sprites/test.png"));
        this.inputHandler = inputHandler;
        if (isAdmin) {
            this.speed = Admin_Player_Properties.adminSpeed;
        } else {
            this.speed = 0.3f;
        }

        // Default health (100) and maxHealth; player data override
        this.health = 100;
        this.maxHealth = 100;
    }



    public void setTexture(String textureName) {
        setRegion(atlas.findRegion(textureName));
    }

    public void update() {
        if (inputHandler.up) {
            y += speed;
            MapManager.camera.translate(0,speed);
        }
        if (inputHandler.down) {
            y -= speed;
            MapManager.camera.translate(0, -speed);
        }
        if (inputHandler.left) {
            x -= speed;
            MapManager.camera.translate(-speed,0);
        }
        if (inputHandler.right) {
            x += speed;
            MapManager.camera.translate(speed,0);
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(test, x, y, 1.6f, 1.6f);
    }

}

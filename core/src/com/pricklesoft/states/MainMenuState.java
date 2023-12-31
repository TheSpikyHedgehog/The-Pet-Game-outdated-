package com.pricklesoft.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenuState extends State{
    public String version = "v1.0 SNAPSHOT";
    public TextButton play, settings, exit, credits;
    FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("fonts/font.ttf"));
    FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    BitmapFont font, smaller_font;
    TextButton.TextButtonStyle textButtonStyle;
    public Texture logo, bg;
    public Label company, version_label;
    private Label.LabelStyle style = new Label.LabelStyle();
    public MainMenuState(final GameStateManager gsm, final Stage stage) {
        super(gsm);
        textButtonStyle = new TextButton.TextButtonStyle();
        parameter.size = 65;
        parameter.color = Color.BLACK;
        font = gen.generateFont(parameter);
        parameter.size = 50;
        smaller_font = gen.generateFont(parameter);
        // Load images
        logo = new Texture(Gdx.files.internal("images/across_logo.png"));
//        bg = new Texture(Gdx.files.internal("images/bg.png"));
        textButtonStyle.font = this.font;
        // Buttons
        play = new TextButton("Singleplayer", textButtonStyle);
        play.setX((float) 870 /2);
        play.setY(500);
        play.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                gsm.push(new PlayState(gsm)); // For now use the PlayState but change to WorldCreation ltr.
                Gdx.app.log("DEBUG", "World Creation Menu");
                stage.clear();
            }
        });
        settings = new TextButton("Settings", textButtonStyle);
        settings.setX((float) 980/2);
        settings.setY(400);
        settings.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                gsm.push(new SettingsMenus(gsm));
                Gdx.app.log("DEBUG", "Settings Menu");
                    stage.clear();
            }
        });
        credits = new TextButton("Credits", textButtonStyle);
        credits.setX((float) 995/2);
        credits.setY(300);
        credits.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                gsm.push(new SettingsMenus(gsm));
                Gdx.app.log("DEBUG", "Credits");
                stage.clear();
            }
        });
        exit = new TextButton("Exit", textButtonStyle);
        exit.setX((float) 1080/2);
        exit.setY(200);
        exit.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("GAME", "Exited");
                System.exit(0);
            }
        });
        style.font = this.smaller_font;
        style.fontColor = Color.BLACK;
        company = new Label("(c) Pricklesoft Studios", style);
        version_label = new Label(version, style);
        company.setX(750);
        company.setY(10);
        version_label.setX(10);
        version_label.setY(10);
        stage.addActor(this.play);
        stage.addActor(this.settings);
        stage.addActor(this.exit);
        stage.addActor(this.credits);
        stage.addActor(this.company);
        stage.addActor(this.version_label);
    }
    @Override
    public void handleInput() {
        // Don't need
    }

    @Override
    public void update(float dt) {
        this.handleInput();
    }

    @Override
    public void render(SpriteBatch sb, Stage stage) {
        sb.begin();
        sb.draw(logo, 700/2, 650);
        stage.draw();
        stage.act();
        sb.end();
    }

// Test comment
}
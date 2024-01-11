package com.pricklesoft.maps;

import com.badlogic.gdx.assets.loaders.resolvers.ExternalFileHandleResolver;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class MapManager {
    public static final float unitScale = 1/16f;
    public static OrthogonalTiledMapRenderer forest_renderer;
    public static TiledMap forest;
    public static OrthographicCamera camera;
    public static int camera_x;
    public static int camera_y;
    public MapManager() {
        this.camera_x = 315;
        this.camera_y = 915;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 25, 25);
        camera.translate(515, 515);
        camera.update();
        this.forest = new TmxMapLoader().load("maps/forest.tmx");
        this.forest_renderer = new OrthogonalTiledMapRenderer(forest, unitScale);
    }

    public void render() {
        camera.update();
        this.forest_renderer.setView(camera);
        this.forest_renderer.render();
    }

    public void dispose() {
        this.forest_renderer.dispose();
    }
}

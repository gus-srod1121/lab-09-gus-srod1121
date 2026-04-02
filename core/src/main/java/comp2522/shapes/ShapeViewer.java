package comp2522.shapes;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class ShapeViewer extends ApplicationAdapter {
    private SpriteBatch batch;
    private ExtendViewport viewport;

    @Override
    public void create() {
        batch = new SpriteBatch();
        viewport = new ExtendViewport(320, 180);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        logic();
        draw();
    }

    private void logic() {
        float delta = Gdx.graphics.getDeltaTime();
    }

    private void draw() {

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}

package comp2522.shapes;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import comp2522.shapes.Shape.Shape;
import comp2522.shapes.Shape.ShapeLoader;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public final class ShapeViewer extends ApplicationAdapter {
    private ExtendViewport viewport;

    private Array<Shape> shapes;
    private ShapeRenderer shapeRenderer;

    private boolean shapeFillMode = true;

    @Override
    public void create() {
        System.out.println("\n\nStarting ShapeViewer...");

        viewport = new ExtendViewport(320, 180);
        shapeRenderer = new ShapeRenderer();

        shapes = new Array<>();

        FileHandle shapesFilePath = Gdx.files.internal("shapes.txt");
        loadShapes(shapesFilePath);
    }

    private void loadShapes(final FileHandle filePath) {
        ShapeLoader shapeLoader = new ShapeLoader();
        shapeLoader.loadShapes(filePath);

        System.out.println("\nLoaded " + shapeLoader.getShapesCount() + " shapes.");

        shapes = new Array<>();
        for (Shape s : shapeLoader.getShapes()) {
            shapes.add(s);
            System.out.println(s.describe());
        }

    }

    @Override
    public void render() {
        /* This is the modern libGDX standard for clearing the screen */
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        viewport.apply();

        input();
        draw();
    }

    private void input() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            shapeFillMode = !shapeFillMode;
        }
    }

    private void draw() {
        shapeRenderer.setProjectionMatrix(viewport.getCamera().combined);
        ShapeRenderer.ShapeType shapeType;
        if (shapeFillMode) {
            shapeType = ShapeRenderer.ShapeType.Filled;
        }
        else {
            shapeType = ShapeRenderer.ShapeType.Line;
        }

        shapeRenderer.begin(shapeType);
        for (Shape shape : shapes) {
            shape.render(shapeRenderer);
        }
        shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}

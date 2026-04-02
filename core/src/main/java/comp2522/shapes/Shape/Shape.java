package comp2522.shapes.Shape;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Represents a shape with a name.
 *
 * @author Gustavo Rodriguez
 * @version 2026
 */
public abstract class Shape implements Measurable, Describable, Comparable<Shape> {
    private static final String DEFAULT_NAME = "SHAPE";

    private final float x;
    private final float y;

    /**
     * Constructs a Shape object with a name.
     */
    public Shape(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the X position.
     *
     * @return the X position.
     */
    public float getX() {
        return x;
    }

    /**
     * Returns the Y position.
     *
     * @return the Y position.
     */
    public float getY() {
        return y;
    }

    /**
     * Renders the Shape.
     *
     * @param renderer A ShapeRenderer
     */
    public abstract void render(final ShapeRenderer renderer);

    /**
     * Compares two shapes by area, perimeter, and name.
     *
     * @param other The object to compare
     * @return 1 if less than, -1 if greater than, 0 if equal
     */
    @Override
    public int compareTo(final Shape other) {
        int compareArea = Double.compare(this.getArea(), other.getArea());
        if (compareArea != 0) {
            return compareArea;
        }

        return Double.compare(this.getPerimeter(), other.getPerimeter());
    }

    /**
     * Returns a description of the shape.
     *
     * @return A string describing the Shape
     */
    @Override
    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append(" at ");
        sb.append("(").append(x).append(", ").append(y).append(")");
        return sb.toString();
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string detailing the object's state
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Shape{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append("}");
        return sb.toString();
    }
}

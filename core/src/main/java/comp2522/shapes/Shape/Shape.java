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

    private final String name;
    private final float x;
    private final float y;

    /**
     * Constructs a Shape object with a name.
     *
     * @param name The name of the Shape
     */
    public Shape(final String name, float x, float y) {
        this.x = x;
        this.y = y;
        if (name == null || name.isBlank()) {
            this.name = DEFAULT_NAME;
        } else {
            this.name = name;
        }
    }

    /**
     * Returns the name of the shape.
     *
     * @return The name of the Shape
     */
    public String getName() {
        return name;
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

        int comparePerimeter = Double.compare(this.getPerimeter(), other.getPerimeter());
        if (comparePerimeter != 0) {
            return comparePerimeter;
        }

        return this.getName().compareTo(other.getName());
    }

    /**
     * Returns a description of the shape.
     *
     * @return A string describing the Shape
     */
    @Override
    public final String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append("A ").append(getClass().getName());
        sb.append(" named ").append(getName());
        sb.append(", an area of ").append(getArea());
        sb.append(" and a perimeter of ").append(getPerimeter());
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
        sb.append("name=").append(name);
        sb.append("}");
        return sb.toString();
    }
}

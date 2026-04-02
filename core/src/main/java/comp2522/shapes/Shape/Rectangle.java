package comp2522.shapes.Shape;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Objects;

/**
 * Represents a Rectangle shape with a width and a height.
 *
 * @author Gustavo Rodriguez
 * @version 2026
 */
public class Rectangle extends Shape {
    private final float width;
    private final float height;

    /**
     * Constructs a Rectangle object with a name.
     *
     * @param name   The name of the Rectangle
     * @param width  The width of the Rectangle
     * @param height The height of the Rectangle
     * @throws IllegalArgumentException if width or height are not positive
     */
    public Rectangle(final String name, final float width, final float height, float x, float y) {
        super(name, x, y);
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be positive");
        }
        this.width = width;
        this.height = height;
    }

    /**
     * Renders the Shape.
     *
     * @param renderer A ShapeRenderer
     */
    public void render(final ShapeRenderer renderer) {
        renderer.rect(getX(), getY(), width, height);
    }

    /**
     * Returns the area of the rectangle.
     *
     * @return The area of the Rectangle
     */
    @Override
    public double getArea() {
        return width * height;
    }

    /**
     * Returns the perimeter of the rectangle.
     *
     * @return The perimeter of the Rectangle
     */
    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    /**
     * Returns the width of the rectangle.
     *
     * @return the width of the Rectangle
     */
    public float getWidth() {
        return width;
    }

    /**
     * Returns the height of the rectangle.
     *
     * @return the height of the Rectangle
     */
    public float getHeight() {
        return height;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string detailing the object's state
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Rectangle{");
        sb.append(super.toString());
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append("}");
        return sb.toString();
    }

    /**
     * Compares this component to another object to test for equality.
     *
     * @param object the object to compare
     * @return true if their class and state match
     */
    @Override
    public boolean equals(final Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (getClass() != object.getClass()) {
            return false;
        }

        Rectangle other = (Rectangle) object;

        return width == other.width && height == other.height && getName().equals(other.getName());
    }

    /**
     * Generates a hashcode representation of the object.
     *
     * @return The hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(getWidth(), getHeight(), getName());
    }
}

package comp2522.shapes.Shape;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Objects;

/**
 * Represents a Circle shape with a name and a radius.
 *
 * @author Gustavo Rodriguez
 * @version 2026
 */
public class Circle extends Shape {
    private final float radius;

    /**
     * Constructs a Circle object with a name and a radius.
     *
     * @param name The name of the Circle.
     * @param radius The radius of the Circle.
     * @throws IllegalArgumentException if radius is not positive.
     */
    public Circle(final String name, final float x, final float y, final float radius) {
        super(name, x, y);
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }

    /**
     * Renders the Shape.
     *
     * @param renderer A ShapeRenderer
     */
    public void render(final ShapeRenderer renderer) {
        renderer.circle(getX(), getY(), radius);
    }

    /**
     * Calculates and returns the area of the circle.
     *
     * @return The area of the Circle.
     */
    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Calculates and returns the perimeter of the circle.
     *
     * @return The perimeter of the Circle.
     */
    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    /**
     * Returns the radius of the circle.
     *
     * @return The diameter of the Circle.
     */
    public float getRadius() {
        return radius;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string detailing the object's state.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Circle{");
        sb.append(super.toString());
        sb.append(", radius=").append(getRadius());
        sb.append("}");
        return sb.toString();
    }

    /**
     * Compares this component to another object to test for equality.
     *
     * @param object the object to compare.
     * @return true if their class and state match.
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

        Circle other = (Circle) object;

        return radius == other.radius
                && getName().equals(other.getName());
    }

    /**
     * Generates a hashcode representation of the object.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(radius, getName());
    }
}

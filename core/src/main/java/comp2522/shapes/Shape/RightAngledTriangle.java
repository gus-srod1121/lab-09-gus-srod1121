package comp2522.shapes.Shape;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Objects;

/**
 * Represents a Triangle shape with a name, a base and a height.
 *
 * @author Gustavo Rodriguez
 * @version 2026
 */
public class RightAngledTriangle extends Shape {
    private final double base;
    private final double height;

    /**
     * Constructs a RightAngledTriangle object with a name, a base and a height.
     *
     * @param name   The name of the RightAngledTriangle
     * @param base   The base length of the RightAngledTriangle
     * @param height The height length of the RightAngledTriangle
     * @throws IllegalArgumentException if base or height are not positive
     */
    public RightAngledTriangle(final String name, final double base, final double height, float x, float y) {
        super(name, x, y);
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be positive");
        }
        this.base = base;
        this.height = height;
    }

    /**
     * Renders the Shape.
     *
     * @param renderer A ShapeRenderer
     */
    public void render(final ShapeRenderer renderer) {

    }

    /**
     * Returns the area of the right-angled triangle.
     *
     * @return The area of the RightAngledTriangle
     */
    @Override
    public double getArea() {
        return base * height / 2;
    }

    /**
     * Returns the perimeter of the right-angled triangle.
     *
     * @return The perimeter of the RightAngledTriangle
     */
    @Override
    public double getPerimeter() {
        double hypotenuse = Math.sqrt(base * base + height * height);
        return (base + height) + hypotenuse;
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string detailing the object's state
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RightAngledTriangle{");
        sb.append(super.toString());
        sb.append(", base=").append(base);
        sb.append(", height=").append(height);
        sb.append("}");
        return sb.toString();
    }

    /**
     * Returns the base of the triangle.
     *
     * @return the base of the Triangle
     */
    public double getBase() {
        return base;
    }

    /**
     * Returns the height of the triangle.
     *
     * @return the height of the Triangle
     */
    public double getHeight() {
        return height;
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

        RightAngledTriangle other = (RightAngledTriangle) object;

        return base == other.base && height == other.height && getName().equals(other.getName());
    }

    /**
     * Generates a hashcode representation of the object.
     *
     * @return The hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(base, height, getName());
    }
}

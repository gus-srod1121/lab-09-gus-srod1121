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
    private final float base;
    private final float height;

    /**
     * Constructs a RightAngledTriangle object with a name, a base and a height.
     *
     * @param name   The name of the RightAngledTriangle
     * @param base   The base length of the RightAngledTriangle
     * @param height The height length of the RightAngledTriangle
     * @throws IllegalArgumentException if base or height are not positive
     */
    public RightAngledTriangle(final String name, final float base, final float height, float x, float y) {
        super(x, y);
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be positive");
        }
        this.base = base;
        this.height = height;
    }

    /**
     * Renders a right-angled triangle.
     *
     * @param renderer A ShapeRenderer
     */
    public void render(final ShapeRenderer renderer) {
        renderer.triangle(
            getX(), getY(),
            getX() + base, getY(),
            getX(), getY() + height
        );
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
    public float getBase() {
        return base;
    }

    /**
     * Returns the height of the triangle.
     *
     * @return the height of the Triangle
     */
    public float getHeight() {
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

        return base == other.base
            && height == other.height
            && getX() == other.getX()
            && getY() == other.getY();
    }

    /**
     * Generates a hashcode representation of the object.
     *
     * @return The hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(base, height, getX(), getY());
    }
}

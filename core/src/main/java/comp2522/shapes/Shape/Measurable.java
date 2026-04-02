package comp2522.shapes.Shape;

/**
 * An interface for an Object which can be measured by area and perimeter.
 *
 * @author Gustavo Rodriguez
 * @version 2026
 */
public interface Measurable {

    /**
     * Returns the area of the object.
     *
     * @return The area of the object
     */
    double getArea();

    /**
     * Returns the perimeter of the object.
     *
     * @return The perimeter of the object
     */
    double getPerimeter();
}

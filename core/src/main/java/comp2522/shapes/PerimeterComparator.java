package comp2522.shapes;

import java.util.Comparator;

/**
 * Handles comparing Shape objects by perimeter.
 *
 * @author Gustavo Rodriguez
 * @version 2026
 */
public class PerimeterComparator implements Comparator<Shape> {
    /**
     * Compares two Shape objects by perimeter.
     *
     * @return A positive integer, a negative integer, or a zero if Shape o1
     *         is greater than, less than, or equal to Shape o2
     */
    @Override
    public int compare(final Shape o1, final Shape o2) {
        return Double.compare(
                o1.getPerimeter(),
                o2.getPerimeter()
        );
    }
}

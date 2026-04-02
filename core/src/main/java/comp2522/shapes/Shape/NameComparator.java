package comp2522.shapes.Shape;

import java.util.Comparator;

/**
 * Handles comparing Shape objects by name.
 *
 * @author Gustavo Rodriguez
 * @version 2026
 */
public class NameComparator implements Comparator<Shape> {
    /**
     * Compares two Shape objects by name.
     *
     * @return A positive integer, a negative integer, or a zero if Shape o1
     *         is greater than, less than, or equal to Shape o2
     */
    @Override
    public int compare(final Shape o1, final Shape o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

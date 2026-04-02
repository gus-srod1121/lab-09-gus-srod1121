package comp2522.shapes;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Loads shapes from a file and stores them in a Shape list.
 *
 * @author Gustavo Rodriguez
 * @version 2026
 */
public class ShapeLoader {

    /* The list of shapes loaded from the file. */
    private final List<Shape> shapes;

    /**
     * Constructs a new ShapeLoader with an empty list.
     */
    public ShapeLoader() {
        shapes = new ArrayList<>();
    }

    /**
     * Reads shape data from the specified file path.
     *
     * @param path The Path to the text file containing the shape data.
     */
    public void loadShapes(final Path path) {
        Scanner scanner;
        try {
            scanner = new Scanner(path);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return;
        }

        int totalLines = 0;
        int successfulLoads = 0;
        int failedLoads = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            totalLines++;

            Shape shape;
            try {
                shape = ShapeParser.parseShape(line);
            } catch (InvalidShapeDataException e) {
                System.err.println("Error in line " + totalLines + ": " + e.getMessage());
                failedLoads++;
                continue;
            }

            shapes.add(shape);
            successfulLoads++;
        }
        scanner.close();
        printReport(totalLines, successfulLoads, failedLoads);
    }

    /**
     * Prints a summary report of statistics tracked during loading the Shapes.
     * @param totalLines The total number of lines read from the file.
     * @param successfulLoads The number of shapes successfully created and added.
     * @param failedLoads The number of lines that failed validation.
     */
    private void printReport(
            final int totalLines, final int successfulLoads, final int failedLoads) {
        System.out.println("Report:");
        System.out.println("Total lines: " + totalLines);
        System.out.println("Successful loads: " + successfulLoads);
        System.out.println("Failed Loads: " + failedLoads);
    }

    /**
     * Returns a copy of the List of shapes loaded.
     *
     * @return A new ArrayList containing the loaded Shape objects.
     */
    public List<Shape> getShapes() {
        return new ArrayList<>(shapes);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return A string detailing the object's state.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ShapeLoader");
        sb.append("{");
        sb.append("shapes=").append(shapes);
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

        ShapeLoader o = (ShapeLoader) object;

        return shapes.equals(o.shapes);
    }

    /**
     * Generates a hashcode representation of the object.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(shapes);
    }
}

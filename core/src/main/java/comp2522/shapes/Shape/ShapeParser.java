package comp2522.shapes.Shape;

/**
 * Handles parsing string data into Shape objects using comma-separated input values.
 * Supports creating Circles, Rectangles and RightAngledTriangles.
 *
 * @author Gustavo Rodriguez
 * @version 2026
 */
public final class ShapeParser {

    /* Expected field count for a Circle */
    private static final int CIRCLE_FIELDS = 4;
    /* Expected field count for a Rectangle */
    private static final int RECTANGLE_FIELDS = 5;
    /* Expected field count for a RightAngledTriangle */
    private static final int TRIANGLE_FIELDS = 5;

    /*
     * Private constructor to prevent instantiation.
     */
    private ShapeParser() { }

    /**
     * Parses a single line of text into a Shape object.
     *
     * @param line The raw string to parse.
     * @return A Shape object based on the input data.
     * @throws InvalidShapeDataException if the line is blank, the shape is unknown,
     * the field count is incorrect, or numeric data is invalid.
     */
    public static Shape parseShape(final String line) throws InvalidShapeDataException {
        if (line == null || line.isBlank()) {
            throw new InvalidShapeDataException("Line cannot be null");
        }

        String[] parts = line.split(",");
        String type = parts[0].trim();

        try {
            return createShapeObject(type, parts);
        } catch (NumberFormatException e) {
            throw new InvalidShapeDataException(
                    "Invalid numeric data in line '" + line + "': " + e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new InvalidShapeDataException(
                    "Shape dimension error in line '" + line + "': " + e.getMessage());
        } catch (InvalidShapeDataException e) {
            throw new InvalidShapeDataException(
                    e.getMessage() + " in line '" + line + "': " + e.getMessage());
        }
    }

    /**
     * Instantiates the appropiate shape based on the provided type and parameters.
     *
     * @param type The string identifier for the Shape.
     * @param parts The array of String fields parsed from the input line.
     * @return a new Shape instance.
     * @throws InvalidShapeDataException If the type is unrecognized or
     * the field count is incorrect.
     */
    private static Shape createShapeObject(
            final String type, final String[]parts) throws InvalidShapeDataException {
        switch (type) {
            case "Circle":
                verifyFieldCount(parts, CIRCLE_FIELDS);
                return new Circle(parts[0], Float.parseFloat(parts[1]), Float.parseFloat(parts[2]), Float.parseFloat(parts[3]));
            case "Rectangle":
                verifyFieldCount(parts, RECTANGLE_FIELDS);
                return new Rectangle(
                        parts[0], Float.parseFloat(parts[1]), Float.parseFloat(parts[2]), Float.parseFloat(parts[3]), Float.parseFloat(parts[4]));
            case "RightAngledTriangle":
                verifyFieldCount(parts, TRIANGLE_FIELDS);
                return new RightAngledTriangle(
                        parts[0], Float.parseFloat(parts[1]), Float.parseFloat(parts[2]), Float.parseFloat(parts[3]), Float.parseFloat(parts[4]));
            default:
                throw new InvalidShapeDataException("Invalid shape " + type);
        }
    }

    /**
     * Verifies that the number of fields matches the expected count for the specific Shape object.
     *
     * @param fields The array of strings made of the line's tokens.
     * @param expected The required number of fields for a shape type.
     * @throws InvalidShapeDataException If there are more or less fields than required.
     */
    private static void verifyFieldCount(
            final String[] fields, final int expected) throws InvalidShapeDataException {
        if (fields.length < expected) {
            throw new InvalidShapeDataException((expected - fields.length) + " missing fields");
        } else if (fields.length > expected) {
            throw new InvalidShapeDataException((fields.length - expected) + " extra fields");
        }
    }
}

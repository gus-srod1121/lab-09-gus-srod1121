package comp2522.shapes.Shape;

/**
 * Exception thrown when shape data in invalid.
 *
 * @author Gustavo Rodriguez
 * @version 2026
 *
 */
public class InvalidShapeDataException extends Exception {

    /**
     * Constructs a new InvalidShapeDataException with a message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    public InvalidShapeDataException(final String message) {
        super(message);
    }
}

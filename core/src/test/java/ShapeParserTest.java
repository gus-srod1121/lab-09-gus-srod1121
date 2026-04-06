import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeParserTest {

    @Test
    void parseShapeCreatesCircle() throws InvalidShapeDataException {
        Shape s = ShapeParser.parseShape("Circle, 5.0");
        assertTrue(s instanceof Circle);
    }

    @Test
    void parseShapeCreatesRectangle() throws InvalidShapeDataException {
        Shape s = ShapeParser.parseShape("Rectangle, 4.0, 10.0");
        assertTrue(s instanceof Rectangle);
    }

    @Test
    void parseShapeCreatesTriangle() throws InvalidShapeDataException {
        Shape s = ShapeParser.parseShape("RightAngledTriangle, 3.0, 4.0");
        assertTrue(s instanceof RightAngledTriangle);
    }

    @Test
    void parseShapeThrowsExceptionForNull() {
        assertThrows(InvalidShapeDataException.class, () -> ShapeParser.parseShape(null));
    }

    @Test
    void parseShapeThrowsExceptionForBlankLine() {
        assertThrows(InvalidShapeDataException.class, () -> ShapeParser.parseShape("   "));
    }

    @Test
    void parseShapeThrowsExceptionForInvalidType() {
        assertThrows(InvalidShapeDataException.class, () -> ShapeParser.parseShape("Octagon, 8.0"));
    }

    @Test
    void parseShapeThrowsExceptionForMissingFields() {
        // Circle expects 2 fields
        assertThrows(InvalidShapeDataException.class, () -> ShapeParser.parseShape("Circle"));
    }

    @Test
    void parseShapeThrowsExceptionForExtraFields() {
        // Circle expects 2 fields
        assertThrows(InvalidShapeDataException.class, () -> ShapeParser.parseShape("Circle, 5.0, Extra"));
    }

    @Test
    void parseShapeThrowsExceptionForNonNumericData() {
        assertThrows(InvalidShapeDataException.class, () -> ShapeParser.parseShape("Rectangle, five, 10.0"));
    }

    @Test
    void parseShapeThrowsExceptionForInvalidDimensions() {
        // Assuming Circle constructor throws IllegalArgumentException for negative radius
        assertThrows(InvalidShapeDataException.class, () -> ShapeParser.parseShape("Circle, -5.0"));
    }
}
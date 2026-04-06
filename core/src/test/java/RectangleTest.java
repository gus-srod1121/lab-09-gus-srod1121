import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void constructorSetsName() {
        Rectangle r = new Rectangle("Ferb", 6.0, 8.0);
        assertEquals("Ferb", r.getName());
    }

    @Test
    void constructorSetsWidth() {
        Rectangle r = new Rectangle("Ferb", 6.0, 8.0);
        assertEquals(6.0, r.getWidth());
    }

    @Test
    void constructorSetsHeight() {
        Rectangle r = new Rectangle("Ferb", 6.0, 8.0);
        assertEquals(8.0, r.getHeight());
    }

    @Test
    void constructorThrowsExceptionForNegativeWidth() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle("John Doe", -29, 8));
    }

    @Test
    void constructorThrowsExceptionForZeroHeight() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle("John Doe", 9, 0));
    }

    @Test
    void getAreaCalculatesCorrectly() {
        Rectangle r = new Rectangle("Thwomp", 20.0, 20.0);
        assertEquals(400.0, r.getArea());
    }

    @Test
    void getPerimeterCalculatesCorrectly() {
        Rectangle r = new Rectangle("Thomas Was Alone", 2.0, 4.0);
        assertEquals(12.0, r.getPerimeter());
    }

    @Test
    void toStringContainsType() {
        Rectangle r = new Rectangle("Geometry Dash", 5, 5);
        assertTrue(r.toString().contains("Rectangle"));
    }

    @Test
    void toStringContainsSuperType() {
        Rectangle r = new Rectangle("Geometry Dash", 5, 5);
        assertTrue(r.toString().contains("Shape"));
    }

    @Test
    void toStringContainsName() {
        Rectangle r = new Rectangle("Geometry Dash", 5, 5);
        assertTrue(r.toString().contains("name=Geometry Dash"));
    }

    @Test
    void toStringContainsWidth() {
        Rectangle r = new Rectangle("Geometry Dash", 5, 5);
        assertTrue(r.toString().contains("width=5"));
    }

    @Test
    void toStringContainsHeight() {
        Rectangle r = new Rectangle("Geometry Dash", 5, 5);
        assertTrue(r.toString().contains("height=5"));
    }

    @Test
    void equalsIsReflexive() {
        Rectangle r1 = new Rectangle("Yellow Tetromino", 2, 2);
        assertEquals(r1, r1);
    }

    @Test
    void equalsReturnsTrueForIdenticalProperties() {
        Rectangle r1 = new Rectangle("Yellow Tetromino", 2, 2);
        Rectangle r2 = new Rectangle("Yellow Tetromino", 2, 2);
        assertEquals(r1, r2);
    }

    @Test
    void hashCodeIsConsistentWithEquals() {
        Rectangle r1 = new Rectangle("Yellow Tetromino", 2, 2);
        Rectangle r2 = new Rectangle("Yellow Tetromino", 2, 2);
        assertEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    void equalsReturnsFalseForDifferentName() {
        Rectangle r1 = new Rectangle("Yellow Tetromino", 2, 2);
        Rectangle r3 = new Rectangle("Fake Tetromino", 2, 2);
        assertNotEquals(r1, r3);
    }

    @Test
    void equalsReturnsFalseForDifferentWidth() {
        Rectangle r1 = new Rectangle("Yellow Tetromino", 2, 2);
        Rectangle r4 = new Rectangle("Yellow Tetromino", 3, 2);
        assertNotEquals(r1, r4);
    }

    @Test
    void equalsReturnsFalseForDifferentHeight() {
        Rectangle r1 = new Rectangle("Yellow Tetromino", 2, 2);
        Rectangle r5 = new Rectangle("Yellow Tetromino", 2, 4);
        assertNotEquals(r1, r5);
    }

    @Test
    void equalsReturnsFalseForNull() {
        Rectangle r1 = new Rectangle("Yellow Tetromino", 2, 2);
        assertNotEquals(r1, null);
    }

    @Test
    void equalsReturnsFalseForDifferentShapeType() {
        Rectangle r1 = new Rectangle("Yellow Tetromino", 2, 2);
        Circle not_rectangle = new Circle("Yellow Tetromino", 2);
        assertNotEquals(r1, not_rectangle);
    }
}
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RightAngledTriangleTest {

    @Test
    void constructorSetsName() {
        RightAngledTriangle triangle = new RightAngledTriangle("Skewed Bill Cipher", 10.0, 15.0);
        assertEquals("Skewed Bill Cipher", triangle.getName());
    }

    @Test
    void constructorSetsBase() {
        RightAngledTriangle triangle = new RightAngledTriangle("Skewed Bill Cipher", 10.0, 15.0);
        assertEquals(10, triangle.getBase());
    }

    @Test
    void constructorSetsHeight() {
        RightAngledTriangle triangle = new RightAngledTriangle("Skewed Bill Cipher", 10.0, 15.0);
        assertEquals(15, triangle.getHeight());
    }

    @Test
    void constructorThrowsExceptionForNegativeBase() {
        assertThrows(IllegalArgumentException.class, () -> new RightAngledTriangle("John Doe", -29, 8));
    }

    @Test
    void constructorThrowsExceptionForZeroHeight() {
        assertThrows(IllegalArgumentException.class, () -> new RightAngledTriangle("John Doe", 9, 0));
    }

    @Test
    void getAreaCalculatesCorrectly() {
        RightAngledTriangle triangle = new RightAngledTriangle("Phineas", 16.0, 30.0);
        assertEquals((16.0 * 30.0) / 2.0, triangle.getArea());
    }

    @Test
    void getPerimeterCalculatesCorrectly() {
        RightAngledTriangle triangle = new RightAngledTriangle("Pyramid Head", 10.0, 24.0);
        double hypotenuse = Math.sqrt(Math.pow(10, 2) + Math.pow(24, 2));
        assertEquals(10 + 24 + hypotenuse, triangle.getPerimeter());
    }

    @Test
    void toStringContainsType() {
        RightAngledTriangle triangle = new RightAngledTriangle("Pythagoras", 4.0, 3.0);
        assertTrue(triangle.toString().contains("RightAngledTriangle"));
    }

    @Test
    void toStringContainsSuperType() {
        RightAngledTriangle triangle = new RightAngledTriangle("Pythagoras", 4.0, 3.0);
        assertTrue(triangle.toString().contains("Shape"));
    }

    @Test
    void toStringContainsName() {
        RightAngledTriangle triangle = new RightAngledTriangle("Pythagoras", 4.0, 3.0);
        assertTrue(triangle.toString().contains("name=Pythagoras"));
    }

    @Test
    void toStringContainsBase() {
        RightAngledTriangle triangle = new RightAngledTriangle("Pythagoras", 4.0, 3.0);
        assertTrue(triangle.toString().contains("base=4"));
    }

    @Test
    void toStringContainsHeight() {
        RightAngledTriangle triangle = new RightAngledTriangle("Pythagoras", 4.0, 3.0);
        assertTrue(triangle.toString().contains("height=3"));
    }

    @Test
    void equalsIsReflexive() {
        RightAngledTriangle t1 = new RightAngledTriangle("Edward Cullen", 9, 12);
        assertEquals(t1, t1);
    }

    @Test
    void equalsReturnsTrueForIdenticalProperties() {
        RightAngledTriangle t1 = new RightAngledTriangle("Edward Cullen", 9, 12);
        RightAngledTriangle t2 = new RightAngledTriangle("Edward Cullen", 9, 12);
        assertEquals(t1, t2);
    }

    @Test
    void hashCodeIsConsistentWithEquals() {
        RightAngledTriangle t1 = new RightAngledTriangle("Edward Cullen", 9, 12);
        RightAngledTriangle t2 = new RightAngledTriangle("Edward Cullen", 9, 12);
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void equalsReturnsFalseForDifferentName() {
        RightAngledTriangle t1 = new RightAngledTriangle("Edward Cullen", 9, 12);
        RightAngledTriangle t3 = new RightAngledTriangle("Jacob Black", 9, 12);
        assertNotEquals(t1, t3);
    }

    @Test
    void equalsReturnsFalseForDifferentBase() {
        RightAngledTriangle t1 = new RightAngledTriangle("Edward Cullen", 9, 12);
        RightAngledTriangle t4 = new RightAngledTriangle("Edward Cullen", 5, 12);
        assertNotEquals(t1, t4);
    }

    @Test
    void equalsReturnsFalseForDifferentHeight() {
        RightAngledTriangle t1 = new RightAngledTriangle("Edward Cullen", 9, 12);
        RightAngledTriangle t5 = new RightAngledTriangle("Edward Cullen", 9, 40);
        assertNotEquals(t1, t5);
    }

    @Test
    void equalsReturnsFalseForNull() {
        RightAngledTriangle t1 = new RightAngledTriangle("Edward Cullen", 9, 12);
        assertNotEquals(t1, null);
    }

    @Test
    void equalsReturnsFalseForDifferentShapeType() {
        RightAngledTriangle t1 = new RightAngledTriangle("Edward Cullen", 9, 12);
        Rectangle not_triangle = new Rectangle("Bella Swan", 9, 12);
        assertNotEquals(t1, not_triangle);
    }
}
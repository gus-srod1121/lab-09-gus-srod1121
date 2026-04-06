import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void constructorSetsCorrectName() {
        Circle c = new Circle("Manny", 5.0);
        assertEquals("Manny", c.getName());
    }

    @Test
    void constructorSetsCorrectRadius() {
        Circle c = new Circle("Manny", 5.0);
        assertEquals(5.0, c.getRadius());
    }

    @Test
    void constructorThrowsExceptionForNegativeRadius() {
        assertThrows(IllegalArgumentException.class, () -> new Circle("John Doe", -29));
    }

    @Test
    void getAreaCalculatesCorrectly() {
        Circle c = new Circle("Roundboy", 39.0);
        assertEquals(Math.PI * Math.pow(39.0, 2), c.getArea());
    }

    @Test
    void getPerimeterCalculatesCorrectly() {
        Circle c = new Circle("Bond, James Bond", 22.0);
        assertEquals(Math.PI * 22.0 * 2, c.getPerimeter());
    }

    @Test
    void toStringContainsCircleType() {
        Circle c = new Circle("Choochoo", 18.0);
        assertTrue(c.toString().contains("Circle"));
    }

    @Test
    void toStringContainsShapeType() {
        Circle c = new Circle("Choochoo", 18.0);
        assertTrue(c.toString().contains("Shape"));
    }

    @Test
    void toStringContainsName() {
        Circle c = new Circle("Choochoo", 18.0);
        assertTrue(c.toString().contains("name=Choochoo"));
    }

    @Test
    void toStringContainsRadius() {
        Circle c = new Circle("Choochoo", 18.0);
        assertTrue(c.toString().contains("radius=18.0"));
    }

    @Test
    void testEqualsSameObject() {
        Circle c1 = new Circle("Pou", 5.0);
        assertEquals(c1, c1);
    }

    @Test
    void testEqualsIdenticalObjects() {
        Circle c1 = new Circle("Pou", 5.0);
        Circle c2 = new Circle("Pou", 5.0);
        assertEquals(c1, c2);
    }

    @Test
    void testHashCodeConsistency() {
        Circle c1 = new Circle("Pou", 5.0);
        Circle c2 = new Circle("Pou", 5.0);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void testNotEqualsDifferentName() {
        Circle c1 = new Circle("Pou", 5.0);
        Circle c3 = new Circle("Pablo", 5.0);
        assertNotEquals(c1, c3);
    }

    @Test
    void testNotEqualsDifferentRadius() {
        Circle c1 = new Circle("Pou", 5.0);
        Circle c4 = new Circle("Pou", 10.0);
        assertNotEquals(c1, c4);
    }

    @Test
    void testNotEqualsNull() {
        Circle c1 = new Circle("Pou", 5.0);
        assertNotEquals(c1, null);
    }

    @Test
    void testNotEqualsDifferentType() {
        Circle c1 = new Circle("Pou", 5.0);
        Rectangle not_circle = new Rectangle("Definitely a Circle", 5.0, 10.0);
        assertNotEquals(c1, not_circle);
    }
}
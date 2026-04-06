import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShapeTest {

    @Test
    void constructorAndGetters() {
        Shape s = new Circle("Round Pizza", 16);
        assertEquals("Round Pizza", s.getName());

        Shape noName = new RightAngledTriangle(null, 3, 4);
        assertEquals("SHAPE", noName.getName());

        Shape blankName = new RightAngledTriangle("", 3, 4);
        assertEquals("SHAPE", blankName.getName());
    }

    @Test
    void compareTo() {
        Shape s1 = new Rectangle("Square Pizza Slice", 5, 5);
        Shape s2 = new Rectangle("Square Pizza Slice", 5, 5);
        Shape s3 = new Rectangle("Also Square Pizza Slice", 5, 5);
        Shape s4 = new Rectangle("Square Pizza Slice", 12.5, 2);
        Shape s5 = new Rectangle("Square Pizza Slice", 10, 10);

        assertTrue(s1.compareTo(s1) == 0);
        assertTrue(s1.compareTo(s2) == 0);
        assertTrue(s1.compareTo(s3) > 0);
        assertTrue(s1.compareTo(s4) < 0);
        assertTrue(s1.compareTo(s5) < 0);
    }

    @Test
    void describe() {
        Shape s = new RightAngledTriangle("Deformed Pizza Slice", 6, 8);
        assertEquals(
                "A RightAngledTriangle named Deformed Pizza Slice, an area of 24.0 and a perimeter of 24.0",
                s.describe()
        );
    }
}
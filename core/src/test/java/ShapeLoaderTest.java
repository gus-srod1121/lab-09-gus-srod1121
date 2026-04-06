import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ShapeLoaderTest {

    @TempDir
    Path tempDir;

    @Test
    void loadShapesIncrementsSuccessfulLoads() throws Exception {
        Path file = tempDir.resolve("test.txt");
        Files.write(file, List.of("Circle, 5.0", "Rectangle, 2.0, 3.0"));

        ShapeLoader loader = new ShapeLoader();
        loader.loadShapes(file);

        assertEquals(2, loader.getShapes().size());
    }

    /*
     *
     */

    @Test
    void loadShapesNonexistentFile() throws Exception {
        Path file = Path.of("fake/super-fake/nonexistent.txt");

        ShapeLoader loader = new ShapeLoader();
        loader.loadShapes(file);

        assertEquals(0, loader.getShapes().size());
    }

    @Test
    void toStringTest() throws Exception {
        Path file = tempDir.resolve("test.txt");
        Files.write(file, List.of("Circle, 5.0", "BadType, 1.0", "Rectangle, 2.0, 3.0"));

        ShapeLoader loader = new ShapeLoader();
        loader.loadShapes(file);

        assertTrue(loader.toString().contains("Shape"));
    }

    @Test
    void equalsReturnsTrueForIdenticalLoaders() {
        ShapeLoader s1 = new ShapeLoader();
        ShapeLoader s2 = new ShapeLoader();
        assertEquals(s1, s2);
    }


    @Test
    void equalsReturnsTrueForItself() {
        ShapeLoader s1 = new ShapeLoader();
        assertEquals(s1, s1);
    }


    @Test
    void equalsReturnsFalseForNull() {
        ShapeLoader s1 = new ShapeLoader();
        ShapeLoader s2 = null;
        assertNotEquals(s1, s2);
    }


    @Test
    void equalsReturnsFalseForDifferentClass() {
        ShapeLoader s1 = new ShapeLoader();
        Shape rectangle = new Rectangle("Rectanglee", 8.0, 5.0);
        assertNotEquals(s1, rectangle);
    }

    @Test
    void hashCodeIsConsistentWithEquals() {
        ShapeLoader s1 = new ShapeLoader();
        ShapeLoader s2 = new ShapeLoader();
        assertEquals(s1.hashCode(), s2.hashCode());
    }

    @Test
    void getShapesReturnsCopyNotReference() {
        ShapeLoader loader = new ShapeLoader();
        List<Shape> firstList = loader.getShapes();
        List<Shape> secondList = loader.getShapes();

        assertNotSame(firstList, secondList);
    }
}
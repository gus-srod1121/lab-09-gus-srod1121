import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PerimeterComparatorTest {

    @Test
    void compareReturnsNegativeWhenFirstPerimeterIsSmaller() {
        PerimeterComparator perimeterComparator = new PerimeterComparator();
        Rectangle r1 = new Rectangle("Ruler", 5, 5);
        Rectangle r2 = new Rectangle("Ruler", 10, 10);
        assertTrue(perimeterComparator.compare(r1, r2) < 0);
    }

    @Test
    void compareReturnsPositiveWhenFirstPerimeterIsLarger() {
        PerimeterComparator perimeterComparator = new PerimeterComparator();
        Rectangle r2 = new Rectangle("Ruler", 10, 10);
        Rectangle r3 = new Rectangle("Ruler", 5, 5);
        assertTrue(perimeterComparator.compare(r2, r3) > 0);
    }

    @Test
    void compareReturnsZeroWhenPerimetersAreEqual() {
        PerimeterComparator perimeterComparator = new PerimeterComparator();
        Rectangle r1 = new Rectangle("Ruler", 5, 5);
        Rectangle r3 = new Rectangle("Ruler", 5, 5);
        assertTrue(perimeterComparator.compare(r1, r3) == 0);
    }
}
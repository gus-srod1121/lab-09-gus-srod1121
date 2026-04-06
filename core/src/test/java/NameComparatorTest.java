import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NameComparatorTest {

    @Test
    void compareReturnsNegativeWhenFirstIsAlphabeticallyFirst() {
        NameComparator nameComparator = new NameComparator();
        Rectangle r1 = new Rectangle("Ruler", 5, 10);
        Rectangle r2 = new Rectangle("Table", 5, 10);
        assertTrue(nameComparator.compare(r1, r2) < 0);
    }

    @Test
    void compareReturnsPositiveWhenFirstIsAlphabeticallyLater() {
        NameComparator nameComparator = new NameComparator();
        Rectangle r2 = new Rectangle("Table", 5, 10);
        Rectangle r3 = new Rectangle("Ruler", 5, 10);
        assertTrue(nameComparator.compare(r2, r3) > 0);
    }

    @Test
    void compareReturnsZeroWhenNamesAreEqual() {
        NameComparator nameComparator = new NameComparator();
        Rectangle r1 = new Rectangle("Ruler", 5, 10);
        Rectangle r3 = new Rectangle("Ruler", 5, 10);
        assertTrue(nameComparator.compare(r1, r3) == 0);
    }
}
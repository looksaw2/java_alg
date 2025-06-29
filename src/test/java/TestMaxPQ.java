import org.junit.jupiter.api.Test;
import org.looksaw.MaxPQ.ArrayMaxPQ;
import org.looksaw.MaxPQ.MaxPQ;

import static org.junit.jupiter.api.Assertions.*;
public class TestMaxPQ {
    @Test
    public void TestArrayMaxPQ() {
        Integer maxSize = 100;
        MaxPQ<Integer> maxPQ = new ArrayMaxPQ<>(maxSize);
        maxPQ.insert(1);
        maxPQ.insert(2);
        maxPQ.insert(3);
        assertEquals(maxPQ.size(), 3);
        assertEquals(maxPQ.max(), 3);
        maxPQ.delMax();
        assertEquals(maxPQ.size(), 2);
        assertEquals(maxPQ.max(), 2);
    }
}

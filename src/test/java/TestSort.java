import org.junit.jupiter.api.Test;
import org.looksaw.Sort.SelectionSort;
import org.looksaw.Sort.Sort;

import static org.junit.jupiter.api.Assertions.*;
public class TestSort {
    @Test
    public void TestSelectionSort() {
        Sort sort = new SelectionSort();
        Integer[] arr = {5,4,3,2,1};
        sort.sort(arr);
        Integer[] expected = {1,2,3,4,5};
        assertArrayEquals(arr, expected);
    }
}

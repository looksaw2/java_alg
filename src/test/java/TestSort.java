import org.junit.jupiter.api.Test;
import org.looksaw.Sort.*;

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
    @Test
    public void TestInsertionSort() {
        Sort sort = new InserctionSort();
        Integer[] arr = {5,4,3,2,1};
        sort.sort(arr);
        Integer[] expected = {1,2,3,4,5,6,7,8};
        assertArrayEquals(arr, expected);
    }


    @Test
    public void TestShellSort() {
        Sort sort = new ShellSort();
        Integer[] arr = {11,10,9,8,7,6,5,4,3,2,1};
        sort.sort(arr);
        assertEquals(true, sort.isSorted(arr));
        Integer[] expected = {1,2,3,4,5,6,7,8,9,10,11};
        assertArrayEquals(arr, expected);
    }

    @Test
    public void TestQuickSort() {
        Sort sort = new QuickSort();
        Integer[] arr = {11,10,9,8,7,6,5,4,3,2,1};
        sort.sort(arr);
        assertEquals(true, sort.isSorted(arr));
        Integer[] expected = {1,2,3,4,5,6,7,8,9,10,11};
        assertArrayEquals(arr, expected);
    }

    @Test
    public void TestQuickSortThreeWay() {
        Sort sort = new QuickSortThreeWay();
        Integer[] arr = {8,3,5,9};
        sort.sort(arr);
        assertEquals(true, sort.isSorted(arr));
        Integer[] expected = {3,5,8,9};
        assertArrayEquals(arr, expected);
    }



}

package org.looksaw.Sort;

public class QuickSortThreeWay implements Sort{
    @Override
    public void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }


    private void sort(Comparable[] arr,int lo, int hi){
        if (hi <= lo) return;
        int lt = lo;
        int gt = hi;
        int i = lo + 1;
        Comparable v = arr[lo];
        while(i <= gt){
            int cmp = arr[i].compareTo(v);
            if (cmp < 0) exch(arr,lt++,i++);
            else if (cmp > 0) exch(arr,i,gt--);
            else i++;
        }
        sort(arr,lo,lt-1);
        sort(arr,gt+1,hi);
    }
}

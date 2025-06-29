package org.looksaw.Sort;

public class QuickSort implements Sort{
    @Override
    public void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(Comparable[] arr,int lo, int hi){
        if(hi <= lo){
            return;
        }
        int j = partition(arr,lo,hi);
        sort(arr,lo,j-1);
        sort(arr,j+1,hi);
    }


    private int partition(Comparable[] arr , int lo, int hi){
        int i = lo;
        int j = hi + 1;
        var ToExchangeElement = arr[lo];
        while(true){
            while(less(arr[++i], ToExchangeElement)){
                if(i >= hi) break;
            }
            while(less(ToExchangeElement,arr[--j])){
                if(j <= lo) break;
            }
            if(i >= j) break;
            exch(arr,i,j);
        }
        exch(arr,lo,j);
        return j;
    }


}

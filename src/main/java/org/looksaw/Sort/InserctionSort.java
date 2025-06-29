package org.looksaw.Sort;

public class InserctionSort implements Sort{
    @Override
    public void sort(Comparable[] arr) {
        for(int i = 1; i < arr.length; i++){
            for(int j = i ; j > 0 && less(arr[j],arr[j-1]); j--){
                exch(arr,j,j-1);
            }
        }
    }
}

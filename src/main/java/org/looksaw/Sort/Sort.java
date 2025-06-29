package org.looksaw.Sort;

import java.util.Comparator;

public interface Sort {
    void sort(Comparable[] arr);
    default boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    default void exch(Comparable[] arr, int i, int j){
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    default void show(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    default boolean isSorted(Comparable[] arr){
        for(int i = 1; i < arr.length; i++){
            if(less(arr[i],arr[i-1])){
                return false;
            }
        }
        return true;
    }
}

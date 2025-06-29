package org.looksaw.Sort;
public class SelectionSort implements Sort{
    @Override
    public void sort(Comparable[] arr) {
        for( int i = 0; i < arr.length ; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(less(arr[j],arr[minIndex])){
                    minIndex = j;
                }
            }
            exch(arr,i,minIndex);
        }
    }
}

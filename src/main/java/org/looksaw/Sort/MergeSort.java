package org.looksaw.Sort;

public class MergeSort implements Sort{
    private Comparable[] aux;
    @Override
    public void sort(Comparable[] arr) {
        aux = new Comparable[arr.length];
        sort(arr, 0, arr.length - 1);

    }

    private void merge(Comparable[] arr,int lo , int mid, int hi){
        int i = lo;
        int j = mid + 1;
        for(int k = lo ; k <= hi ; k++){
            aux[k] = arr[k];
        }

        for(int k = lo ; k <= hi ; k++){
            if(i > mid) arr[k] = aux[j++];
            else if(j > hi)  arr[k] = aux[i++];
            else if(less(aux[i],aux[j])) arr[k] = aux[i++];
            else arr[k] = aux[j++];
        }
    }


    private void sort(Comparable[] arr , int lo ,int hi){
        if(hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(arr , lo , mid);
        sort(arr , mid + 1, hi);
        merge(arr , lo , mid , hi);
    }
}

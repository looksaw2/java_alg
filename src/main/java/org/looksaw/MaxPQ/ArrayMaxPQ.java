package org.looksaw.MaxPQ;

public class ArrayMaxPQ<Key extends Comparable<Key>> implements MaxPQ<Key>{
    private Key[] pq;
    private int N = 0;
    public ArrayMaxPQ(int maxN) {
        this.pq = (Key[]) new Comparable[maxN + 1];
    }

    @Override
    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    @Override
    public Key max() {
        if (N == 0) {
            return null;
        }
        return pq[1];
    }

    @Override
    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return this.N;
    }


    private boolean less(int i , int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j){
        var temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k){
        while(k > 1 && less(k/2,k)){
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k){
        while(2 * k <= N){
            int j = 2 * k;
            if(j < N && less(j,j+1)) j++;
            if(!less(k,j)) break;
            exch(k, j);
            k = j;
        }
    }
}

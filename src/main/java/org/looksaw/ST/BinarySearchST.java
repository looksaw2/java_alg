package org.looksaw.ST;

public class BinarySearchST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int N = 0;
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }
    @Override
    public void put(Key key, Value value) {
        int i = rank(key);
        if( i < N && keys[i].compareTo(key) == 0 ) {
            values[i] = value;
            return;
        }
        for(int j = N; j>i; j--){
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
        return;
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if( i < N && keys[i].compareTo(key) == 0) return values[i];
        return null;
    }

    @Override
    public void delete(Key key) {
        int i = rank(key);
        if( i < N && keys[i].compareTo(key) == 0) {
            keys[i] = null;
            for(int j = i + 1; j < N; j++){
                keys[j-1] = keys[j];
            }
            N--;
        }
    }

    @Override
    public boolean contains(Key key) {
        int i = rank(key);
        return i < N && keys[i].compareTo(key) == 0;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }


    private int rank(Key key){
        return rank(key,0,N-1);
    }


    private int rank(Key key, int lo, int hi){
        if (hi < lo){
            return lo;
        }
        int mid = lo + (hi -lo)/2;
        int t = 0;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0){
            t = rank(key, lo, mid-1);
        }
        else if (cmp > 0){
            t = rank(key, mid+1, hi);
        }
        else {
            t = mid;
        }
        return t;
    }
}

package org.looksaw.MaxPQ;

public interface MaxPQ <Key extends Comparable<Key>>{
    void insert(Key v);
    Key max();
    Key delMax();
    boolean isEmpty();
    int size();
}

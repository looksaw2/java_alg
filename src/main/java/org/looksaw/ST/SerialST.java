package org.looksaw.ST;

import java.util.ArrayList;

public class SerialST <Key,Value> implements ST<Key,Value> {
    private int size = 0;
    private Node first;
    private class Node {
        Key key;
        Value value;
        Node next;
        public Node(Key key, Value value , Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node (Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public void put(Key key, Value value) {
        for(var node = first; node != null; node =node.next){
            if(key.equals(node.key)){
                node.value = value;
                return;
            }
        }
        first = new Node(key, value,first);
        size++;
    }

    @Override
    public Value get(Key key) {
        for(var node = first; node != null; node = node.next){
            if(key.equals(node.key)){
                return node.value;
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        //头删去节点
        if (first.key.equals(key)) {
            first = first.next;
            size--;
            return;
        }
        for(var node = first; node != null; node = node.next){
            if(key.equals(node.next.key)){
                if(node.next.next == null){
                    node.next = null;
                    size--;
                    return;
                }
                node.next = node.next.next;
                size--;
                return;
            }
        }
        return;
    }

    @Override
    public boolean contains(Key key) {
        for(var node = first; node != null; node = node.next){
            if(key.equals(node.key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        var Keys = new ArrayList<Key>();
        for(var node = first; node != null; node = node.next){
            Keys.add(node.key);
        }
        return Keys;
    }
}

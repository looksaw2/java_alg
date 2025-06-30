package org.looksaw.BST;

public class BST<Key extends Comparable<Key> ,Value>{
    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int N;
        public Node(Key key,Value value, int N){
                this.key = key;
                this.value = value;
                this.N = N;
        }
    }
    private Node root;
    public int size(){
        return size(root);
    }
    private int size(Node node){
        if(node == null){
            return 0;
        }
        return node.N;
    }

    public Value get(Key key){
        return get(root, key);
    }

    private Value get(Node node, Key key){
        if(node == null) return null;
        if(key.compareTo(node.key) == 0) return node.value;
        else if(key.compareTo(node.key) < 0) return get(node.left, key);
        else return get(node.right, key);
    }

    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value){
        if(node == null){
            return new Node(key,value,1);
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0) node.left = put(node.left, key, value);
        else if(cmp > 0) node.right = put(node.right, key, value);
        else node.value = value;
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }
    public Key min(){
        return min(root).key;
    }
    private Node min(Node node){
        if(node.left == null) return node;
        return min(node.left);
    }
    public Key floor(Key key){
        Node x = floor(root, key);
        if(x == null) return null;
        return x.key;
    }
    private Node floor(Node node,Key key){
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp == 0) return node;
        if(cmp < 0) return floor(node.left, key);
        Node t = floor(node.right, key);
        if(t != null) return t;
        else return node;
    }
    private Key select(int k){
       return select(root, k).key;
    }
    private Node select(Node node, int k){
        if(node == null) return null;
        int t = size(node.left);
        if(k > t) return select(node.left, k);
        else if(k < t) return select(node.right, k-t-1);
        else return node;
    }
    public int rank(Key key){
        return rank(key,root);
    }
    private int rank(Key key , Node node){
        if(node == null) return 0;
        int cmp = key.compareTo(node.key);
        if(cmp < 0) return rank(key, node.left);
        else if(cmp > 0) return 1 + size(node.left) + rank(key, node.right);
        else return size(node.left);
    }
    public void deleteMin() {
        root = deleteMin(root);
    }
    private Node deleteMin(Node node){
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }
    public void delete(Key key){
        delete(root, key);
    }
    private Node delete(Node node, Key key){
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp < 0) node.left = delete(node.left, key);
        else if(cmp > 0) node.right = delete(node.right, key);
        else {
            if(node.left == null) return node.right;
            else if(node.right == null) return node.left;
            else {
                Node t = node;
                node = min(node.right);
                node.left = t.left;
            }
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }


}

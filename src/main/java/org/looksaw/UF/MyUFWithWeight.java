package org.looksaw.UF;

public class MyUFWithWeight implements UF {


    private int[] id;
    private int count;
    private int[] sz;
    public MyUFWithWeight(int N) {
        this.id = new int[N];
        this.count = N;
        this.sz = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
        for(int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }
    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (this.sz[pRoot] < this.sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        this.count --;
    }

    @Override
    public int find(int p) {
        if(p != this.id[p]){
            p = this.id[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return this.count;
    }
}

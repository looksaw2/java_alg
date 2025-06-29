package org.looksaw.UF;

public class MyUF2 implements UF {
    private int[] id;
    private int count;
    public MyUF2(int N){
        this.id = new int[N];
        this.count = N;
        for(int i = 0; i < N; i++){
            this.id[i] = i;
        }
    }
    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        this.id[pRoot] = qRoot;
        this.count--;
    }

    @Override
    public int find(int p) {
        while(p != this.id[p]){
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

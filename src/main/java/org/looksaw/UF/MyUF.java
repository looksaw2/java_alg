package org.looksaw.UF;

public class MyUF implements UF {

    private int[] id;
    private int count;

    public MyUF(int N){
        this.id  = new int[N];
        this.count = N;
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if(pId == qId) {
            return;
        }

        for(int i = 0; i< this.id.length; i++){
            if(this.id[i] == pId) {
                this.id[i] = qId;
            }
        }
        this.count--;
    }

    @Override
    public int find(int p) {
        return this.id[p];
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

package chapter1.unionFind;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnion implements UnionFind {
    private int id[];
    private int count;

    public QuickUnion(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    @Override
    // 寻找根节点
    public int find(int p) {
        int temp = p;
        while (id[p] != p)
            p = id[p];

        //id[temp] = p;
        while (id[temp] != temp) {
            int temp2 = temp;
            temp = id[temp];
            id[temp2] = p;
        }

        return p;
    }

    @Override
    public boolean connect(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = this.find(p);
        int qRoot = this.find(q);
        // 如果根节点相同，说明两者在同一个连通分量中
        if (qRoot == pRoot)
            return;

        id[qRoot] = pRoot;
        count--;
    }

    @Override
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int N = in.readInt();
        QuickFind UF = new QuickFind(N);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (UF.connect(p, q))
                continue;
            UF.union(p, q);
            StdOut.println(p + "  " + q);
        }
        StdOut.println(UF.count() + "conponent");
    }
}

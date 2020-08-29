package chapter1.unionFind;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author xj138
 * Decription : 初始化版本的 union-find: quick-find 算法
 */
public class QuickFind implements UnionFind {
    private int id[];
    private int count;

    public QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        count = N;
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connect(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pID = this.find(p);
        int qID = this.find(q);
        if (pID != qID) {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pID)
                    id[i] = qID;
            }
            count--;
        }
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int N = in.readInt();
        RunTime runTime = new RunTime();
        runTime.start();
        QuickFind UF = new QuickFind(N);
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (UF.connect(p, q))
                continue;
            UF.union(p, q);
            StdOut.println(p + "  " + q);
        }
        runTime.end();
        StdOut.println(UF.count() + "conponent");
        StdOut.println("spend:" + runTime.time() + " 秒");
    }

}

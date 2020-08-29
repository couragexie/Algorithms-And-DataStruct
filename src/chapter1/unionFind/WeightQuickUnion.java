package chapter1.unionFind;

/**
 * @author xj138
 * 实现路径压缩算法和加权union
 */
public class WeightQuickUnion implements UnionFind {
    private int parent[]; //  parent[i] = parent of i
    private int count;   //number of component
    private int[] rank;  // 根节点所在的层次（子节点多少层）

    public WeightQuickUnion(int N) {
        parent = new int[N];
        rank = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int p) {
        while (parent[p] != p) {  // 路径压缩
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public boolean connect(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;

        if (rank[pRoot] > rank[qRoot])
            parent[qRoot] = pRoot;
        else if (rank[pRoot] < rank[qRoot])
            parent[pRoot] = qRoot;
        else {
            parent[pRoot] = qRoot;
            rank[pRoot]++;
        }
        count--;
    }

    public int count() {

        return count;
    }
}

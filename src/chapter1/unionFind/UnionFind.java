package chapter1.unionFind;

/**
 * @author xj138
 * UnionFind 接口
 */
public interface UnionFind {
    public void union(int p, int q);

    public boolean connect(int p, int q);

    public int find(int p);

    public int count();
}

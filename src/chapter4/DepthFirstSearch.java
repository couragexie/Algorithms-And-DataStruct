package chapter4;

import edu.princeton.cs.algs4.StdOut;

public class DepthFirstSearch {
    private boolean[] marked;
    private Graph G;

    public DepthFirstSearch(Graph G) {
        this.G = G;
        marked = new boolean[G.V()];
    }

    public void DFS(int v) {
        marked[v] = true;
        StdOut.print(v + " ");
        for (int w : G.adj(v)) {
            if (!marked[w])
                DFS(w);
        }
    }

    public void clear() {
        for (int i = 0; i < marked.length; i++)
            marked[i] = false;
    }

}

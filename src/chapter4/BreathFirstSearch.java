package chapter4;

import java.util.LinkedList;
import java.util.Queue;

import edu.princeton.cs.algs4.StdOut;

public class BreathFirstSearch {
    private boolean[] marked;
    private Graph G;

    public BreathFirstSearch(Graph G) {
        this.G = G;
        marked = new boolean[G.V()];

    }

    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        marked[v] = true;
        StdOut.print(v + " ");
        while (!queue.isEmpty()) {
            v = queue.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    StdOut.print(w + " ");
                    marked[w] = true;
                    queue.offer(w);
                }
            }
        }

    }

    public void clear() {
        for (int i = 0; i < marked.length; i++)
            marked[i] = false;
    }


}

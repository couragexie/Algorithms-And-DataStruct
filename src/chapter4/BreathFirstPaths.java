package chapter4;

import java.util.LinkedList;
import java.util.Queue;

import chapter1.dataStructure.Stack;

public class BreathFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;
    private Graph G;

    public BreathFirstPaths(Graph G, int s) {
        this.G = G;
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        BFS(G, s);
    }

    private void BFS(Graph G, int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        marked[v] = true;
        while (!queue.isEmpty()) {
            v = queue.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    queue.offer(w);
                    marked[w] = true;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();

        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);


        return path;

    }

    public String toString() {
        String str = "BreathFirstPaths: \n";
        for (int v = 0; v < G.V(); v++) {
            str += s + " to " + v + " : ";
            if (this.hasPathTo(v)) {
                for (int w : this.pathTo(v)) {
                    if (w == s)
                        str += w;
                    else
                        str += "-" + w;
                }
                str += "\n";
            }
        }
        return str;
    }


}

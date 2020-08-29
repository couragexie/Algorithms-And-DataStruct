package chapter4;

import java.util.LinkedList;
import java.util.Queue;

import chapter1.dataStructure.Stack;
//import chapter1.Stack;
import edu.princeton.cs.algs4.StdOut;

public class DepthFirstPaths {

    private boolean[] marked; // 标记是否访问过
    private int[] edgeTo;  // 从起点到一个顶点的一条已知路径的最后一个顶点
    private final int s;

    private Graph G;

    public DepthFirstPaths(Graph graph, int v) {
        marked = new boolean[graph.V()];
        this.s = v;
        edgeTo = new int[graph.V()];
        this.G = graph;

        DFS(graph, s);
    }

    public void DFS(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                DFS(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);

        path.push(s);
        return path;
    }


    public String toString() {
        String str = "DepthFirstPaths: \n";
        for (int v = 0; v < G.V(); v++) {
            //StdOut.print(s + " to " + v + " : ");
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

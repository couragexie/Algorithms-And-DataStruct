package chapter4;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Graph {
    private final int V;  // 顶点数
    private Bag<Integer>[] adj;  // 与顶点相连的其他顶点
    private int E;  // 边数；

    public Graph(int v) {
        this.V = v;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < this.V; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int e = in.readInt();   // 这个E 是临时变量；
        for (int i = 0; i < e; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
        System.out.println("读取成功！");
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public String toString() {
        String s = V + " : vertices, " + E + " : edges\n";
        for (int v = 0; v < V; v++) {
            s += v + " : ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += '\n';
        }

        return s;
    }


    public static void main(String[] args) {
        Graph graph = new Graph(new In(args[0]));
        //System.out.println(graph.toString());
//		int s = Integer.parseInt(args[1]);
//		DepthFirstPaths dfp = new DepthFirstPaths(graph, s);
//		BreathFirstPaths bfp = new BreathFirstPaths(graph, s);
//
//		
//		StdOut.println("图的邻接表表示：");
//		StdOut.println(graph.toString());
//		StdOut.println();
//		StdOut.println(dfp.toString());
//		StdOut.println(); 
//		//StdOut.println("BreathFirstPaths: ");
//		StdOut.println(bfp.toString());
        System.out.println(graph.toString());
        StdOut.println();
        Cycle cycle = new Cycle(graph);
        System.out.println(cycle.hasCycle());

        CC cc = new CC(graph);
        StdOut.println(cc.count());


    }

}

package chapter4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Test {
    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        CC cc = new CC(G);

        int M = cc.count();
        StdOut.println(M + " components ");

        Bag<Integer>[] components = (Bag<Integer>[]) new Bag[M];

        for (int i = 0; i < M; i++) {
            components[i] = new Bag<Integer>();
        }

        for (int v = 0; v < G.V(); v++) {
            components[cc.id(v)].add(v);
        }

        for (int i = 0; i < M; i++) {
            for (int w : components[i])
                StdOut.print(w + " ");
            StdOut.println();

        }


    }


}

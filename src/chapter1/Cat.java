package chapter1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;

public class Cat {
    public static void main(String[] args) {

        Out out = new Out(args[args.length - 1]);
        StdOut.println(args[args.length - 1]);
        for (int i = 0; i < args.length - 1; i++) {
            In in = new In(args[i]);
            String s = in.readAll();
            out.println(s);
            StdOut.println(s);
            in.close();
        }
        out.close();

    }
}

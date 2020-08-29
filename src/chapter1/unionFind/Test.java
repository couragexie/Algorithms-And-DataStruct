package chapter1.unionFind;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Test {
    public static double getTestTime(In in, UnionFind UF) {
        //In in = new In(file);
        //int N = in.readInt();
        RunTime runTime = new RunTime();
        runTime.start();
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            if (UF.connect(p, q))
                continue;
            UF.union(p, q);
            StdOut.println(p + "  " + q);
        }
        runTime.end();
        StdOut.println(UF.count() + " conponent");
        //StdOut.println("spend:" + runTime.time() + " 秒");
        return runTime.time();
    }

    public static void main(String[] args) {

        In in = new In(args[0]);
        int N = in.readInt();
		/*
		UnionFind UF1 = new QuickFind(N);
		double QFTime = getTestTime(in, UF1);
		System.out.println("QFTime: " + QFTime);
		
		in  = new In(args[0]);
		N = in.readInt();
		UnionFind UF2 = new QuickUnion(N);
		double QUTime = getTestTime(in, UF2);
		System.out.println("QUTime: " + QUTime);
		
		StdOut.println("QU/QF = " + QUTime/ QFTime);
		*/
        in = new In(args[0]);
        N = in.readInt();
        UnionFind UF3 = new WeightQuickUnion(N);
        double WQUTime = getTestTime(in, UF3);
        System.out.println("WQUTime: " + WQUTime);
    }

}

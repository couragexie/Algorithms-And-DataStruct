package chapter1;

import java.util.Arrays;

import edu.princeton.cs.algs4.*;

import java.awt.geom.Rectangle2D;

public class Test {
    public static void main(String[] args) {
/*
//		int N =100;
//		StdDraw.setXscale(0, N);
//		StdDraw.setYscale(0, N*N);
//		StdDraw.setPenRadius(.01);
//		for(int i = 1; i <= N; i++) {
//			StdDraw.point(i, i);
//			StdDraw.point(i, i*i);
//			StdDraw.point(i, i*Math.log(i));
//		
 */

        int N = 20;
        double[] a = new double[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.random();

        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;
            StdOut.print();
            System.out.println("x = " + x + "��y = " + y + "��rw = " + rw + "��rh=" + rh);
            StdDraw.filledRectangle(x, y, rw, rh);

        }
    }
}


package chapter2.part2_1;

import java.util.Random;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import TestUtil.Stopwatch;;

public class Main {
    public static void main(String[] args) {
        int n = 10000000;
        Integer a[] = new Integer[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++)
            a[i] = rd.nextInt(Integer.MAX_VALUE);
        Stopwatch sw = new Stopwatch();
        ShellSort.sort(a);
        //BubbleSort.sort(a);
        System.out.println(sw.elapsedTime());
        System.out.println(isSorted(a));
    }

    public static void show() {
        int N = 50;
        double[] a = new double[N];
        Random rd = new Random();
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.random();
        //a[i] = rd.nextInt();
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
            System.out.println("x = " + x + "y = " + y);
        }
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length - 1; i++)
            if (a[i].compareTo(a[i + 1]) > 0)
                return false;
        return true;
    }

}

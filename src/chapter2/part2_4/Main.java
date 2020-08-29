package chapter2.part2_4;

import java.util.Random;

import TestUtil.Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Main {

    public static void main(String[] args) {
        int N = 10000000;
        Random rd = new Random();
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = rd.nextInt(10000);
        }
        Stopwatch sw = new Stopwatch();
        HeapSort.sort(a);
        StdOut.println(sw.elapsedTime());
        StdOut.println(isSorted(a));
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0)
                return false;
        }
        return true;
    }
}

package chapter2.part2_2;

import java.util.Arrays;
import java.util.Random;

import TestUtil.*;
import edu.princeton.cs.algs4.StdOut;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        Comparable[] a = makeArr(n);
        Stopwatch sw = new Stopwatch();
        MergeBU.sort(a);
        System.out.println(sw.elapsedTime());
        System.out.println(isSorted(a));
        for (Integer num : (Integer[]) a)
            StdOut.print(num + "   ");
        StdOut.println();
    }

    private static Comparable[] makeArr(int n) {
        Integer[] a = new Integer[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(Integer.MAX_VALUE);
            StdOut.print(a[i] + "  ");
        }
        StdOut.println();
        return a;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++)
            if (a[i].compareTo(a[i + 1]) > 0)
                return false;
        return true;
    }


}

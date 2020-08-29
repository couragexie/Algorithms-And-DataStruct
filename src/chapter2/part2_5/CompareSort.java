package chapter2.part2_5;

import java.util.Arrays;
import java.util.Random;

import TestUtil.Stopwatch;
import chapter2.part2_1.ShellSort;
import chapter2.part2_2.Merge;
import chapter2.part2_3.QuickSort1;
import chapter2.part2_4.HeapSort;
import edu.princeton.cs.algs4.StdOut;

public class CompareSort {

    public static Comparable[] makeArr(int n) {
        Comparable[] a = new Comparable[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++)
            a[i] = rd.nextInt(Integer.MAX_VALUE);

        return a;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++)
            if (a[i].compareTo(a[i + 1]) > 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        int n = 10000000;
        Comparable[] a = makeArr(n);
        Comparable[] b = makeArr(n);
        Comparable[] c = makeArr(n);
        Comparable[] d = makeArr(n);
        Comparable[] e = makeArr(n);

        Stopwatch sw1 = new Stopwatch();
        ShellSort.sort(a);
        double time1 = sw1.elapsedTime();

        Stopwatch sw2 = new Stopwatch();
        Merge.sort(b);
        double time2 = sw2.elapsedTime();

        Stopwatch sw3 = new Stopwatch();
        QuickSort1.sort(c);
        double time3 = sw3.elapsedTime();

        Stopwatch sw4 = new Stopwatch();
        HeapSort.sort(d);
        double time4 = sw4.elapsedTime();

        Stopwatch sw5 = new Stopwatch();
        Arrays.sort(e);
        double time5 = sw5.elapsedTime();

        StdOut.println("shellSort：" + time1);
        StdOut.println("MergeSort：" + time2);
        StdOut.println("QuickSort：" + time3);
        StdOut.println("HeapSort：" + time4);
        StdOut.println("ArraysSort：" + time5);


        StdOut.println(isSorted(a));
        StdOut.println(isSorted(b));
        StdOut.println(isSorted(c));
        StdOut.println(isSorted(d));
        StdOut.println(isSorted(e));

    }


}

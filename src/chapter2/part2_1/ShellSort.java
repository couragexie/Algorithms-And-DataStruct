package chapter2.part2_1;

import java.util.Random;

import edu.princeton.cs.algs4.StdDraw;

public class ShellSort {
    public static void sort(Comparable[] a) {
        int h = 1; // 定义间隔
        int N = a.length;
        while (h < N / 3)  //求一个递增序列
            h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                Comparable temp = a[i];
                int j;
                for (j = i - h; j >= 0 && less(temp, a[j]); j -= h)
                    a[j + h] = a[j];
                a[j + h] = temp;
            }
            h = h / 3;
        }

    }

    // 判断元素 v 是否比 w 小
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // 交换两个元素
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i / N;
            double y = a[i] / 2.0;
            double rw = 0.5 / N;
            double rh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
            System.out.println("x = " + x + ", y = " + y);
        }

    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1]))
                return false;
        return true;
    }
}

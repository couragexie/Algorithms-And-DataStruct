package chapter2.part2_1;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.*;

public class SelectSort {
    // 自动装箱和拆箱会消耗大量的时间
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (less(a[j], a[min]))
                    min = j;
            exch(a, i, min);
            //StdDraw.clear();
            //show((Double [])a);
            //StdDraw.show(1);
        }
    }

    public static void sort(double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++)
                if (a[j] < a[min])
                    min = j;
            double temp = a[i];
            a[i] = a[min];
            a[min] = temp;
            //exch(a, i, min);
            //StdDraw.clear();
            //show((Double [])a);
            //StdDraw.show(1);
        }
    }


    // 判断元素v, 是否比元素 w 小
    private static boolean less(Comparable v, Comparable w) {
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

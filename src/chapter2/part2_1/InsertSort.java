package chapter2.part2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class InsertSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int i, j;
        for (i = 1; i < N; i++) {
            Comparable temp = a[i];
            for (j = i - 1; j >= 0 && less(temp, a[j]); j--)  // 不能将 a[j+1] 与 a[j] 比较，应该要 temp 跟 a[j] 比较
                a[j + 1] = a[j];
            a[j + 1] = temp;
            //StdDraw.clear();
            //show((Double [] )a);
        }

    }

    public static void sort(Comparable[] a, int lo, int hi) {
        int N = hi + 1;
        int i, j;
        for (i = lo; i < N; i++) {
            Comparable temp = a[i];
            for (j = i - 1; j >= 0 && less(temp, a[j]); j--)  // 不能将 a[j+1] 与 a[j] 比较，应该要 temp 跟 a[j] 比较
                a[j + 1] = a[j];
            a[j + 1] = temp;
        }

    }

    //{3,1,5,2,6,2,9,0}
    // {1, 3, 5}
    // {}
    // 判断元素v, 是否比元素 w 小
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
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

}

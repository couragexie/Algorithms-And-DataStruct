package chapter2.part2_3;

import chapter2.part2_1.InsertSort;

public class QuickSort {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo + 8 >= hi) {
            InsertSort.sort(a, lo, hi);
            return;
        }
        int p = partition(a, lo, hi);
        sort(a, lo, p - 1);
        sort(a, p + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        while (lo < hi) {
            while ( /*lo < hi&&*/  a[hi].compareTo(a[lo]) > 0) hi--;
            if (lo < hi) {
                Comparable temp = a[hi];
                a[hi] = a[lo];
                a[lo] = temp;
                lo++;
            }
            while (/*lo < hi &&*/  a[lo].compareTo(a[hi]) < 0) lo++;
            if (lo < hi) {
                Comparable temp = a[hi];
                a[hi] = a[lo];
                a[lo] = temp;
                hi--;
            }
        }

        return hi;
    }


}

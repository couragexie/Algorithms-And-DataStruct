package chapter2.part2_2;

public class Merge {
    private static Comparable[] aux;  // 定义辅组数组

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;

        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid); // 归并左边数组
        sort(a, mid + 1, hi); // 归并右边数组
        merge(a, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[i].compareTo(aux[j]) < 0) a[k] = aux[i++];
            else a[k] = aux[j++];
    }

}

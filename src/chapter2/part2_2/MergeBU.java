package chapter2.part2_2;

public class MergeBU {

    //private static Comparable [] aux;
    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz)        // sz：子数组的长度
            for (int lo = 0; lo < N - sz; lo += sz + sz) //lo:子数组的索引
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));  // 归并两个数组
    }

    // 归并两个数组，a[]：待归并的数组，aux[]：辅组数组
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)        //数组左边元素用尽
                a[k] = aux[j++];
            else if (j > hi) // 数组右边元素用尽
                a[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0) // 要主要是比较辅组数组中的数据
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }


}

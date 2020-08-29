package chapter2.part2_4;

import edu.princeton.cs.algs4.StdOut;

public class HeapSort {

    public static void sort(Comparable[] a) {
        heapify(a);
        int N = a.length;
        while (N > 0) {
            exch(a, 0, --N);
            sink(a, 0, N);
        }

    }

    public static void heapify(Comparable[] a) {
        // 从获取最后一个元素的父节点开始，利用下沉函数一层一层堆化
        // ((data.length - 1) - 1)/2;s
        for (int i = ((a.length - 1) - 1) / 2; i >= 0; i--)
            sink(a, i, a.length);
    }

    public static void sink(Comparable[] a, int index, int N) {
        while ((2 * index) + 1 < N) {
            int j = (2 * index) + 1;
            if (j + 1 < N && a[j + 1].compareTo(a[j]) > 0)
                j++;
            if (a[index].compareTo(a[j]) >= 0) // 如果父节点小于等于子节点的话就结束
                break;
            exch(a, j, index);
            index = j;
        }
    }

    public static void exch(Comparable[] a, int v, int w) {
        Comparable t = a[v];
        a[v] = a[w];
        a[w] = t;
    }

}

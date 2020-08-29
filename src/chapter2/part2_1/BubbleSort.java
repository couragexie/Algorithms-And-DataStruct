package chapter2.part2_1;

public class BubbleSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    Comparable t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = a[j];
                    flag = false;
                }
                if (flag) break; // 提前退出循环
            }
        }
    }
}

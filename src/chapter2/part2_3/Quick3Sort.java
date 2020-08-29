package chapter2.part2_3;

public class Quick3Sort {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;

        int lt = lo, gt = hi;
        int i = lt;
        Comparable v = a[lo];
        while (i <= gt) {
            int cm = a[i].compareTo(v);
            if (cm < 0)
                exch(a, i++, lt++);
            else if (cm > 0)
                exch(a, i, gt--);
            else
                i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}

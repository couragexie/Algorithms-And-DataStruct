package chapter2.part2_3;

import java.util.Arrays;
import java.util.Random;

import TestUtil.Stopwatch;

public class Main {
    public static void main(String[] args) {
        //DoubleBlindTest();
        //Character [] ch = {'R', 'B', 'W', 'W', 'R', 'W', 'B', 'R', 'R', 'W', 'B', 'R' };
        //Quick3Sort.sort(ch);
        //for(char c : ch)
        //System.out.println(c + "  ");
        //System.out.println();

        int n = 100000000;
        Comparable[] a = makeArr(n);
        Comparable[] b = makeArr(n);
        Stopwatch sw1 = new Stopwatch();
        QuickSort1.sort(a);
        double time1 = sw1.elapsedTime();
        Stopwatch sw2 = new Stopwatch();
        Arrays.sort(b);
        double time2 = sw2.elapsedTime();
        System.out.println("time1 ：" + time1);
        System.out.println("time2 ：" + time2);
    }

    public static void DoubleBlindTest() {
        int N = 1000;
        int n = 10000;
        for (int i = 0; i < N; i++) {
            Comparable[] a = makeArr(n);
            Stopwatch sw = new Stopwatch();
            QuickSort1.sort(a);
            System.out.print(sw.elapsedTime() + "        ");
            System.out.println(isSorted(a));
        }
    }


    private static Comparable[] makeArr(int n) {
        Integer[] a = new Integer[n];
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = rd.nextInt(Integer.MAX_VALUE);
            //System.out.print(a[i] + "    ");
        }
        return a;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++)
            if (a[i].compareTo(a[i + 1]) > 0)
                return false;
        return true;
    }

}

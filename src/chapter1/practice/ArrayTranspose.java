package chapter1.practice;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ArrayTranspose {

    public static void transpose(int[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        } // close for
    }

    public static void main(String[] args) {
        int a[][] = new int[6][6];

        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                a[i][j] = StdRandom.uniform(10);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                StdOut.print(a[i][j]);
            }
            StdOut.println();
        }

        transpose(a);

        StdOut.println();
        StdOut.println();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                StdOut.print(a[i][j]);
            }
            StdOut.println();
        }
    }
}

package sort;

import java.util.Random;

public class InsertSort {
    private static void sort(int[] arr) {
        //int  temp;
        int i, j;
        int temp;
        for (i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (j = i - 1; j >= 0 && temp < arr[j]; j--)
                arr[j + 1] = arr[j];
            arr[j + 1] = temp;
        }

    }

    private static boolean check(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] > arr[i + 1])
                return false;

        return true;
    }
}

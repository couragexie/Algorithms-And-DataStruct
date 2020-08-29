package sort;

public class ShellSort {
    public static void sort(int[] arry) {
        int temp;
        int d, i, j;
        for (d = arry.length / 2; d > 0; d = d / 2) {
            for (i = d; i < arry.length; i++) {
                temp = arry[i];
                for (j = i - d; j >= 0 && temp < arry[j]; j -= d)
                    arry[j + d] = arry[j];
                arry[j + d] = temp;
            }
        }
    }


}

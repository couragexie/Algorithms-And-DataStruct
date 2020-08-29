package sort;

public class BubbleSort {
    public static void sort(int[] arry) {
        for (int i = arry.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (arry[j] > arry[j + 1]) {
                    int temp = arry[j];
                    arry[j] = arry[j + 1];
                    arry[j + 1] = temp;
                }
            }
        }
    }
}

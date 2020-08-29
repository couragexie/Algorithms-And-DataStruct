package sort;

public class SelectSort {
    public static void sort(int[] arry) {
        for (int i = 0; i < arry.length - 1; i++) {
            int index = i; // 存放最小点
            for (int j = i + 1; j < arry.length; j++) {
                if (arry[index] > arry[j])
                    index = j;
            }
            if (index != i) {
                int temp = arry[index];
                arry[index] = arry[i];
                arry[i] = temp;
            }
        }

    }


}

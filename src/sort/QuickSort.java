package sort;

public class QuickSort {
    public static void sort(int[] arry) {
        sort(arry, 0, arry.length - 1);
    }

    private static void sort(int[] arry, int first, int end) {
        if (first < end) {
            int index = partition(arry, first, end);
            sort(arry, first, index - 1);
            sort(arry, index + 1, end);
        }

    }

    //一次划分
    private static int partition(int[] arry, int first, int end) {
        int i = first;
        int j = end;
        while (i < j) {
            while (i < j && arry[i] <= arry[j]) j--;
            if (i < j) {
                int temp = arry[j];
                arry[j] = arry[i];
                arry[i] = temp;
                i++;
            }
            while (i < j && arry[i] <= arry[j]) i++;
            if (i < j) {
                int temp = arry[j];
                arry[j] = arry[i];
                arry[i] = temp;
                j--;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        //int [] arry = {23,13,49,6,31,19,28};
        int[] arry = {13, 15, 12, 8, 9, 5, 20};
        System.out.println(partition(arry, 0, arry.length - 1));
        for (int num : arry)
            System.out.print(num + " ");
    }
}

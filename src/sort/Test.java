package sort;

import java.util.Random;

public class Test {
    private static boolean check(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] > arr[i + 1])
                return false;

        return true;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[100];
        Random rm = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rm.nextInt(1000);
        }
        //for(int num: arr)
        //System.out.print(num + "  ");
        SelectSort.sort(arr);
        System.out.println(check(arr));
        for (int num : arr) {
            System.out.println(num + "  ");
        }
    }
}

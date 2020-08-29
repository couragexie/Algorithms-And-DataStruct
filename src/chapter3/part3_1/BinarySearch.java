package chapter3.part3_1;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.Arrays;

/**
 * @program: Algorithms
 * @description: 二分查找法
 * @author: Jay
 * @create: 2020-04-24 11:12
 **/

public class BinarySearch {
    public static int search(int a[], int target){
        int low = 0, high = a.length - 1, mid; //[low, high];
        while(low <= high){
            mid = low + ((high-low) >> 1);

            if(a[mid] < target)
                low = mid + 1;
            else if(a[mid] > target)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[100];

        for(int i = 0; i < 100; i ++)
            a[i] = i;
        System.out.println(search(a, 99));


    }
}

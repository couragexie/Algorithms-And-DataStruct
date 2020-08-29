package chapter3.part3_2;

import edu.princeton.cs.algs4.StdOut;

public class TestTree {
    public static void main(String[] args) {
        int[] a = {15, 8, 5, 12, 3, 18, 16, 17, 20};
        BST<Integer, String> bst = new BST<>();

        for (int i = 0; i < a.length; i++)
            bst.put(a[i], "\"" + a[i] + "\"");

        StdOut.println();
        bst.prePrint();

        StdOut.println();
        bst.postPrint();

        bst.levelOrder();
        System.out.println("获取：" + bst.get(18));
        System.out.println("删除：18");

        bst.delete(18);
        StdOut.println();
        for (Integer key : bst.keys())
            StdOut.print(key + "  ");
    }
}

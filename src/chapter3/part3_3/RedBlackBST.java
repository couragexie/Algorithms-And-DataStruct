package chapter3.part3_3;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean Red = true;
    private static final boolean Black = false;

    private class Node {
        Key key;
        Value val;
        int N;
        boolean color;   // true 为红， false 为黑
        Node left;
        Node right;

        Node(Key key, Value val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }

    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null)
            return 0;
        return node.N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = Red;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = Red;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public boolean isRed(Node node) {
        if (node == null)
            return false;
        return node.color;
    }

    /*		添加元素操作	*/

    // filp ： 翻转
    // 将 4-结点 分解成三个2-结点
    private void flipColor1(Node node) {
        node.color = Red;
        node.right.color = Black;
        node.left.color = Black;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = Black;
    }

    private Node put(Node node, Key key, Value val) {
        if (node == null)
            return new Node(key, val, Red);

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, val);
        else if (cmp > 0)
            node.right = put(node.right, key, val);
        else
            node.val = val;

        if (isRed(node.right) && !isRed(node.left))
            node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left))
            node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right))
            flipColor1(node);

        node.N = 1 + size(node.left) + size(node.right);
        return node;
    }

    /*    删除最小元素        */
    // 将三个 2-结点合成一个4-结点
    private void flipColor2(Node node) {
        node.color = Black;
        node.left.color = Red;
        node.right.color = Red;
    }

    // 保证根节点的左子节点不是 2-节点
    // 将其左子节点的兄弟节点移动到左子节点（实际上其兄弟节点是移动到父节点，原父节点移动到左子节点）
    private Node moveRedLeft(Node node) {
        // 将三个2-结点合并成4-结点
        flipColor2(node);
        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
        }
        return node;
    }

    // 调整平衡二叉树
    private Node balance(Node node) {
        if (isRed(node.right))
            node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left))
            node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right))
            flipColor1(node);

        node.N = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void deleteMin() {
        // Why ?
        if (!isRed(root.left) && !isRed(root.right))
            root.color = Red;
        root = deleteMin(root);
        if (!isEmpty())
            root.color = Black;
    }

    private Node deleteMin(Node node) {
        // 此时 node 是待删除的点
        if (node.left == null)
            return null;
        if (!isRed(node.left) && !isRed(node.left.left))
            node = moveRedLeft(node);
        node.left = deleteMin(node.left);

        return balance(node); // 向上调整平衡二叉树
    }

    public void preOder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null)
            return;

        preOrder(node.left);
        System.out.print(node.val + " " + node.color + "，   ");
        preOrder(node.right);
    }


    public static void main(String[] args) {
        int[] a = {20, 15, 6, 8, 21, 12};

        RedBlackBST<Integer, String> rbt = new RedBlackBST<>();

        for (int i = 0; i < a.length; i++)
            rbt.put(a[i], "'" + a[i] + "'");
        rbt.preOder();

        rbt.deleteMin();
        rbt.deleteMin();
        rbt.deleteMin();
        rbt.preOder();


    }


}

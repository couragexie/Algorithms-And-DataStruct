package chapter3.part3_2;

import java.util.LinkedList;
import java.util.Queue;

import chapter1.dataStructure.Quene;

public class BST<Key extends Comparable<Key>, Value> {
    private class Node {
        public Key key;
        public Value value;
        public int N; // 记录以该节点为根节点的子树的数量
        public Node left;
        public Node right;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
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

    public boolean contains(Key key) {
        return get(root, key) != null;
    }

    public boolean isEmpty(Key key) {
        return size() == 0;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return get(node.left, key);
        else if (cmp > 0)
            return get(node.right, key);
        else
            return node.value;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null)
            return node;
        return max(node.right);
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null)
            return node.left;
        node.right = deleteMax(node.right);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;

            Node d = node;

            node = min(d.right);
            node.right = deleteMin(d.right);
            node.left = d.left;  // 如果

        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }


    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node != null)
            return node.key;
        else
            return null;
    }

    private Node floor(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return node;
        if (cmp < 0)
            return floor(node.left, key);
        // cmp > 0 的情况
        Node t = floor(node.right, key);
        if (t == null)  // 说明该节点的右子树中没有符合的值，则符合的值为当前的值
            return node;
        return t;

    }

    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if (node != null)
            return node.key;
        return null;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp > 0)
            return floor(node.right, key);
        if (cmp == 0)
            return node;
        // cmp < 0 的情况
        Node t = floor(node.left, key);
        if (t == null)
            t = node;
        return t;
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    public Node select(Node node, int k) {
        if (node == null)
            return null;
        int ln = size(node.left); // 左节点的子树数量
        if (ln == k)
            return node;
        else if (ln > k)
            return select(node.left, k);
        else
            return select(node.right, k - ln - 1);  // 减去左边的全部节点的数量和根节点
    }

    public int ran(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if (node == null)
            return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return rank(node, key);
        if (cmp > 0)
            return 1 + size(node.left) + rank(node, key);
        else
            return size(node.left);
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Quene<Key> quene = new Quene<>();
        keys(root, lo, quene, hi);
        return quene;
    }

    private void keys(Node node, Key lo, Quene<Key> quene, Key hi) {
        if (node == null) return;
        int locmp = lo.compareTo(node.key);
        int hicmp = hi.compareTo(node.key);

        if (locmp < 0)
            keys(node.left, lo, quene, hi);
        if (locmp <= 0 && hicmp >= 0)
            quene.enquene(node.key);
        if (hicmp > 0)
            keys(node.right, lo, quene, hi);
    }

    public void prePrint() {
        prePrint(root);
    }

    private void prePrint(Node node) {
        if (node == null) return;
        System.out.print(node.key + "   ");
        prePrint(node.left);
        prePrint(node.right);
    }

    public void postPrint() {
        postPrint(root);
        System.out.println();
    }

    private void postPrint(Node node) {
        if (node == null) return;
        postPrint(node.left);
        System.out.print(node.key + "  ");
        postPrint(node.right);
    }

    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.print(cur.key + "  ");
            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
        System.out.println();
    }

}

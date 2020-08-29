package chapter3.part3_4;

public class SequentialSearchST<Key, Value> {
    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int size;
    private Node first;

    public int size() {
        return size;
    }

    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }         // 查找命中的情况
        first = new Node(key, value, first); // 查找未命中, 新建结点;
        size++;
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key))
                return x.value;   //查找命中
        }
        return null;        // 查找未命中
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void delete(Key key) {
        if (!contains(key)) return;

        if (key.equals(first.key)) {
            first = first.next;
            size--;
            return;
        }

        Node pre = first;
        while (!key.equals(pre.next.key))
            pre = pre.next;

        Node node = pre.next;
        pre.next = node.next;
        node.next = null;
        size--;
    }

}

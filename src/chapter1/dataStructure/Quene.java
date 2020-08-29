package chapter1.dataStructure;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class Quene<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
    }

    public void enquene(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        size++;
    }

    public Item dequene() {
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int getSize() {
        return size;
    }

    public Item getHead() {
        if (isEmpty())
            throw new IllegalArgumentException("队列为空！");
        return first.item;
    }

    public Iterator<Item> iterator() {
        return new LikedQuene();
    }

    private class LikedQuene implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Quene<Integer> quene = new Quene<>();
        for (int i = 0; i < 20; i++) {
            quene.enquene(i);
        }
        for (int num : quene) {
            StdOut.println(num);
        }
        quene.dequene();
        quene.dequene();

        StdOut.println();
        //StdOut.println(quene.dequene());
        for (int num : quene) {
            StdOut.println(num);
        }
    }
}

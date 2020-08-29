package chapter4;

import java.util.Iterator;

public class Bag<E> implements Iterable<E> {
    private class Node {
        E data;
        Node next;
    }

    private int size;
    private Node head;

    public void add(E data) {
        Node oldHead = head;
        head = new Node();
        head.data = data;
        head.next = oldHead;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E data = current.data;
            current = current.next;
            return data;
        }
    }

}

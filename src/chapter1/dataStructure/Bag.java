package chapter1.dataStructure;

import java.util.Iterator;

/**
 * @param <E>
 * @author xj138
 */
/*
 * 背包
 * */
public class Bag<E> implements Iterable<E> {
    private class Node {
        E data;
        Node next;
    }

    private int size;
    private Node head;

    public Bag() {
        size = 0;
    }
	
	/*
	public int size() {
			return size;
	}*/

    public void add(E data) {
        Node oldHead = head;
        head = new Node();
        head.data = data;
        head.next = oldHead;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            E data = current.data;
            current = current.next;
            return data;
        }

        public void remove() {
        }
    }

}

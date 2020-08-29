package chapter1.dataStructure;

import java.util.Iterator;

/**
 * @param <E> Method: Stack()
 *            void push(E data)
 *            E pop()
 *            boolean isEmpty()
 *            int getSize()
 * @author xj138
 */
public class Stack<E> implements Iterable<E> {
    private class Node {
        E data;
        Node next;
    }

    private Node head;
    private int size;

    public Stack() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public void push(E data) {
        Node oldHead = head;
        head = new Node();
        head.data = data;
        head.next = oldHead;
        size++;
    }

    public E pop() {
        E data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public E peek() {
        if (isEmpty())
            throw new IllegalArgumentException("栈为空！");
        return head.data;
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

//	public static void main(String [] args) {
//		Stack<Integer> stack = new Stack<>();
//		stack.isEmpty();
//		stack.size();
//		for(int i = 0;  i < 20; i++ )
//			stack.push(i);
//		System.out.println(stack.get());
//		System.out.println(stack.pop());
//		
//		for(int num:stack)
//			System.out.println(num);
//	}
//	
}

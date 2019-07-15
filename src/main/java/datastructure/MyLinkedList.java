package datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    public void add(final T t) {
        if (tail == null) {
            head = new Node<>();
            head.data = t;
            tail = head;
            return;
        }

        Node<T> newTail = new Node<>();
        newTail.data = t;
        tail.next = newTail;
        this.tail = newTail;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();

                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private static class Node<T> {
        T data;
        Node<T> next;
    }

}

package datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    public void offer(T t) {
        if (head == null) {
            head = new Node<>();
            tail = head;
            head.value = t;
            return;
        }

        Node<T> newNode = new Node<>();
        newNode.value = t;
        tail.next = newNode;
        tail = newNode;
    }

    public T poll() {
        if (head == null) return null;

        T value = head.value;

        head = head.next;
        if (head == null) {
            tail = null;
            return value;
        }

        return value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T value = currentNode.value;
                currentNode = currentNode.next;
                return value;
            }
        };
    }

    private static class Node<T> {

        T value;
        Node<T> next;
    }
}

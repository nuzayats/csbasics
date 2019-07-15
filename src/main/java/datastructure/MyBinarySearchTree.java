package datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MyBinarySearchTree<K extends Comparable<? super K>, V> implements Iterable<MyBinarySearchTree.Entry<K, V>> {

    private Node<K, V> root;

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) {
            Node<K, V> newNode = new Node<>();
            newNode.entry = new Entry<>();
            newNode.entry.key = key;
            newNode.entry.value = value;
            return newNode;
        }

        int cmp = key.compareTo(node.entry.key);

        if (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else node.entry.value = value;

        return node;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node<K, V> node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.entry.key);
        if (cmp == 0) return node.entry.value;
        if (cmp < 0) return get(node.left, key);
        return get(node.right, key);
    }

    private void traverse(MyQueue<Entry<K, V>> queue, Node<K, V> node) {
        if (node == null) return;

        traverse(queue, node.left);
        queue.offer(node.entry);
        traverse(queue, node.right);
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        MyQueue<Entry<K, V>> queue = new MyQueue<>();
        traverse(queue, root);
        return queue.iterator();
    }

    public Iterator<Entry<K, V>> depthFirstIterator() {
        return new DepthFirstIterator<>(root);
    }

    public static class Entry<K extends Comparable<? super K>, V> {
        K key;
        V value;

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private static class Node<K extends Comparable<? super K>, V> {
        Node<K, V> left;
        Node<K, V> right;
        Entry<K, V> entry;
    }

    private static class DepthFirstIterator<K extends Comparable<? super K>, V> implements Iterator<Entry<K, V>> {

        private Deque<Node<K, V>> stack = new ArrayDeque<>();
        private Node<K, V> next;

        public DepthFirstIterator(Node<K, V> root) {
            stack.push(root);
            findNext();
        }

        private void findNext() {
            if (stack.isEmpty()) {
                next = null;
                return;
            }

            next = stack.pop();

            if (next.right != null) {
                stack.push(next.right);
            }
            if (next.left != null) {
                stack.push(next.left);
            }
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Entry<K, V> next() {
            Entry<K, V> entry = next.entry;
            findNext();
            return entry;
        }
    }

    public Iterator<Entry<K, V>> breadthFirstIterator() {
        return new BreadthFirstIterator<>(root);
    }

    private static class BreadthFirstIterator<K extends Comparable<? super K>, V> implements Iterator<Entry<K, V>> {

        private Deque<Node<K, V>> queue = new ArrayDeque<>();
        private Node<K, V> next;

        public BreadthFirstIterator(Node<K, V> next) {
            queue.offer(next);
            findNext();
        }

        private void findNext() {
            if (queue.isEmpty()) {
                next = null;
                return;
            }

            next = queue.poll();

            if (next.left != null) {
                queue.offer(next.left);
            }
            if (next.right != null) {
                queue.offer(next.right);
            }
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Entry<K, V> next() {
            Entry<K, V> entry = next.entry;
            findNext();
            return entry;
        }
    }
}

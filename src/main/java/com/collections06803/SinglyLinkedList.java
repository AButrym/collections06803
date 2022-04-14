package com.collections06803;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements Stack<T>, Queue<T> {

    public static void main(String[] args) {
        var list = new SinglyLinkedList<Integer>();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);

        var it1 = list.iterator();
        it1.next();
        var it2 = list.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            System.out.println(it1.next() + " : " + it2.next());
        }

        System.out.println("Bye!");
    }

    private static class Node<V> {
        V value;
        Node<V> next;

        public Node() {
            next = this;
        }

        public Node(V value, Node<V> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int size = 0;
    private final Node<T> head = new Node<>();
    private Node<T> tail = head;

    private void addToHead(T value) {
        head.next = new Node<>(value, head.next);
        size++;
    }

    private void addToTail(T value) {
        // TODO
    }

    private T getFromHead() {
        throwsWhenEmpty();
        var res = head.next.value;
        head.next = head.next.next;
        size--;
        if (size == 0) {
            tail = head;
        }
        return res;
    }

    private void throwsWhenEmpty() {
        if (size == 0) {
            throw new NoSuchElementException("The collection is empty");
        }
    }

    @Override
    public void add(T value) {
        addToHead(value);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        head.next = head;
        tail = head;
    }

    @Override
    public void enqueue(T value) {
        addToTail(value);
    }

    @Override
    public T dequeue() {
        return getFromHead();
    }

    @Override
    public void push(T value) {
        addToHead(value);
    }

    @Override
    public T pop() {
        return getFromHead();
    }

    @Override
    public T peek() {
        throwsWhenEmpty();
        return head.next.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new HeadToTailIterator();
    }

    public void reverse() {
        // TODO
    }

    private class HeadToTailIterator implements Iterator<T> {
        Node<T> cursor = head;

        @Override
        public boolean hasNext() {
            return cursor.next != head;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            cursor = cursor.next;
            return cursor.value;
        }

        @Override
        public void remove() {
            // TODO
        }
    }
}

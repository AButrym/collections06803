package com.collections06803;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Deque<T> {
    private static class Node<V> {
        V value;
        Node<V> next;
        Node<V> prev;

        public Node() {
            next = this;
            prev = this;
        }

        public Node(V value, Node<V> next, Node<V> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private final Node<T> head = new Node<T>();
    private int size = 0;

    @Override
    public void addFirst(T value) {
        var oldFirst = head.next;
        var newFirst = new Node<T>(value, oldFirst, head);
        head.next = newFirst;
        oldFirst.prev = newFirst;
        size++;
    }

    @Override
    public void addLast(T value) {
        // TODO
        size++;
    }

    @Override
    public T getFirst() {
        throwsWhenEmpty();
        var firstNode = head.next;
        var secondNode = firstNode.next;

        head.next = secondNode;
        secondNode.prev = head;

        size--;
        return firstNode.value;
    }

    @Override
    public T getLast() {
        throwsWhenEmpty();
        // TODO
        size--;
        return null;
    }

    @Override
    public T peekFirst() {
        throwsWhenEmpty();
        return head.next.value;
    }

    @Override
    public T peekLast() {
        throwsWhenEmpty();
        return head.prev.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        head.next = head;
        head.prev = head;
    }

    @Override
    public ListIterator<T> iterator() {
        return new DirectIterator();
    }

    public ListIterator<T> reverseIterator() {
        return new ReverseIterator();
    }

    private class DirectIterator implements ListIterator<T> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public T previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

        }
    }

    private class ReverseIterator implements ListIterator<T> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public T previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {

        }

        @Override
        public void add(T t) {

        }
    }

    public void reverse() {
        var first = head.next;
        var last = head.prev;
        head.next = last;
        last.prev = head;
        head.prev = first;
        first.next = head;
    }

    private void throwsWhenEmpty() {
        if (size == 0) {
            throw new NoSuchElementException("The collection is empty");
        }
    }
}

package com.collections06803;

import java.util.Iterator;

public interface Deque<T> extends Queue<T>, Stack<T> {
    void addFirst(T value);
    void addLast(T value);
    T getFirst();
    T getLast();
    T peekFirst();
    T peekLast();

    @Override
    default void add(T value) {
        addLast(value);
    }

    @Override
    default void enqueue(T value) {
        addLast(value);
    }

    @Override
    default T dequeue() {
        return getFirst();
    }

    @Override
    default void push(T value) {
        addFirst(value);
    }

    @Override
    default T pop() {
        return getFirst();
    }

    @Override
    default T peek() {
        return peekFirst();
    }
}

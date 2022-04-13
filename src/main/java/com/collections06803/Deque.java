package com.collections06803;

public interface Deque<T> extends Queue<T> {
    void addFirst(T value);
    void addLast(T value);
    T getFirst();
    T getLast();

    @Override
    default void enqueue(T value) {
        addLast(value);
    }

    @Override
    default T dequeue() {
        return getFirst();
    }
}

package com.collections06803;

public interface Stack<T> extends MyCollection<T> {
    void push(T value);
    T pop();
    T peek();

    @Override
    default void add(T value) {
        push(value);
    }
}

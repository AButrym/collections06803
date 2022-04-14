package com.collections06803;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {
    SinglyLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList<>();
    }

    @Test
    void add() {
    }

    @Test
    void size() {
    }

    @Test
    void clear() {
    }

    @Test
    void enqueue() {
    }

    @Test
    void dequeue() {
    }

    @Test
    void peek1() {
        String el = "#1";
        list.push(el);

        assertEquals(el, list.peek());
    }
    @Test
    void peek2() {
        var exception = assertThrows(NoSuchElementException.class, () -> {
            list.peek();
        });
        assertEquals("The collection is empty", exception.getMessage());
    }

    @Test
    void name() {
        assertTrue(list.isEmpty());
    }

    @Test
    void pop() {
        String[] elements = {"#1", "#2", "#3"};
        for (var el : elements) {
            list.push(el);
        }
        assertEquals(elements.length, list.size());
    }

    @Test
    void pop2() {
        String[] elements = {"#1", "#2", "#3"};
        for (var el : elements) {
            list.push(el);
        }
        var last = list.pop();
        assertEquals(elements[elements.length - 1], last);
        assertEquals(elements.length - 1, list.size());
    }

    @Test
    void reverse() {
        List<String> elements = List.of("#1", "#2", "#3");
        for (var el : elements) {
            list.push(el);
        }
        list.reverse();
        int count = 0;
        for (Iterator<String> it1 = elements.iterator(), it2 = list.iterator();
             it1.hasNext() && it2.hasNext();
        ) {
            count++;
            assertEquals(it1.next(), it2.next());
        }
        assertEquals(elements.size(), count);
        assertEquals(elements.size(), list.size());
    }

    @Test
    void iterator() {
    }
}
package ru.job4j.list.forwardlinked;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size;
    private int outSize;

    public T poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (outSize == 0) {
            while (size > 0) {
                out.push(in.pop());
                size--;
                outSize++;
            }
        }
        outSize--;
        return out.pop();
    }

    public void push(T value) {
        size++;
        in.push(value);
    }
}
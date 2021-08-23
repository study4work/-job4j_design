package ru.job4j.list;

import java.sql.SQLOutput;
import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
    Objects.checkIndex(index, container.length);
    T setValue = container[index];
    container[index] = newValue;
    return setValue;
    }

    @Override
    public T remove(int index) {
    Objects.checkIndex(index, container.length);
    T removeValue = container[index];
    modCount++;
    size--;
    System.arraycopy(container, index + 1, container, index, container.length - index - 1);
    container[container.length - 1] = null;
    return removeValue;
    }

    @Override
    public T get(int index) {
    Objects.checkIndex(index, container.length);
    return container[index];
    }

    @Override
    public int size() {
    return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            final int expectedModCount = modCount;
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return container[index++];
            }

        };
    }
}
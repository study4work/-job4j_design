package ru.job4j.list.linkedlist;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.lang.IndexOutOfBoundsException;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements List<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;
    private int modCount;


    public SimpleLinkedList() {
        last = new Node<E>(null, null, first);
        first = new Node<E>(null, last, null);

    }

    public class Node<E> {
        E curentElement;
        Node<E> nextElement;
        Node<E> prevElement;

        public Node(E curentElement, Node<E> nextElement, Node<E> prevElement) {
        this.curentElement = curentElement;
        this.nextElement = nextElement;
        this.prevElement = prevElement;
        }
    }

    @Override
    public void add(E value) {
        Node<E> newNode = last;
        newNode.curentElement = value;
        last = new Node<>(null, null, newNode);
        newNode.nextElement = last;
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> target = first.nextElement;
        for (int i = 0; i < index; i++) {
        target = target.nextElement;
        }
        return target.curentElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            final int expectedModCount = modCount;
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return get(counter++);
            }
        };
    }

    public static void main(String[] args) {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.get(1));

    }
}
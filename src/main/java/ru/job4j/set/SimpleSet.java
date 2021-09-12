package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(16);

    @Override
    public boolean add(T value) {
        if (!contains(value)) {
            set.add(value);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        for (T t: set) {
            if (value == null) {
                return t == value;
            }
            if (t.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

    public static void main(String[] args) {
        SimpleSet<Integer> ss = new SimpleSet<>();
        ss.add(1);
        for (Integer i : ss) {
            System.out.println(i);
        }
    }
}
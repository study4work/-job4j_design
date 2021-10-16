package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    public int size() {
        return count;
    }

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        boolean rsl = false;
        int i = key == null ? 0 : indexResult(key);
        if (table[i] == null) {
            table[i] = new MapEntry<>(key, value);
            count++;
            modCount++;
            rsl = true;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode % table.length;
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        MapEntry<K, V>[] buffer = table;
        capacity = capacity * 2;
         table = new MapEntry[capacity];
         count = 0;
      for (MapEntry<K, V> map : buffer) {
          if (map != null) {
              put(map.key, map.value);
              count++;
          }
        }
    }

    private int indexResult(K key) {
        return indexFor(hash(key.hashCode()));
    }

    @Override
    public V get(K key) {
        return table[indexResult(key)].key.equals(key)
                ? table[indexResult(key)].value : null;
    }

    @Override
    public boolean remove(K key) {
        if (table[indexResult(key)].key.equals(key)) {
            table[indexResult(key)] = null;
            modCount++;
            count--;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            final int expectedModCount = modCount;
            int iteratorCounter = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iteratorCounter < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (table[iteratorCounter] == null) {
                    iteratorCounter++;
                }
                return table[iteratorCounter].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

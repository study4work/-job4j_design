package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private  final int[] numbers;
    int point = 0;

    public EvenIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    public int evenNumber() {
        for (int i = point; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                return point = i;
            }
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        evenNumber();
        return numbers[point] % 2 == 0;
    }


    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
       return numbers[point++];
        }

    public static void main(String[] args) {
        Iterator<Integer> it = new EvenIterator(new int[] {1, 2, 3, 4, 5, 6, 7});

        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
    }
}

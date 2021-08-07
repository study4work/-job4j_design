package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private  final int[] numbers;
    int point = -1;
    int tempCount = 0;

    public EvenIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    public int evenNumber() {
        for (int i = point + 1; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        tempCount = evenNumber();
        return tempCount != -1;
    }


    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        point = tempCount;
       return numbers[point];
        }

    public static void main(String[] args) {
        Iterator<Integer> it = new EvenIterator(new int[] {2, 4, 6, 8});
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

package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
    while (data[row].length == 0) {
        if (row < data.length) {
            row++;
        }
        if (row == data.length) {
            return false;
        }
    }
    return true;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (column < data[row].length) {
            column++;
            return data[row][column - 1];
        } else {
                column = 1;
                row++;
                hasNext();
                return data[row][column - 1];
            }
    }

    public static void main(String[] args) {
        int[][] in = {{1}, {}, {}, {}, {2}};
        MatrixIt matrixIt = new MatrixIt(in);
        System.out.println(matrixIt.next());
        System.out.println(matrixIt.next());
    }

}
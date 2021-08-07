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
        boolean rsl = false;
        if (column < data[row].length) {
            rsl = true;
        }
        if (column == data[row].length && data[row].length != 0){
            row++;
            column = 0;
            rsl = true;
        }
        while (data[row].length == 0) {
            if (row < data.length) {
                row++;
                rsl = true;
            }
            if (row == data.length) {
                return false;
            }
    }
    return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    return data[row][column++];
    }

    public static void main(String[] args) {
        int[][] in = {{}, {1}};
        MatrixIt matrixIt = new MatrixIt(in);
        System.out.println(matrixIt.next());

    }

}
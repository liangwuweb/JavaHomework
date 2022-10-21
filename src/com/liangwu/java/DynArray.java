package com.liangwu.java;

public class DynArray {
    private double[] array;
    private int size;
    private int nextIndex;

    public DynArray() {
        array = new double[1];
        size = 1;
        nextIndex = 0;
    }


    // accessor
    public int arraySize() {
        return this.size;
    }

    // accessor
    public int elements() {
        return this.nextIndex;
    }

    // accessor
    public double at(int index) {
        if (index >= 0 && index < this.elements()) {
            return this.array[index];
        } else {
            return Double.NaN;
        }
    }

    private void grow() {
        double[] temp = new double[size * 2];

        for (int i = 0; i < this.elements(); ++i) {
            temp[i] = array[i];
        }
        array = temp;
        size = size * 2;
    }

    private void shrink() {
        double[] temp = new double[size / 2];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
        size = size / 2;
    }

    // mutator
    public void insertAt(int index, double value) {
        if (index >= 0 && index <= this.elements()) {
            // Check wether need to grow the array size
            if (this.elements() == this.arraySize()) {
                this.grow();
            }
            // Shift all the elements on the right of the given index with one
            for (int i = nextIndex - 1; i >= index; --i) {
                this.array[i + 1] = this.array[i];
            }
            // insert value at locatioin index
            this.array[index] = value;
            // increase nextIndex by one
            ++ nextIndex;
        }
    }

    // mutator
    public void insert(double value) {
        // insert value at location nextIndex.
        this.insertAt(this.elements(),  value);
    }

    // mutator
    public double removeAt(int index) {
        if (index >= 0 && index < this.elements()) {

            double removed = this.array[index];
            // Shift to left all the elements on the right of the given index with one
            for (int i = index; i < this.elements() - 1; i ++) {
                this.array[i] = this.array[i + 1];
            }
            this.array[this.elements() - 1] = 0.0;
            -- this.nextIndex;
            // Check if we need to shrink the array
            if (this.elements() < this.arraySize() / 2) {
                this.shrink();
            }
            return removed;
        } else {
            return Double.NaN;
        }
    }

    // mutator
    public double remove() {
        return this.removeAt(this.elements() - 1);
    }

    // accessor
    public void printArray() {
        for (int i = 0; i < this.elements(); ++i) {
            System.out.println("array.at(" + i + ") = " + this.array[i]);
        }
    }


}

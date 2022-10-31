package com.liangwu.java;

public class Queue extends DynArray {
    // default constructor
    public Queue() {}

    // returns the number of values which are currently on the stack
    public int size() {
        return super.elements();
    }

    // returns true only if there are no values on the stack
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // add the specified value into the queue
    public void que(double value) {
        super.insert(value);
    }

    // Remove elements from Queue, FIFO
    public double deQue() {
        if (!this.isEmpty()) {
            return super.removeAt(0);
        } else {
            return Double.NaN;
        }
    }

    // print all of the values currenty in the queue
    public void queueDump() {
        for (int i = 0; i < this.size(); ++i) {
            System.out.println("array.at(" + i + ") = " + super.getArray()[i]);
        }

    }
}

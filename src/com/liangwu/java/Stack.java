package com.liangwu.java;

public class Stack extends DynArray {

    // default constructor
    public Stack() {}

    // returns the number of values which are currently on the stack
    public int size() {
        return super.elements();
    }

    // returns true only if there are no values on the stack
    public boolean isEmpty() {
        return this.size() == 0;
    }

    // add the specified value onto the stack
    public void push(double value) {
        super.insert(value);
    }

    // Remove elements from stack, FILO
    public double pop() {
        if (!this.isEmpty()) {
            return super.removeAt(this.size() - 1);
        } else {
            return Double.NaN;
        }
    }

    // print all of the values currenty on the stack
    public void stackDump() {
        for (int i = (this.size() - 1); i >= 0; --i) {
            System.out.println(super.getArray()[i]);
        }
    }
}

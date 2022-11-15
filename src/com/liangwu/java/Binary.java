package com.liangwu.java;

public class Binary extends BitString {

    public Binary() {

    }

    // encode a non-negative (base 10) number val into the
    // host's bitstring - used in the Binary(long val) constructor
    private void encode(long val) {
        while (val > 0) {
            int remainder = (int) val % 2;
            val = val / 2;
            this.addBit(new BinaryBit(remainder));
        }
    }

    public Binary(long val) {
        this.encode(val);
    }

    // Specifying constructor
    public Binary(BitString guest) {
        super(guest);
    }

    // Copy constructor
    public Binary(Binary guest) {
        this((BitString) guest);
    }

    public Binary clone() {
        return new Binary(this);
    }


    // return a new Binary number that is the result of adding the
    // host bitstring to the guest bitstring under the assumption
    // that both are representing (base 2) numbers
//    public Binary addition(Binary guest) {
//
//    }

}

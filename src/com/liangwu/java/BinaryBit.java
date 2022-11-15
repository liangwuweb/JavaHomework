package com.liangwu.java;

public class BinaryBit extends AbstractBit{
    public static final BinaryBit zero = new BinaryBit(false);
    public static final BinaryBit one = new BinaryBit(true);

    public BinaryBit() {

    }

    // Specify constructor
    public BinaryBit(boolean bit) {
        super(bit);
    }

    public BinaryBit(int bit) {
        super(bit == 1);
    }

    // Copy constructor
    public BinaryBit(BinaryBit guest) {
        super(guest);
    }

    public BinaryBit clone() {
        return new BinaryBit(this);
    }

    public boolean equals(BinaryBit guest) {
        return super.equals(guest);
    }

    public String toString() {
        return super.toString();
    }

    // returns the low order bit of adding the host bit to the guest bit
    public AbstractBit addBits(AbstractBit guest) {
        return BinaryBit.zero;
    }

    // returns the low order bit of adding the host bit, the guest1 bit, and the guest2 bit
    public AbstractBit addBits(AbstractBit guest1, AbstractBit guest2) {
        return BinaryBit.zero;
    }

    // returns the high order bit of adding the host bit to the guest bit
    public AbstractBit carryBit(AbstractBit guest) {
        return BinaryBit.zero;
    }

    // returns the high order bit of adding the host bit to the guest bit
    public AbstractBit carryBit(AbstractBit guest1, AbstractBit guest2) {
        return BinaryBit.zero;
    }
}

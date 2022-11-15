package com.liangwu.java;

public abstract class  AbstractBit {
    private boolean bit;

    public abstract AbstractBit clone();
    public abstract AbstractBit addBits(AbstractBit guest);
    public abstract AbstractBit addBits(AbstractBit guest1, AbstractBit guest2);
    public abstract AbstractBit carryBit(AbstractBit guest);
    public abstract AbstractBit carryBit(AbstractBit guest1, AbstractBit guest2);


    protected void setBit(boolean value) {
        this.bit = value;
    }

    public boolean getBit() {
        return this.bit;
    }

    public AbstractBit() {
        this.setBit(false);
    }

    // Specify constructor
    public AbstractBit(boolean value) {
        this.setBit(value);
    }

    // Copy constryctor
    public AbstractBit(AbstractBit guest) {
        this(guest.getBit());
    }

    public boolean equals(AbstractBit guest) {
        return this.getBit() == guest.getBit();
    }

    public String toString() {
        return this.getBit() ? "1" : "0";
    }
}

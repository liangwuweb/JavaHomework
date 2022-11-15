package com.liangwu.java;

import java.util.ArrayList;

public class BitString {
    // an ordered sequence of bits
    private ArrayList<AbstractBit> bitString;

    // mutator
    private void setAbstractBitList(ArrayList<AbstractBit> bitList) {
        this.bitString = bitList;
    }

    // Accessor
    protected ArrayList<AbstractBit> getAbstractBitList() {
        return this.bitString;
    }

    //mutator, adds a bit to the end of the arrayList of bits
    public void addBit(AbstractBit bit) {
        // reverse the order of element in ArrayList
        this.bitString.add(0, bit);
    }

    // returns a reference to the bit at location loc in the ArrayList of bits
    public AbstractBit bitAt(int loc) {
        return this.getAbstractBitList().get(loc - 1);
    }

    public BitString() {
        this.setAbstractBitList(new ArrayList<AbstractBit>());
    }

    // Specifying constructor
    protected BitString(ArrayList<AbstractBit> bitList) {
        this.setAbstractBitList(bitList);
    }

    // Copy constructor
    public BitString(BitString guest) {
        this(guest.getAbstractBitList());
    }

    public boolean isEmpty()
    {
        return this.getAbstractBitList().size() == 0;
    }


    public int length()
    {
        return this.getAbstractBitList().size();
    }

    public BitString clone()
    {
        return new BitString(this);
    }

    public boolean equals(BitString guest) {
        // Check if two bitString are point to same object
        if (this == guest) {
            return true;
        }
        // Check if two bitString are same length, if not return false
        if (this.length() == guest.length()) {
        // compare two bitString
            for(int i = 1; i <= this.getAbstractBitList().size(); ++i) {
                if (!(this.bitAt(i) == guest.bitAt(i))) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public String toString() {
        if (this.isEmpty()) {
            return BinaryBit.zero.toString();
        } else {

            String str = "";
            for (AbstractBit element : this.getAbstractBitList()) {
                str += element;
            }
            return str;
        }
    }
}

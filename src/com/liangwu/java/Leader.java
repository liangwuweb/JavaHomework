package com.liangwu.java;

public class Leader extends Member{
    private int year;

    // default constructor
    public Leader() {
        this("",0, 2000);
    }

    // specify constructor
    public Leader(String name, int id, int year) {
        super(name, id);
        this.year = year;
    }

    // accessor
    public int getYear(){
        return this.year;
    }
}

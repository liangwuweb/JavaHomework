package com.liangwu.java;

public class Leader extends Member{
    private String year;

    // default constructor
    public Leader() {
        this("",0, "First year");
    }

    // specify constructor
    public Leader(String name, int id, String year) {
        super(name, id);
        this.year = year;
    }

    // accessor
    public String getYear(){
        return this.year;
    }
}

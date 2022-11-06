package com.liangwu.java;

public class Member extends Person {
    private int id;

    // default constructor
    public Member() {
        this("",0);
    }

    // specify constructor
    public Member(String name, int id) {
        super(name);
        this.id = id;
    }

    // accessor
    public int getId() {
        return this.id;
    }
}

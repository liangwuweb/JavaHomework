package com.liangwu.java;

public class Person {
    private String name;

    // default constructor
    public Person(){
        this("");
    }

    // specify constructor
    public Person(String name) {
       this.name = name;
    }

    // accessor
    public String getName() {
        return this.name;
    }
}

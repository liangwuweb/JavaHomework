package com.liangwu.java;

public class Driver {
    public static void main(String[] args) {
        Member ryne = new Member("Ryne", 1);
        Member Alice = new Member("Alice", 2);
        Member Liang = new Member("Liang", 6);
        Org org1 = new Org("Org one", new Leader("Alec", 3, "First year"));
        Org org2 = new Org("Org two", new Leader("Joshua", 5, "Second year"));

        org1.addMembers(Liang);
        org1.addMembers(Alice);
        org2.addMembers(Liang);
        org2.addMembers(ryne);

        System.out.println(org1.toString());
        System.out.println();
        System.out.println(org2.toString());
    }
}

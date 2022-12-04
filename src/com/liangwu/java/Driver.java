package com.liangwu.java;

public class Driver {
    public static void main(String[] args) {
        Salaries org1 = new Salaries();

//        org1.create("fileToMerge1");
//        org1.create("fileToMerge2");
//        org1.create("fileAfterMerge");
        //org1.display("org1");
        //System.out.println(org1.addTo("org1","org2Copy2", 9, 130_000, 1));
        //System.out.println(org1.removeFrom("org1","org2Copy", 1));
        //org1.addService("org1","org1Copy3");
        //System.out.println(org1.raise("org1", "org1Copy4", 1, 0.1));
        org1.mergeFiles("fileToMerge1","fileToMerge2","fileAfterMerge");
    }
}

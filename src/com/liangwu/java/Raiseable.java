package com.liangwu.java;

import java.io.IOException;

public interface Raiseable {
    void create(String fileName) throws IOException;

    void display(String fileName);

    boolean addTo(String inFileName, String outFileName, int id, double salary,
                  int yearsOfService) throws IOException;

    boolean removeFrom(String inFileName, String outFileName, int id);


    void addService(String inFileName, String outFileName);

    int raise(String inFileName, String outFileName, int yearsOfService,
              double salaryIncPercent);

    void mergeFiles(String inFileName1, String inFileName2, String outFileName);
}

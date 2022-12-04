package com.liangwu.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Demo {
    public void addTo(String inFileName) {
        String line1;
        String line2;

        try (Scanner fileIn = new Scanner(Paths.get(inFileName));
             //Scanner fileIn2 = new Scanner(Paths.get(inFileName));
             //PrintWriter fileOut = new PrintWriter(outFileName);
        )
        {
            while (fileIn.hasNextLine())  // while the input file is not empty
            {
                line1 = fileIn.nextLine();
                int line1Value = Integer.parseInt(line1);
                if (fileIn.hasNext()) {
                    line2 = fileIn.nextLine();
                    int line2Value = Integer.parseInt(line2);
                    int temp = 0;
                    if (line1Value > line2Value) {
                        temp = line1Value;
                        line1Value = line2Value;
                        line2Value = temp;
                    }
                    System.out.println(line1Value);
                    System.out.println(line2Value);
                } else {
                    System.out.println(line1);
                }
            }


        } catch (FileNotFoundException | InvalidPathException e) {
            System.out.println("Filename invalid or not found");
        }
        catch (IOException e) {
            System.out.println("File I/O error");
        }

    }

    public static void main(String[] args) {
        Demo demo = new Demo();

        //demo.addTo("myFile");
        String value = "";

        if (value == "") {
            System.out.println("hello");
        }
    }

}

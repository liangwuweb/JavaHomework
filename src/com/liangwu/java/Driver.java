package com.liangwu.java;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Salaries org1 = new Salaries();

        // Create a file
        org1.create("myFile");

        // Add entries to the file
        try (PrintWriter fileOut = new PrintWriter("myFile");)
        {
            fileOut.println("1:80000.00:2");
            fileOut.println("3:90000.00:3");
            fileOut.println("5:70000.00:5");
        } catch (FileNotFoundException e) {
            System.out.println("Filename not found");
        }

        // Display the file
        System.out.println("Diplay the file: ");
        System.out.println();
        org1.display("myFile");


        System.out.println();

        // Add to file
        System.out.println("Add to the file: ");
        System.out.println();
        System.out.println("No Match id was found: " + org1.addTo("myFile", "myFileOutAdd", 2, 60000, 3));
        org1.display("myFileOutAdd");

        System.out.println();

        // Remove from file
        System.out.println("Remove from the file: ");
        System.out.println();
        System.out.println("Matching id was found: " + org1.removeFrom("myFileOutAdd", "myFileOutRemove", 2));
        org1.display("myFileOutRemove");

        System.out.println();

        // Add Service
        System.out.println("Increase year of service for all entries: ");
        System.out.println();
        org1.addService("myFile", "myFileAddService");
        org1.display("myFileAddService");

        System.out.println();

        // Callinf rasie method
        System.out.println("Increase salary if year >= 3: ");
        System.out.println();
        org1.raise("myFile", "myFileRaise", 3, 0.2);
        org1.display("myFileRaise");

        // Merge two file
        // Create another file

        org1.create("myFile2");

        // Add entries to the file
        try (PrintWriter fileOut = new PrintWriter("myFile2");)
        {
            fileOut.println("2:68000.00:6");
            fileOut.println("4:95000.00:10");
            fileOut.println("6:88800.00:8");
        } catch (FileNotFoundException e) {
            System.out.println("Filename not found");
        }

        System.out.println();

        System.out.println("myFile and myFile2 before merge: ");
        System.out.println();
        System.out.println("myFile: ");
        org1.display("myFile");
        System.out.println();
        System.out.println("myFile2: ");
        org1.display("myFile2");
        System.out.println();
        System.out.println("After merge");
        System.out.println();
        org1.mergeFiles("myFile", "myFile2", "myFileMerge");
        org1.display("myFileMerge");

    }
}

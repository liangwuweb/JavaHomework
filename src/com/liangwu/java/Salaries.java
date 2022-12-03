package com.liangwu.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.text.DecimalFormat;


public class Salaries implements Raiseable{
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void create(String fileName) {
        File myFile = new File(fileName);
        try {
            myFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Cannot create file");
        }
    }

    @Override
    public void display(String fileName) {
        try (Scanner fileIn = new Scanner(Paths.get((fileName)))) {
            while(fileIn.hasNextLine()) {
                System.out.println(fileIn.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Cannot read file");
        }
    }

    public boolean addTo(String inFileName, String outFileName, int id, double salary, int yearsOfService) {
        String line;

        boolean noMatch = false;
        try (Scanner fileIn = new Scanner(Paths.get(inFileName));
             //Scanner fileIn2 = new Scanner(Paths.get(inFileName));
             PrintWriter fileOut = new PrintWriter(outFileName);)
        {
            while (fileIn.hasNextLine())  // while the input file is not empty
            {
                line = fileIn.nextLine().trim();
                String[] entry = line.split(":");
                int entryId = Integer.parseInt(entry[0]);
                if (entryId == id) {
                    break;
                // if id is smaller than old entryId, we insert the new data before the entry
                } else if (entryId > id) {
                    fileOut.println(id + ":" + df.format(salary) + ":" + yearsOfService);
                    fileOut.println(line);
                    noMatch = true;
                    break;
                } else {
                    fileOut.println(line);
                    noMatch = true;
                }
            }

            // Is there is a match id, we just don't add the entry, just copy the file
            if (!noMatch) {
                while(fileIn.hasNextLine()) {
                    fileOut.println(fileIn.nextLine());
                }
            }

            // If no match id, we append the data in the file
            if (noMatch) {
                while(fileIn.hasNextLine()) {
                    fileOut.println(fileIn.nextLine());
                }
                fileOut.println(id + ":" + df.format(salary) + ":" + yearsOfService);
            }
        } catch (FileNotFoundException | InvalidPathException e) {
            System.out.println("Filename invalid or not found");
        }
        catch (IOException e) {
            System.out.println("File I/O error");
        }

        return noMatch;
    }

    public boolean removeFrom(String inFileName, String outFileName, int id) {
        String line;
        boolean match = false;

        try(Scanner fileIn = new Scanner(Paths.get(inFileName));
            PrintWriter fileOut = new PrintWriter(outFileName);)
        {
            while(fileIn.hasNextLine()) {
                line = fileIn.nextLine().trim();
                String[] entry = line.split(":");
                int entryId = Integer.parseInt(entry[0]);
                if (entryId == id) {
                    fileOut.print(""); // if match, we just don't copy the entry
                    match = true;
                } else {
                    fileOut.println(line);
                }
            }

        } catch (FileNotFoundException | InvalidPathException e) {
            System.out.println("Filename invalid or not found");
        }
        catch (IOException e) {
            System.out.println("File I/O error");
        }

        return match;
    }

    public void addService(String inFileName, String outFileName) {
        String line;

        try(Scanner fileIn = new Scanner(Paths.get(inFileName));
            PrintWriter fileOut = new PrintWriter(outFileName);)
        {
            while(fileIn.hasNextLine()) {
                line = fileIn.nextLine().trim();
                String[] entry = line.split(":");
                int newEntryYear = Integer.parseInt(entry[2]) + 1;
                int entryId = Integer.parseInt(entry[0]);
                double entrySalary = Double.parseDouble(entry[1]);
                fileOut.println(entryId + ":" + df.format(entrySalary) + ":" + newEntryYear);
            }
        } catch (FileNotFoundException | InvalidPathException e) {
            System.out.println("Filename invalid or not found");
        }
        catch (IOException e) {
            System.out.println("File I/O error");
        }
    }

    public int raise(String inFileName, String outFileName, int yearsOfService, double salaryIncPercent) {
        String line;
        int raised = 0;

        try(Scanner fileIn = new Scanner(Paths.get(inFileName));
            PrintWriter fileOut = new PrintWriter(outFileName);)
        {
            while(fileIn.hasNextLine()) {
                line = fileIn.nextLine().trim();
                String[] entry = line.split(":");
                int entryId = Integer.parseInt(entry[0]);
                int entryYear = Integer.parseInt(entry[2]);
                double entrySalary = Double.parseDouble(entry[1]);
                double raisedSalary;

                if (entryYear >= yearsOfService) {
                    raisedSalary = entrySalary * (1 + salaryIncPercent);
                    ++raised;
                   line = entryId + ":" + df.format(raisedSalary) + ":" + entryYear;
                }
                fileOut.println(line);
            }

        } catch (FileNotFoundException | InvalidPathException e) {
            System.out.println("Filename invalid or not found");
        }
        catch (IOException e) {
            System.out.println("File I/O error");
        }
        return raised;
    }

}

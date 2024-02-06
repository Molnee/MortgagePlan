package com.example.mortgageplan;



import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the input file as a command line argument.");
            return;
        }

        String filePath = args[0];

        try {
            List<Customer> customers = CustomerFileReader.readCustomersFromFile(filePath);
            MortgageResultPrinter.printMortgageResults(customers);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the input file: " + e.getMessage());
        }
    }
}
package com.example.mortgageplan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerFileReader {

    public static List<Customer> readCustomersFromFile(String filePath) throws IOException {
        List<Customer> customers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true; // Flag to track the first line

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the header line
                }

                String[] parts = line.split(",");
                if (parts.length < 4) {
                    continue; // Skip this line if it doesn't have the expected number of parts
                }

                String name = parts[0];
                try {
                    double totalLoan = Double.parseDouble(parts[1]);
                    double interest = Double.parseDouble(parts[2]);
                    int years = Integer.parseInt(parts[3]);

                    Customer customer = new Customer(name, totalLoan, interest, years);
                    customers.add(customer);
                } catch (NumberFormatException e) {
                    // Skip this line if any field cannot be parsed as the expected type
                    System.err.println("Skipping line due to NumberFormatException: " + line);
                }
            }
        }

        return customers;
    }
}
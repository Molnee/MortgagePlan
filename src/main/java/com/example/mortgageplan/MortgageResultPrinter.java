package com.example.mortgageplan;

import java.util.List;

public class MortgageResultPrinter {

    public static void printMortgageResults(List<Customer> customers) {
        for (Customer customer : customers) {
            double monthlyPayment = MortgageCalculator.calculateMonthlyPayment(
                    customer.getLoanAmount(),
                    customer.getYearlyInterestRate(),
                    customer.getLoanPeriodInYears()
            );

            System.out.println("****************************************************************************************************");
            System.out.printf("Prospect %s: %s wants to borrow %.2f € for a period of %d years and pay %.2f € each month%n",
                    customer.getName(), customer.getName(), customer.getLoanAmount(), customer.getLoanPeriodInYears(), monthlyPayment);
            System.out.println("****************************************************************************************************");
        }
    }
}
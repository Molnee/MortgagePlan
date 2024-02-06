package com.example.mortgageplan;

public class MortgageCalculator {
    public static double calculateMonthlyPayment(double loanAmount, double yearlyInterestRate, int loanPeriodInYears) {
        if (yearlyInterestRate == 0) {
            return loanAmount / (loanPeriodInYears * 12); // Monthly payment is simply the loan amount divided by the number of months
        }

        double monthlyInterestRate = yearlyInterestRate / 12 / 100;
        int numberOfPayments = loanPeriodInYears * 12;

        double base = 1 + monthlyInterestRate;
        double result = 1;
        for (int i = 0; i < numberOfPayments; i++) {
            result *= base;
        }

        double numerator = loanAmount * monthlyInterestRate * result;
        double denominator = result - 1;

        return numerator / denominator;
    }

}


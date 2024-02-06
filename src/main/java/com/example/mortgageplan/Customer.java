package com.example.mortgageplan;

public class Customer {
    private final String name;
    private final double loanAmount;
    private final double yearlyInterestRate;
    private final int loanPeriodInYears;

    public Customer(String name, double loanAmount, double yearlyInterestRate, int loanPeriodInYears) {
        this.name = name;
        this.loanAmount = loanAmount;
        this.yearlyInterestRate = yearlyInterestRate;
        this.loanPeriodInYears = loanPeriodInYears;
    }

    public String getName() {
        return name;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getYearlyInterestRate() {
        return yearlyInterestRate;
    }

    public int getLoanPeriodInYears() {
        return loanPeriodInYears;
    }
}

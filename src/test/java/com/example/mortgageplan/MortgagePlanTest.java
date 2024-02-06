package com.example.mortgageplan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MortgagePlanTest {

    @Test
    public void testCustomerFileReader() throws IOException {
        List<Customer> customers = CustomerFileReader.readCustomersFromFile("C:/Users/jonat/Desktop/Crosskey/prospects.txt");
        assertEquals(4, customers.size());

        Customer firstCustomer = customers.get(0);
        assertEquals("Juha", firstCustomer.getName());
        assertEquals(1000, firstCustomer.getLoanAmount());
        assertEquals(5.0, firstCustomer.getYearlyInterestRate());
        assertEquals(2, firstCustomer.getLoanPeriodInYears());

        Customer secondCustomer = customers.get(1);
        assertEquals("Karvinen", secondCustomer.getName());
        assertEquals(4356, secondCustomer.getLoanAmount());
        assertEquals(1.27, secondCustomer.getYearlyInterestRate());
        assertEquals(6, secondCustomer.getLoanPeriodInYears());

        Customer thirdCustomer = customers.get(2);
        assertEquals("Claes Månsson", thirdCustomer.getName());
        assertEquals(1300.55, thirdCustomer.getLoanAmount());
        assertEquals(8.67, thirdCustomer.getYearlyInterestRate());
        assertEquals(2, thirdCustomer.getLoanPeriodInYears());

        Customer forthCustomer = customers.get(3);
        assertEquals("Clarencé Andersson", forthCustomer.getName());
        assertEquals(2000, forthCustomer.getLoanAmount());
        assertEquals(6, forthCustomer.getYearlyInterestRate());
        assertEquals(4, forthCustomer.getLoanPeriodInYears());
    }

    @Test
    public void testMortgageCalculator() {
        double monthlyPayment = MortgageCalculator.calculateMonthlyPayment(100000.0, 5.0, 10);
        assertEquals(1060.66, monthlyPayment, 0.01);

        monthlyPayment = MortgageCalculator.calculateMonthlyPayment(150000.0, 4.5, 15);
        assertEquals(1147.48, monthlyPayment, 0.01);
    }
    @Test
    public void testMortgageCalculatorForZeroInterestRate() {
        double monthlyPayment = MortgageCalculator.calculateMonthlyPayment(100000.0, 0.0, 10);
        assertEquals(833.33, monthlyPayment, 0.01); // Assuming a certain level of precision for zero interest rate

        monthlyPayment = MortgageCalculator.calculateMonthlyPayment(150000.0, 0.0, 15);
        assertEquals(833.33, monthlyPayment, 0.01); // Assuming a certain level of precision for zero interest rate
    }


}

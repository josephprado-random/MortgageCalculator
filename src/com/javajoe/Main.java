package com.javajoe;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Mortgage Calculator");

        double principal = readInput ("Loan Amount", 0);
        float annualRate = (float) readInput("Annual Interest Rate (APR)", 0);
        float termYears = (float) readInput("Term (years)", 1);

        double monthlyPayment = getMonthlyPayment(principal, annualRate, termYears);

        NumberFormat paymentFormatted = NumberFormat.getCurrencyInstance();
        String paymentString = paymentFormatted.format(monthlyPayment);
        System.out.println("Monthly Payment: " + paymentString);
    }

    public static double readInput (String prompt, double min) {

        Scanner scanner = new Scanner(System.in);
        double value;

        //prompts user for input and stores as value
        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();
            if (value >= min)
                break;
            System.out.println("Value must be >= " + (int)min + "!");
        }
        return value;
    }

    public static double getMonthlyPayment(double principal, float annualRate, float termYears) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        float monthlyRate = annualRate / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = termYears * MONTHS_IN_YEAR;

        //calculates monthly payment using PV of annuity formula
        if (monthlyRate == 0)
            return principal / numberOfPayments;
        return
                principal
                * monthlyRate
                * Math.pow((1 + monthlyRate), numberOfPayments)
                / (Math.pow((1 + monthlyRate), numberOfPayments) - 1);
    }
}
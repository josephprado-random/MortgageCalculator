package com.javajoe;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        double principal;
        float annualRate;
        float termYears;

        System.out.println("Mortgage Calculator");
        Scanner scanner = new Scanner(System.in); //creates Scanner object scanner

        //prompts user for loan principal amount > 0
        while (true) {
            System.out.print("Loan Amount: ");
            principal = scanner.nextDouble();
            if (principal > 0)
                break;
            System.out.println("Amount must be greater than 0!");
        }

        //prompts user for APR >= 0
        while (true) {
            System.out.print("Annual Interest Rate (APR): ");
            annualRate = scanner.nextFloat();
            if (annualRate >= 0)
                break;
            System.out.println("Rate cannot be negative!");
        }

        //prompts user for loan term in years > 0
        while (true) {
            System.out.print("Term (years): ");
            termYears = scanner.nextFloat();
            if (termYears > 0)
                break;
            System.out.println("Term must be greater than 0!");
        }

        //calls calculateMortgage method and formats to currency
        double monthlyPayment = getMonthlyPayment(principal, annualRate, termYears);
        NumberFormat paymentFormatted = NumberFormat.getCurrencyInstance();
        String paymentString = paymentFormatted.format(monthlyPayment);
        System.out.println("Monthly Payment: " + paymentString);

    }

    public static double getMonthlyPayment(
            double principal,
            float annualRate,
            float termYears) {

        final byte MONTHS_IN_YEAR = 12; //sets months in year as constant
        final byte PERCENT = 100; //sets denominator for interest rate (PERCENT)

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
package com.javajoe;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        double principal = readInput ("Loan Amount", 0);
        float annualRate = (float) readInput("Annual Interest Rate (APR)", 0);
        float years = (float) readInput("Term (years)", 1);

        printMortgage(principal, annualRate, years);
        printPaymentSchedule(principal, annualRate, years);
    }

    private static void printMortgage(double principal, float annualRate, float years) {
        double mortgage = calculateMortgage(principal, annualRate, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payment: " + mortgageFormatted);
    }

    private static void printPaymentSchedule(double principal, float annualRate, float years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 0; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualRate, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readInput (String prompt, double min) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();
            if (value >= min)
                break;
            System.out.println("Value must be >= " + (int)min + "!");
        } return value;
    }

    public static double calculateMortgage(double principal, float annualRate, float years) {
        float monthlyRate = annualRate / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        return
                principal
                * monthlyRate
                * Math.pow((1 + monthlyRate), numberOfPayments)
                / (Math.pow((1 + monthlyRate), numberOfPayments) - 1);
    }

    public static double calculateBalance(
            double principal,
            float annualRate,
            float years,
            short numberOfPaymentsMade) {
        float monthlyRate = annualRate / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = years * MONTHS_IN_YEAR;

        return
                principal
                * (Math.pow(1 + monthlyRate, numberOfPayments) - Math.pow(1 + monthlyRate, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
    }

}
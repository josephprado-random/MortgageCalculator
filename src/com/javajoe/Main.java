package com.javajoe;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static double mortgage;

    public static void main(String[] args) {
        double principal = Console.readInput("Loan Amount", 0);
        float annualRate = (float) Console.readInput("Annual Interest Rate (APR)", 0);
        float years = (float) Console.readInput("Term (years)", 1);

        MortgageReport.printMortgage(principal, annualRate, years);
        MortgageReport.printPaymentSchedule(principal, annualRate, years);
    }
}
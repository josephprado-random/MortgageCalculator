package com.javajoe;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        double principal = Console.readInput("Loan Amount", 0);
        float annualRate = (float) Console.readInput("Annual Interest Rate (APR)", 0);
        float years = (float) Console.readInput("Term (years)", 1);

        var calculator = new MortgageCalculator(principal, annualRate, years);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }
}
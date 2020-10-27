package com.javajoe;

import java.text.NumberFormat;

public class MortgageReport {
    public static void printMortgage(double principal, float annualRate, float years) {
        Main.mortgage = MortgageCalculator.calculateMortgage(principal, annualRate, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(Main.mortgage);
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payment: " + mortgageFormatted);
    }

    public static void printPaymentSchedule(double principal, float annualRate, float years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 0; month <= years * Main.MONTHS_IN_YEAR; month++) {
            double balance = MortgageCalculator.calculateBalance(principal, annualRate, years, month);
            System.out.println(month + "\t" + NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}

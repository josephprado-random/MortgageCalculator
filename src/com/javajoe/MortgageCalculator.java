package com.javajoe;

public class MortgageCalculator {

    public static double calculateMortgage(double principal, float annualRate, float years) {
        float monthlyRate = annualRate / Main.PERCENT / Main.MONTHS_IN_YEAR;
        float numberOfPayments = years * Main.MONTHS_IN_YEAR;

        if (annualRate == 0)
            return principal / numberOfPayments;
        else
            return principal
                    * monthlyRate
                    * Math.pow((1 + monthlyRate), numberOfPayments)
                    / (Math.pow((1 + monthlyRate), numberOfPayments) - 1);
    }

    public static double calculateBalance(double principal, float annualRate, float years, short numberOfPaymentsMade) {
        float monthlyRate = annualRate / Main.PERCENT / Main.MONTHS_IN_YEAR;
        float numberOfPayments = years * Main.MONTHS_IN_YEAR;

        if (annualRate == 0)
            return principal - (numberOfPaymentsMade * Main.mortgage);
        else
            return principal
                    * (Math.pow(1 + monthlyRate, numberOfPayments) - Math.pow(1 + monthlyRate, numberOfPaymentsMade))
                    / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
    }
}

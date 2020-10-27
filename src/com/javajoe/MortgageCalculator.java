package com.javajoe;

public class MortgageCalculator {
    private double principal;
    private float annualRate;
    private float years;
    private double mortgage;

    public MortgageCalculator(double principal, float annualRate, float years) {
        this.principal = principal;
        this.annualRate = annualRate;
        this.years = years;
    }

    public double calculateMortgage() {
        float monthlyRate = annualRate / Main.PERCENT / Main.MONTHS_IN_YEAR;
        float numberOfPayments = years * Main.MONTHS_IN_YEAR;

        if (annualRate == 0)
            mortgage = principal / numberOfPayments;
        else
            mortgage = principal
                    * monthlyRate
                    * Math.pow((1 + monthlyRate), numberOfPayments)
                    / (Math.pow((1 + monthlyRate), numberOfPayments) - 1);
        return mortgage;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyRate = annualRate / Main.PERCENT / Main.MONTHS_IN_YEAR;
        float numberOfPayments = years * Main.MONTHS_IN_YEAR;
        double balance;

        if (annualRate == 0)
            balance = principal - (numberOfPaymentsMade * mortgage);
        else
            balance = principal
                    * (Math.pow(1 + monthlyRate, numberOfPayments) - Math.pow(1 + monthlyRate, numberOfPaymentsMade))
                    / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
        return balance;
    }

    public float getYears() { return years; }
}

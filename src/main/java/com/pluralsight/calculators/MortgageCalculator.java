// Copyright (c) Benjamin Bergman 2024.

package com.pluralsight.calculators;

import java.io.*;

public class MortgageCalculator extends Calculator {
    public MortgageCalculator(InputStream in, PrintStream out) {
        super(in, out);
    }

    @Override
    public void run() {
        var principle = queryDouble("Loan amount (dollars): ");
        var rate = queryDouble("Interest rate (percent per year): ") * 0.01;
        var length = queryDouble("Loan length (years): ");

        var monthlyRate = rate / 12;
        var months = length * 12;

        // Amortized loan payment formula from here: https://www.investopedia.com/terms/a/amortization.asp
        var monthlyPayment = principle *
                             ((monthlyRate * Math.pow(1 + monthlyRate, months)) /
                              (Math.pow(1 + monthlyRate, months) - 1));
        var totalPayment = monthlyPayment * months;
        out.println();
        out.printf("""
                Expected monthly payment: $%.2f
                Expected total payment:   $%.2f
                """, monthlyPayment, totalPayment);
    }
}

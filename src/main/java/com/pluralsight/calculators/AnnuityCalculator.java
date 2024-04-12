// Copyright (c) Benjamin Bergman 2024.

package com.pluralsight.calculators;

import java.io.*;

public class AnnuityCalculator extends Calculator {
    public AnnuityCalculator(InputStream in, PrintStream out) {
        super(in, out);
    }

    @Override
    public void run() {
        var monthlyPayout = queryDouble("Monthly payout (dollars): ");
        var rate = queryDouble("Interest rate (percent per year, compounded daily): ") * 0.01;
        var length = queryDouble("Length (years): ");

        var monthlyRate = rate / 12;
        var payments = length * 12;

        var presentValue = monthlyPayout * (1 - Math.pow(1 + monthlyRate, -payments)) / monthlyRate;

        out.printf("%nThe present value of this annuity is $%.2f%n", presentValue);
    }
}

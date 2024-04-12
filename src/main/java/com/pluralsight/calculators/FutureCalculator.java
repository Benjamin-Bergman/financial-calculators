// Copyright (c) Benjamin Bergman 2024.

package com.pluralsight.calculators;

import java.io.*;

public class FutureCalculator extends Calculator {
    public FutureCalculator(InputStream in, PrintStream out) {
        super(in, out);
    }

    @Override
    public void run() {
        var deposit = queryDouble("Deposit value (dollars): ");
        var rate = queryDouble("Interest rate (percent per year, compounded daily): ") * 0.01;
        var length = queryDouble("Length (years): ");

        // Compound interest formula is A=P(1+r/n)^nt
        var numCompounds = length * 365; // Compounded daily
        var compoundRate = rate / 365;

        var total = deposit * Math.pow(1 + compoundRate, numCompounds);
        var gain = total - deposit;

        out.println();
        out.printf("""
                Total value at end of period: $%.2f
                Total interest gained:        $%.2f
                """, total, gain);
    }
}

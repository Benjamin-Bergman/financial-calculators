// Copyright (c) Benjamin Bergman 2024.

package com.pluralsight;

import com.pluralsight.calculators.*;

public class Program {
    public static void main(String[] args) {
        // TODO: Determine which calculator to use
        Calculator c = new MortgageCalculator(System.in, System.out);

        c.run();
    }
}

// Copyright (c) Benjamin Bergman 2024.

package com.pluralsight.calculators;

import java.io.*;
import java.util.*;

public abstract class Calculator {
    protected final PrintStream out;
    private final Scanner scanner;

    public Calculator(InputStream in, PrintStream out) {
        this.out = out;
        scanner = new Scanner(in);
        scanner.useDelimiter("\n");
    }

    protected double queryDouble(String message) {
        out.print(message);
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                out.printf("Bad input: %s%nPlease try again.%n", scanner.next());
                out.print(message);
            }
        }
    }

    public abstract void run();
}

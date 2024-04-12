// Copyright (c) Benjamin Bergman 2024.

package com.pluralsight;

import com.pluralsight.calculators.*;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        boolean showHelp = true;
        while (true) {
            if (showHelp)
                System.out.println("""
                        Choose a calculator to run:
                          1: Mortgage Payments
                          2: Future Value
                          3: Annuity Value
                        or type "help" for more help.
                        Type "exit" to quit.""");

            showHelp = true;
            var input = scanner.next().trim();

            Calculator calculator;

            var num = tryParseInt(input);
            if (num.isPresent()) {
                switch (num.get()) {
                    case 1:
                        calculator = new MortgageCalculator(System.in, System.out);
                        break;
                    case 2:
                        calculator = new FutureCalculator(System.in, System.out);
                        break;
                    case 3:
                        calculator = new AnnuityCalculator(System.in, System.out);
                        break;
                    default:
                        System.out.printf("Bad number %d. Please try again.%n", num.get());
                        continue;
                }
            } else {
                if (input.equalsIgnoreCase("help")) {
                    System.out.println("""
                            Mortgage Payments: Calculates the monthly payment for a mortgage.
                            Future Value:      Calculates the compound interest of a savings account.
                            Annuity Value:     Calculates the present value of an annuity.""");
                    showHelp = false;
                } else if (input.equalsIgnoreCase("exit")) break;
                else System.out.printf("Unknown command %s. Please try again.%n", input);
                continue;
            }

            calculator.run();
            System.out.println();
        }

        System.out.println("Goodbye");
    }

    private static Optional<Integer> tryParseInt(String input) {
        try {
            return Optional.of(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}

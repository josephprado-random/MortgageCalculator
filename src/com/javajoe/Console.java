package com.javajoe;

import java.util.Scanner;

public class Console {
    public static double readInput(String prompt, double min) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();
            if (value >= min)
                break;
            System.out.println("Value must be >= " + (int)min + "!");
        } return value;
    }
}

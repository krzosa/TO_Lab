package com.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ICalculator calculator = new Calculator();

        while (scanner.hasNextLine()) {
            calculator.readInput(scanner.nextLine());
            System.out.println(calculator.calc());
        }
    }
}

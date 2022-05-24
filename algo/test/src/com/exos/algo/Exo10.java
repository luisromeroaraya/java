package com.exos.algo;

import java.util.Scanner;

public class Exo10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Calculator 2000");
        // Asks for first number
        System.out.print("Please enter your first number: ");
        int first = Integer.parseInt(input.nextLine());
        // Asks for operator
        System.out.print("Please enter an operator sign (+, -, /, *): ");
        String operator = input.nextLine().toLowerCase();
        // If the operator is not valid it asks for it again
        while (!operator.equals("+") && !operator.equals("-") && !operator.equals("/") && !operator.equals("*")) {
            System.out.print("This is not a valid operator. Please enter another (+, -, /, *): ");
            operator = input.nextLine().toLowerCase();
        }
        // Asks for second number
        System.out.print("Please enter your second number: ");
        int second = Integer.parseInt(input.nextLine());
        // If the operator is / and the number is 0 then it asks for another number
        while (operator.equals("/") && second == 0) {
            System.out.print("We can't divide by 0. Please enter another number: ");
            second = Integer.parseInt(input.nextLine());
        }
        // Initializes variable result as a float to accept decimals
        float result = 0;
        // Executes the calculation
        switch (operator) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "/":
                result = (float) first / second; // we transform the first variable into a float to allow a real division
                break;
            case "*":
                result = first * second;
                break;
        }
        // Shows the result
        System.out.printf("%s %s %s = %s", first, operator, second, result);
    }
}

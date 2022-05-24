package com.exos.algo;

import java.util.Scanner;

public class Exo18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Calculator 2000");
        boolean again = false;
        do {
            System.out.println("The Calculator 2000 allows you to make any simple operation between two numbers.");
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
            System.out.println("");
            System.out.println("Do you want to make a new calculation (Yes/No)?");
            String answer  = input.nextLine().toLowerCase();
            if (answer.equals("yes")) {
                again = true;
            }
            else {
                again = false;
            }
        } while (again);
    }
}


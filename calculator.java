import java.util.InputMismatchException;
import java.util.Scanner;

public class calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Simple Calculator!");
        boolean continueCalc = true;

        while (continueCalc) {
            double num1 = getDoubleInput(scanner, "Enter the first number: ");
            double num2 = getDoubleInput(scanner, "Enter the second number: ");

            char operator = getOperator(scanner);

            double result;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    System.out.printf("Result: %.4f + %.4f = %.4f%n", num1, num2, result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.printf("Result: %.4f - %.4f = %.4f%n", num1, num2, result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.printf("Result: %.4f * %.4f = %.4f%n", num1, num2, result);
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is undefined.");
                    } else {
                        result = num1 / num2;
                        System.out.printf("Result: %.4f / %.4f = %.4f%n", num1, num2, result);
                    }
                    break;
                default:
                    // We won't reach here because getOperator ensures valid input.
                    System.out.println("Unknown error occurred.");
            }

            continueCalc = askContinue(scanner);
            System.out.println(); // Blank line before next iteration
        }

        System.out.println("Thank you for using the calculator. Goodbye!");
        scanner.close();
    }

    // Method to safely get a double input from user
    private static double getDoubleInput(Scanner scanner, String prompt) {
        double num;
        while (true) {
            System.out.print(prompt);
            try {
                num = scanner.nextDouble();
                // Clear newline character after the number input
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        return num;
    }

    // Method to get valid operator from user
    private static char getOperator(Scanner scanner) {
        while (true) {
            System.out.print("Select operation (+, -, *, /): ");
            String input = scanner.nextLine().trim();
            if (input.length() == 1) {
                char op = input.charAt(0);
                if (op == '+' || op == '-' || op == '*' || op == '/') {
                    return op;
                }
            }
            System.out.println("Invalid operator! Please enter +, -, *, or /.");
        }
    }

    // Ask user if they want to continue
    private static boolean askContinue(Scanner scanner) {
        while (true) {
            System.out.print("Do you want to perform another calculation? (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            }
            System.out.println("Please enter 'y' or 'n'.");
        }
    }
}

package Session14.exercise04;

import java.util.Scanner;

/**
 * Simple console input helper with validation for integers and decimal amounts.
 */
public class InputData {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            if (line == null || line.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
                continue;
            }
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid integer. Please enter a valid number.");
            }
        }
    }

    public static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            if (line == null || line.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
                continue;
            }
            try {
                return Double.parseDouble(line.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number format. Please enter a valid decimal value.");
            }
        }
    }
}

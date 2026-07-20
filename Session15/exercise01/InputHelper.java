package Session15.exercise01;

import java.util.Scanner;

/**
 * Helper class for reading and validating console input.
 */
public class InputHelper {
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
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer. Please enter a valid number.");
            }
        }
    }

    public static float readFloat(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            if (line == null || line.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
                continue;
            }
            try {
                float value = Float.parseFloat(line.trim());
                if (value <= 0) {
                    System.out.println("Price must be greater than 0.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid decimal number.");
            }
        }
    }

    public static String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            if (line == null || line.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
                continue;
            }
            return line.trim();
        }
    }
}

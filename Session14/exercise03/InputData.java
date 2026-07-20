package Session14.exercise03;

import java.util.Scanner;

/**
 * Utility class for reading user input from console with basic validation.
 * Currently used to obtain an integer representing the age threshold for deletion.
 */
public class InputData {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Prompt the user to enter an integer (e.g., age limit). Re‑prompts on invalid input.
     * @param prompt Message displayed to the user.
     * @return Valid integer entered by the user.
     */
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
                System.out.println("Invalid number format. Please enter a valid integer.");
            }
        }
    }
}

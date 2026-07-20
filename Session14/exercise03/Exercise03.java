package Session14.exercise03;

import java.util.Scanner;

/**
 * Driver class for Exercise 03 – Delete students by age with transaction support.
 * It prompts the user for an age threshold and invokes {@link StudentManager#deleteStudentsByAge(int)}.
 */
public class Exercise03 {
    public static void main(String[] args) {
        System.out.println("=== Delete Students By Age (Exercise 03) ===");
        int ageLimit = InputData.readInt("Enter age limit (students younger than this will be deleted): ");
        StudentManager manager = new StudentManager();
        manager.deleteStudentsByAge(ageLimit);
    }
}

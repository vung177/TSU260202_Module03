package Session14.exercise02;

import java.util.Scanner;

public class InputData {
    // Nhập chuỗi không cho rỗng
    public static String getString(Scanner scanner, String prompt) {
        String input = "";
        do {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Vui lòng không để trống!");
            }
        } while (input.trim().isEmpty());
        return input;
    }

    // Nhập số nguyên dương, bắt lỗi định dạng
    public static int getInt(Scanner scanner, String prompt) {
        String line = "";
        do {
            System.out.print(prompt);
            line = scanner.nextLine().trim();
            try {
                if (line.isEmpty()) {
                    System.out.println("Vui lòng không để trống!");
                } else {
                    int val = Integer.parseInt(line);
                    if (val <= 0) {
                        System.out.println("Giá trị phải là số nguyên dương > 0!");
                    } else {
                        return val;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên.");
            }
        } while (true);
    }
}

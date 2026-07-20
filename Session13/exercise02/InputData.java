package Session13.exercise02;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputData {
    // Nhập chuỗi chặn trống
    public static String getString(Scanner scanner, String suggest) {
        String input = "";
        do {
            System.out.print(suggest);
            input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Vui lòng không để trống!");
            }
        } while (input.trim().isEmpty());
        return input;
    }

    // Nhập email chặn trống và đúng định dạng
    public static String getEmail(Scanner scanner, String suggest) {
        String email = "";
        String emailRegex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        do {
            System.out.print(suggest);
            email = scanner.nextLine().trim();
            try {
                if (email.isEmpty()) {
                    System.out.println("Vui lòng không bỏ trống email!");
                } else if (!email.matches(emailRegex)) {
                    throw new IllegalArgumentException("Định dạng email không hợp lệ (ví dụ: abc@xyz.com).");
                } else {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        } while (true);
        return email;
    }

    // Nhập ngày theo định dạng dd/MM/yyyy, bắt lỗi try-catch
    public static LocalDate getLocalDate(Scanner scanner, String suggest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do {
            System.out.print(suggest);
            String input = scanner.nextLine().trim();
            try {
                if (input.isEmpty()) {
                    System.out.println("Vui lòng không bỏ trống ngày sinh!");
                    continue;
                }
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi: Định dạng ngày không hợp lệ (yêu cầu định dạng dd/MM/yyyy, ví dụ: 20/07/2026).");
            }
        } while (true);
    }
}

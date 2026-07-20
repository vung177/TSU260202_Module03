package Session13.exercise04;

import java.util.Scanner;
import java.time.LocalDate;

public class InputData {
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

    public static int getInt(Scanner scanner, String suggest) {
        String rs = "";
        do {
            System.out.print(suggest);
            rs = scanner.nextLine().trim();
            try {
                if (rs.isEmpty()) {
                    System.out.println("Vui lòng không bỏ trống!");
                } else {
                    int val = Integer.parseInt(rs);
                    if (val <= 0) {
                        System.out.println("Mã ID phải là số nguyên dương lớn hơn 0!");
                    } else {
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Mã ID phải là một số nguyên.");
            }
        } while (true);
        return Integer.parseInt(rs);
    }

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

    public static LocalDate getLocalDate(Scanner scanner, String suggest) {
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do {
            System.out.print(suggest);
            String input = scanner.nextLine().trim();
            try {
                if (input.isEmpty()) {
                    System.out.println("Vui lòng không bỏ trống ngày sinh!");
                    continue;
                }
                return LocalDate.parse(input, formatter);
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Lỗi: Định dạng ngày không hợp lệ (yêu cầu dd/MM/yyyy, ví dụ: 20/07/2026).");
            }
        } while (true);
    }
}

package Session11.exercise03;

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

    // Nhập ngày, bắt lỗi định dạng DateTimeParseException, bọc try-catch
    public static LocalDate getLocalDate(Scanner scanner, String suggest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        do {
            System.out.print(suggest);
            String input = scanner.nextLine().trim();
            try {
                if (input.isEmpty()) {
                    System.out.println("Vui lòng không bỏ trống ngày!");
                    continue;
                }
                // Thử chuyển chuỗi thành ngày theo định dạng dd/MM/yyyy
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi: Định dạng ngày không hợp lệ (yêu cầu định dạng dd/MM/yyyy, ví dụ: 20/07/2026).");
            }
        } while (true);
    }
}

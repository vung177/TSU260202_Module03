package Session10.exercise03;

import java.util.Scanner;

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

    // Nhập email, kiểm tra định dạng regex, bọc try-catch
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

    // Nhập số điện thoại, kiểm tra định dạng regex (9-11 số), bọc try-catch
    public static String getPhoneNumber(Scanner scanner, String suggest) {
        String phone = "";
        String phoneRegex = "^[0-9]{9,11}$";
        do {
            System.out.print(suggest);
            phone = scanner.nextLine().trim();
            try {
                if (phone.isEmpty()) {
                    System.out.println("Vui lòng không bỏ trống số điện thoại!");
                } else if (!phone.matches(phoneRegex)) {
                    throw new IllegalArgumentException("Số điện thoại không hợp lệ (chỉ chứa các chữ số, từ 9 đến 11 số).");
                } else {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        } while (true);
        return phone;
    }
}

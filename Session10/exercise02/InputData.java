package Session10.exercise02;

import java.util.Scanner;
import java.util.Calendar;

public class InputData {
    // Nhập chuỗi ký tự, chặn trống
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

    // Nhập năm xuất bản, chặn trống, chặn số âm hoặc năm không thực tế tương lai
    public static int getInt(Scanner scanner, String suggest) {
        String rs = "";
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        do {
            System.out.print(suggest);
            rs = scanner.nextLine().trim();
            try {
                if (rs.isEmpty()) {
                    System.out.println("Vui lòng không bỏ trống!");
                } else {
                    int val = Integer.parseInt(rs);
                    if (val <= 0 || val > currentYear + 5) {
                        System.out.println("Năm xuất bản không hợp lệ (phải > 0 và <= " + (currentYear + 5) + ").");
                    } else {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Năm xuất bản phải là số nguyên.");
            }
        } while (true);
        return Integer.parseInt(rs);
    }
}

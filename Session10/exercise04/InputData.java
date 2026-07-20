package Session10.exercise04;

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

    // Nhập vị trí index hợp lệ, bọc try-catch
    public static int getIndex(Scanner scanner, String suggest, int maxIndex) {
        String rs = "";
        do {
            System.out.print(suggest);
            rs = scanner.nextLine().trim();
            try {
                if (rs.isEmpty()) {
                    System.out.println("Vui lòng không bỏ trống vị trí!");
                } else {
                    int val = Integer.parseInt(rs);
                    if (val < 0 || val > maxIndex) {
                        throw new IndexOutOfBoundsException("Vị trí phải nằm trong khoảng từ 0 đến " + maxIndex + ".");
                    }
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vị trí phải là một số nguyên.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        } while (true);
        return Integer.parseInt(rs);
    }
}

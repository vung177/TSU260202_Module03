package Session11.exercise04;

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

    // Nhập số nguyên (ID), bọc try-catch
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
                    if (val < 0) {
                        System.out.println("Vui lòng nhập số nguyên >= 0!");
                    } else {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Mã sản phẩm phải là một số nguyên dương.");
            }
        } while (true);
        return Integer.parseInt(rs);
    }

    // Nhập số thực (Giá), bọc try-catch
    public static double getDouble(Scanner scanner, String suggest) {
        String rs = "";
        do {
            System.out.print(suggest);
            rs = scanner.nextLine().trim();
            try {
                if (rs.isEmpty()) {
                    System.out.println("Vui lòng không bỏ trống!");
                } else {
                    double val = Double.parseDouble(rs.replace(",", "."));
                    if (val < 0) {
                        System.out.println("Giá sản phẩm phải là số thực >= 0!");
                    } else {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Giá sản phẩm phải là một số thực.");
            }
        } while (true);
        return Double.parseDouble(rs.replace(",", "."));
    }
}

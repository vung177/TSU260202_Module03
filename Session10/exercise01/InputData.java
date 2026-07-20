package Session10.exercise01;

import java.util.Scanner;

public class InputData {
    public static String getString(Scanner scanner, String suggest) {
        String input = "";
        do {
            System.out.print(suggest);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Vui lòng không để trống!");
            }
        } while (input.isEmpty());
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
                    if (val < 0) {
                        System.out.println("Vui lòng nhập số nguyên >= 0!");
                    } else {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số nguyên >= 0!");
            }
        } while (true);
        return Integer.parseInt(rs);
    }

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
                    if (val < 0 || val > 10) {
                        System.out.println("Vui lòng nhập số thực trong khoảng từ 0 đến 10!");
                    } else {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số thực >= 0!");
            }
        } while (true);
        return Double.parseDouble(rs.replace(",", "."));
    }
}

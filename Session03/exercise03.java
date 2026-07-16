package Session03;

import java.util.Scanner;
import java.util.Locale;

public class exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        double totalSalary = 0;
        double maxSalary = -1;
        double minSalary = Double.MAX_VALUE;
        double totalBonus = 0;

        while (true) {
            System.out.println("========== MENU ==========");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng tiền thưởng nhân viên");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Lựa chọn không hợp lệ.");
                scanner.next();
                continue;
            }
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("--- Nhập lương nhân viên (nhập -1 để kết thúc) ---");
                    while (true) {
                        System.out.print("Nhập lương: ");
                        double salary;
                        String input = scanner.next().replace(".", "").replace(",", "").trim();
                        try {
                            salary = Double.parseDouble(input);
                        } catch (NumberFormatException e) {
                            System.out.println("Lương không hợp lệ. Nhập lại.");
                            continue;
                        }

                        if (salary == -1) {
                            break;
                        }

                        if (salary < 0 || salary > 500000000) {
                            System.out.println("Lương không hợp lệ. Nhập lại.");
                            continue;
                        }

                        // Phân loại lương
                        String type = "";
                        double bonusRate = 0;
                        if (salary < 5000000) {
                            type = "Thấp";
                            bonusRate = 0.05;
                        } else if (salary < 15000000) {
                            type = "Trung bình";
                            bonusRate = 0.10;
                        } else if (salary < 50000000) {
                            type = "Khá";
                            bonusRate = 0.15;
                        } else {
                            type = "Cao";
                            if (salary < 100000000) {
                                bonusRate = 0.20;
                            } else {
                                bonusRate = 0.25;
                            }
                        }

                        System.out.println("-> Phân loại: " + type);

                        // Cập nhật thống kê
                        count++;
                        totalSalary += salary;
                        if (salary > maxSalary) {
                            maxSalary = salary;
                        }
                        if (salary < minSalary) {
                            minSalary = salary;
                        }
                        totalBonus += salary * bonusRate;
                    }
                    break;
                case 2:
                    System.out.println("--- Thống kê ---");
                    if (count == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        double average = totalSalary / count;
                        System.out.println("Số nhân viên: " + count);
                        System.out.printf(Locale.US, "Tổng lương: %11s VND%n", formatCurrency(totalSalary));
                        System.out.printf(Locale.US, "Lương trung bình: %11s VND%n", formatCurrency(average));
                        System.out.printf(Locale.US, "Lương cao nhất: %11s VND%n", formatCurrency(maxSalary));
                        System.out.printf(Locale.US, "Lương thấp nhất: %11s VND%n", formatCurrency(minSalary));
                    }
                    break;
                case 3:
                    System.out.println("--- Tính tổng số tiền thưởng nhân viên ---");
                    System.out.printf(Locale.US, "Tổng tiền thưởng nhân viên: %s VND%n", formatCurrency(totalBonus));
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }
    }

    public static String formatCurrency(double amount) {
        return String.format(Locale.US, "%,.0f", amount);
    }
}

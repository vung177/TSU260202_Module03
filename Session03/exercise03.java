package Session03;

import java.util.Scanner;
import java.util.Locale;

public class exercise03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int salary;
        int count = 0;
        double totalBonus = 0;
        int totalSalary = 0;
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;

        while (true) {
            System.out.println("""
                    ***************MENU NHẬP LƯƠNG***************
                    1.  	Nhập lương nhân viên
                    2.  	Hiển thị thống kê
                    3.  	Tính tổng số tiền thưởng cho nhân viên
                    4.  	Thoát
                    Lựa chọn của bạn:
                    """);

            byte choice;
            try {
                choice = Byte.parseByte(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Lựa chọn phải là số từ 1 đến 4.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    do {
                        System.out.println("Nhập lương của nhân viên (nhập -1 để dừng): ");
                        try {
                            salary = Integer.parseInt(sc.nextLine().replace(".", "").replace(",", "").trim());
                        } catch (NumberFormatException e) {
                            System.out.println("Lương không hợp lệ. Vui lòng nhập số.");
                            continue;
                        }

                        if (salary == -1) {
                            break;
                        }

                        if (salary < 0 || salary > 500_000_000) {
                            System.out.println("Lương không hợp lệ: từ 0 - 500 triệu");
                        } else {
                            if (minSalary > salary) {
                                minSalary = salary;
                            }

                            if (maxSalary < salary) {
                                maxSalary = salary;
                            }

                            String type;
                            double bonusRate;
                            if (salary < 5_000_000) {
                                type = "Thu nhập thấp";
                                bonusRate = 0.05;
                            } else if (salary < 15_000_000) {
                                type = "Thu nhập trung bình";
                                bonusRate = 0.10;
                            } else if (salary < 50_000_000) {
                                type = "Thu nhập khá";
                                bonusRate = 0.15;
                            } else {
                                type = "Thu nhập cao";
                                if (salary < 100000000) {
                                    bonusRate = 0.20;
                                } else {
                                    bonusRate = 0.25;
                                }
                            }

                            // Cập nhật thống kê (chỉ chạy một lần duy nhất tại đây)
                            count++;
                            totalSalary += salary;
                            totalBonus += salary * bonusRate;
                            System.out.printf(Locale.US, "Tiền lương: %,d VND - Xếp loại: %s \n", salary, type);
                        }
                    } while (true);
                    System.out.println("Bạn đã nhập lương thành công!");
                    break;
                case 2:
                    System.out.println("--- Thống kê ---");
                    if (count > 0) {
                        double average = (double) totalSalary / count;
                        System.out.printf("Số nhân viên đã nhập: %d\n", count);
                        System.out.printf(Locale.US, "Tổng lương đã nhập: %,d VND\n", totalSalary);
                        System.out.printf(Locale.US, "Lương trung bình: %,.0f VND\n", average);
                        System.out.printf(Locale.US, "Lương lớn nhất: %,d VND\n", maxSalary);
                        System.out.printf(Locale.US, "Lương nhỏ nhất: %,d VND\n", minSalary);
                    } else {
                        System.out.println("Chưa có dữ liệu");
                    }
                    break;
                case 3:
                    System.out.println("--- Tính tổng số tiền thưởng nhân viên ---");
                    System.out.printf(Locale.US, "Tổng tiền thưởng nhân viên: %,.0f VND \n", totalBonus);
                    break;
                case 4:
                    System.out.println("Thoát chương trình \n");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không chính xác \n");
            }
            if (choice == 4) {
                break;
            }
        }
    }
}
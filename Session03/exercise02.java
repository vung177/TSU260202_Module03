package Session03;

import java.util.Scanner;
import java.util.Locale;

public class exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        double sum = 0;
        double max = -1;
        double min = 11;

        while (true) {
            System.out.println("====== MENU ======");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Lựa chọn không hợp lệ.");
                scanner.next();
                continue;
            }
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("--- Nhập điểm học viên (nhập -1 để dừng) ---");
                    while (true) {
                        System.out.print("Nhập điểm: ");
                        double score;
                        String input = scanner.next().replace(",", ".").trim();
                        try {
                            score = Double.parseDouble(input);
                        } catch (NumberFormatException e) {
                            System.out.print("Nhập điểm: Điểm không hợp lệ. Nhập lại.\n");
                            continue;
                        }

                        if (score == -1) {
                            break;
                        }

                        while (score < 0 || score > 10) {
                            System.out.print("Nhập điểm: Điểm không hợp lệ. Nhập lại.\n");
                            input = scanner.next().replace(",", ".").trim();
                            try {
                                score = Double.parseDouble(input);
                            } catch (NumberFormatException e) {
                                score = -2;
                            }
                            if (score == -1) {
                                break;
                            }
                        }

                        if (score == -1) {
                            break;
                        }

                        // Cập nhật thống kê
                        count++;
                        sum += score;
                        if (count == 1) {
                            max = score;
                            min = score;
                        } else {
                            if (score > max) max = score;
                            if (score < min) min = score;
                        }

                        // Xếp loại học lực
                        String classification = "";
                        if (score >= 0 && score < 5) {
                            classification = "Yếu";
                        } else if (score >= 5 && score < 7) {
                            classification = "Trung bình";
                        } else if (score >= 7 && score < 8) {
                            classification = "Khá";
                        } else if (score >= 8 && score < 9) {
                            classification = "Giỏi";
                        } else if (score >= 9 && score <= 10) {
                            classification = "Xuất sắc";
                        }

                        System.out.println("Học lực: " + classification);
                    }
                    break;
                case 2:
                    System.out.println("--- KẾT QUẢ ---");
                    if (count == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        double average = sum / count;
                        System.out.println("Số học viên đã nhập: " + count);
                        System.out.printf(Locale.US, "Điểm trung bình: %.2f%n", average);
                        System.out.printf(Locale.US, "Điểm cao nhất: %.2f%n", max);
                        System.out.printf(Locale.US, "Điểm thấp nhất: %.2f%n", min);
                    }
                    break;
                case 3:
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
}

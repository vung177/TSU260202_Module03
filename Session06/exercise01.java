package Session06;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Locale;

public class exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] grades = null;

        while (true) {
            System.out.println("******************QUẢN LÝ ĐIỂM SV****************");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình của các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số từ 1 đến 8.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    grades = inputGrades(scanner);
                    break;
                case 2:
                    printGrades(grades);
                    break;
                case 3:
                    if (grades == null || grades.length == 0) {
                        System.out.println("Chưa có danh sách điểm. Vui lòng nhập điểm trước (Lựa chọn 1).\n");
                    } else {
                        double avg = calculateAverage(grades);
                        System.out.printf(Locale.US, "Điểm trung bình của các sinh viên: %.2f\n\n", avg);
                    }
                    break;
                case 4:
                    findMinMax(grades);
                    break;
                case 5:
                    countPassFail(grades);
                    break;
                case 6:
                    if (grades == null || grades.length == 0) {
                        System.out.println("Chưa có danh sách điểm. Vui lòng nhập điểm trước (Lựa chọn 1).\n");
                    } else {
                        sortGrades(grades);
                        System.out.println("Sắp xếp điểm tăng dần thành công!");
                        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(grades) + "\n");
                    }
                    break;
                case 7:
                    countExcellent(grades);
                    break;
                case 8:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không chính xác. Vui lòng chọn từ 1 đến 8.\n");
                    break;
            }
        }
    }

    /**
     * Nhập danh sách điểm sinh viên từ bàn phím.
     */
    public static double[] inputGrades(Scanner scanner) {
        System.out.print("Nhập số lượng sinh viên: ");
        int n;
        try {
            n = Integer.parseInt(scanner.nextLine().trim());
            if (n <= 0) {
                System.out.println("Số lượng sinh viên phải lớn hơn 0.\n");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Số lượng không hợp lệ.\n");
            return null;
        }

        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Nhập điểm cho sinh viên thứ " + (i + 1) + ": ");
                try {
                    double val = Double.parseDouble(scanner.nextLine().replace(",", ".").trim());
                    if (val < 0 || val > 10) {
                        System.out.println("Điểm phải nằm trong khoảng từ 0 đến 10. Vui lòng nhập lại.");
                        continue;
                    }
                    arr[i] = val;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Điểm không hợp lệ. Vui lòng nhập số.");
                }
            }
        }
        System.out.println("Nhập danh sách điểm thành công!\n");
        return arr;
    }

    /**
     * In danh sách điểm sinh viên.
     */
    public static void printGrades(double[] grades) {
        if (grades == null || grades.length == 0) {
            System.out.println("Chưa có danh sách điểm. Vui lòng nhập điểm trước (Lựa chọn 1).\n");
            return;
        }
        System.out.print("Danh sách điểm sinh viên: ");
        for (int i = 0; i < grades.length; i++) {
            System.out.print(grades[i] + (i == grades.length - 1 ? "" : ", "));
        }
        System.out.println("\n");
    }

    /**
     * Tính điểm trung bình của các sinh viên.
     */
    public static double calculateAverage(double[] grades) {
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return sum / grades.length;
    }

    /**
     * Tìm điểm cao nhất và thấp nhất.
     */
    public static void findMinMax(double[] grades) {
        if (grades == null || grades.length == 0) {
            System.out.println("Chưa có danh sách điểm. Vui lòng nhập điểm trước (Lựa chọn 1).\n");
            return;
        }
        double min = grades[0];
        double max = grades[0];
        for (double g : grades) {
            if (g < min) min = g;
            if (g > max) max = g;
        }
        System.out.printf(Locale.US, "Điểm cao nhất: %.1f\n", max);
        System.out.printf(Locale.US, "Điểm thấp nhất: %.1f\n\n", min);
    }

    /**
     * Đếm số lượng sinh viên đạt và trượt.
     */
    public static void countPassFail(double[] grades) {
        if (grades == null || grades.length == 0) {
            System.out.println("Chưa có danh sách điểm. Vui lòng nhập điểm trước (Lựa chọn 1).\n");
            return;
        }
        int pass = 0;
        int fail = 0;
        for (double g : grades) {
            if (g >= 5) {
                pass++;
            } else {
                fail++;
            }
        }
        System.out.println("Số lượng sinh viên đạt (điểm >= 5): " + pass);
        System.out.println("Số lượng sinh viên trượt (điểm < 5): " + fail + "\n");
    }

    /**
     * Sắp xếp điểm tăng dần sử dụng thuật toán nổi bọt (Bubble Sort) tối ưu.
     */
    public static void sortGrades(double[] grades) {
        int n = grades.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (grades[j] > grades[j + 1]) {
                    double temp = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Thống kê số lượng sinh viên giỏi và xuất sắc.
     */
    public static void countExcellent(double[] grades) {
        if (grades == null || grades.length == 0) {
            System.out.println("Chưa có danh sách điểm. Vui lòng nhập điểm trước (Lựa chọn 1).\n");
            return;
        }
        int count = 0;
        for (double g : grades) {
            if (g >= 8) {
                count++;
            }
        }
        System.out.println("Số lượng sinh viên xếp loại giỏi và xuất sắc (điểm >= 8): " + count + "\n");
    }
}

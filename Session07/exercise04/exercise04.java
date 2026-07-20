package Session07.exercise04;

import java.util.Scanner;

public class exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khởi tạo danh sách sinh viên có sẵn
        Student[] students = {
            new Student("Nguyễn Văn A", 20, "JV2403", 8.5),
            new Student("Trần Thị B", 21, "JV2403", 6.2),
            new Student("Lê Văn C", 22, "JV2404", 4.5),
            new Student("Phạm Minh D", 20, "JV2404", 9.2),
            new Student("Hoàng Thị E", 21, "JV2403", 7.8)
        };

        System.out.println("--- DANH SÁCH SINH VIÊN BAN ĐẦU ---");
        for (Student s : students) {
            s.displayRow();
        }
        System.out.println("-----------------------------------\n");

        double min = 0;
        double max = 0;

        // Nhập khoảng điểm cần lọc
        while (true) {
            System.out.print("Nhập điểm tối thiểu (min): ");
            try {
                min = Double.parseDouble(scanner.nextLine().replace(",", ".").trim());
                if (min < 0 || min > 10) {
                    System.out.println("Điểm phải nằm trong khoảng từ 0 đến 10. Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Điểm không hợp lệ. Vui lòng nhập số.");
            }
        }

        while (true) {
            System.out.print("Nhập điểm tối đa (max): ");
            try {
                max = Double.parseDouble(scanner.nextLine().replace(",", ".").trim());
                if (max < 0 || max > 10) {
                    System.out.println("Điểm phải nằm trong khoảng từ 0 đến 10. Vui lòng nhập lại.");
                    continue;
                }
                if (max < min) {
                    System.out.println("Điểm tối đa không được nhỏ hơn điểm tối thiểu (" + min + "). Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Điểm không hợp lệ. Vui lòng nhập số.");
            }
        }

        // Lọc và hiển thị danh sách sinh viên
        System.out.println("\n--- DANH SÁCH SINH VIÊN CÓ ĐTB TRONG KHOẢNG [" + min + ", " + max + "] ---");
        filterStudents(students, min, max);

        scanner.close();
    }

    /**
     * Lọc và hiển thị danh sách sinh viên có điểm trung bình nằm trong khoảng [min, max].
     * 
     * @param students danh sách sinh viên
     * @param min điểm tối thiểu
     * @param max điểm tối đa
     */
    public static void filterStudents(Student[] students, double min, double max) {
        if (students == null) {
            return;
        }

        boolean found = false;
        for (Student s : students) {
            if (s.getAvgScore() >= min && s.getAvgScore() <= max) {
                s.displayRow();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên nào thỏa mãn điều kiện.");
        }
    }
}

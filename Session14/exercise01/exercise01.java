package Session14.exercise01;

import java.util.Scanner;

public class exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        while (true) {
            System.out.println("================= QUẢN LÝ SINH VIÊN =================");
            System.out.println("1. Thêm nhiều sinh viên (sử dụng stored procedure add_students)");
            System.out.println("2. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên từ 1-2.\n");
                continue;
            }
            switch (choice) {
                case 1:
                    manager.addStudents();
                    break;
                case 2:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn 1 hoặc 2.\n");
            }
        }
    }
}

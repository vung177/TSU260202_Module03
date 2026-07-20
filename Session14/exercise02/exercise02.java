package Session14.exercise02;

import java.util.Scanner;

public class exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        while (true) {
            System.out.println("================= CẬP NHẬT SINH VIÊN =================");
            System.out.println("1. Cập nhật thông tin sinh viên");
            System.out.println("2. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên 1-2.\n");
                continue;
            }
            switch (choice) {
                case 1:
                    int id = InputData.getInt(scanner, "Nhập ID sinh viên cần cập nhật: ");
                    String newName = InputData.getString(scanner, "Nhập họ và tên mới: ");
                    int newAge = InputData.getInt(scanner, "Nhập tuổi mới: ");
                    manager.updateStudent(id, newName, newAge);
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

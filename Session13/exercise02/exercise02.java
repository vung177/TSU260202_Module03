package Session13.exercise02;

import java.util.Scanner;
import java.time.LocalDate;

public class exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("******************QUẢN LÝ SINH VIÊN (JDBC)****************");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Sửa sinh viên (Chức năng chưa thực hiện)");
            System.out.println("4. Xóa sinh viên (Chức năng chưa thực hiện)");
            System.out.println("5. Tìm kiếm sinh viên (Chức năng chưa thực hiện)");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Lựa chọn phải là số nguyên từ 1 đến 6. Vui lòng nhập lại.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    manager.displayStudents();
                    break;
                case 2:
                    System.out.println("\n--- THÊM SINH VIÊN MỚI ---");
                    String fullName = InputData.getString(scanner, "Nhập họ và tên: ");
                    LocalDate dob = InputData.getLocalDate(scanner, "Nhập ngày sinh (dd/MM/yyyy): ");
                    String email = InputData.getEmail(scanner, "Nhập email: ");
                    manager.addStudent(fullName, dob, email);
                    break;
                case 3:
                case 4:
                case 5:
                    System.out.println("Thông báo: Theo yêu cầu đề bài, chức năng này chưa cần triển khai ở bài tập này.\n");
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lỗi: Lựa chọn không hợp lệ (phải từ 1 đến 6).\n");
                    break;
            }
        }
    }
}

package Session13.exercise04;

import java.util.Scanner;
import java.time.LocalDate;

public class exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("******************QUẢN LÝ SINH VIÊN (JDBC)****************");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Sửa sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Tìm kiếm sinh viên theo tên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên từ 1 đến 6.\n");
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
                    System.out.println("\n--- SỬA THÔNG TIN SINH VIÊN ---");
                    int editId = InputData.getInt(scanner, "Nhập ID sinh viên cần sửa: ");
                    Student existing = manager.findStudentById(editId);
                    if (existing == null) {
                        System.out.println("Không tìm thấy sinh viên với ID = " + editId + "\n");
                        break;
                    }
                    System.out.println("Thông tin hiện tại: " + existing);
                    String newName = InputData.getString(scanner, "Nhập họ và tên mới: ");
                    LocalDate newDob = InputData.getLocalDate(scanner, "Nhập ngày sinh mới (dd/MM/yyyy): ");
                    String newEmail = InputData.getEmail(scanner, "Nhập email mới: ");
                    manager.updateStudent(editId, newName, newDob, newEmail);
                    break;
                case 4:
                    System.out.println("\n--- XÓA SINH VIÊN ---");
                    int deleteId = InputData.getInt(scanner, "Nhập ID sinh viên cần xóa: ");
                    Student toDelete = manager.findStudentById(deleteId);
                    if (toDelete == null) {
                        System.out.println("Không tìm thấy sinh viên với ID = " + deleteId + "\n");
                        break;
                    }
                    System.out.println("Bạn chắc muốn xóa sinh viên: " + toDelete);
                    System.out.print("Nhập Y để xác nhận, bất kỳ ký tự nào khác để hủy: ");
                    String confirm = scanner.nextLine().trim();
                    if (confirm.equalsIgnoreCase("Y")) {
                        manager.deleteStudent(deleteId);
                    } else {
                        System.out.println("Hủy xóa sinh viên.\n");
                    }
                    break;
                case 5:
                    System.out.println("\n--- TÌM KIẾM SINH VIÊN THEO TÊN ---");
                    String nameFragment = InputData.getString(scanner, "Nhập một phần tên để tìm kiếm: ");
                    manager.searchStudent(nameFragment);
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

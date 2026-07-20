package Session10.exercise04;

import java.util.Scanner;

public class exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AttendanceManager manager = new AttendanceManager();

        // Thêm dữ liệu điểm danh ban đầu làm mẫu
        manager.add(new Student("Nguyễn Văn A"));
        manager.add(new Student("Trần Thị B"));

        while (true) {
            System.out.println("******************ĐIỂM DANH LỚP HỌC****************");
            System.out.println("1. Thêm sinh viên mới");
            System.out.println("2. Sửa thông tin sinh viên theo index");
            System.out.println("3. Xóa sinh viên theo index");
            System.out.println("4. Hiển thị danh sách điểm danh");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Lựa chọn phải là số nguyên từ 1 đến 5. Vui lòng nhập lại.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n--- THÊM SINH VIÊN ---");
                    String name = InputData.getString(scanner, "Nhập tên sinh viên: ");
                    manager.add(new Student(name));
                    System.out.println();
                    break;
                case 2:
                    System.out.println("\n--- SỬA SINH VIÊN ---");
                    if (manager.getStudents().isEmpty()) {
                        System.out.println("Danh sách trống. Không thể sửa.\n");
                        break;
                    }
                    manager.display();
                    int updateIdx = InputData.getIndex(scanner, "Nhập index cần sửa: ", manager.getStudents().size() - 1);
                    String newName = InputData.getString(scanner, "Nhập tên mới: ");
                    manager.update(updateIdx, new Student(newName));
                    System.out.println();
                    break;
                case 3:
                    System.out.println("\n--- XÓA SINH VIÊN ---");
                    if (manager.getStudents().isEmpty()) {
                        System.out.println("Danh sách trống. Không thể xóa.\n");
                        break;
                    }
                    manager.display();
                    int deleteIdx = InputData.getIndex(scanner, "Nhập index cần xóa: ", manager.getStudents().size() - 1);
                    manager.delete(deleteIdx);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("\n--- DANH SÁCH ĐIỂM DANH ---");
                    manager.display();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lỗi: Lựa chọn không hợp lệ (phải từ 1 đến 5).\n");
                    break;
            }
        }
    }
}

package Session10.exercise03;

import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager manager = new UserManager();

        // Thêm một số dữ liệu mẫu ban đầu
        manager.addUser(new User("Nguyễn Văn A", "a.nguyen@gmail.com", "0987654321"));
        manager.addUser(new User("Trần Thị B", "b.tran@gmail.com", "0912345678"));

        while (true) {
            System.out.println("******************QUẢN LÝ NGƯỜI DÙNG****************");
            System.out.println("1. Thêm người dùng mới");
            System.out.println("2. Hiển thị danh sách người dùng");
            System.out.println("3. Xóa người dùng theo email");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Lựa chọn phải là số nguyên từ 1 đến 4. Vui lòng nhập lại.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n--- THÊM NGƯỜI DÙNG MỚI ---");
                    String name = InputData.getString(scanner, "Nhập tên người dùng: ");
                    String email = InputData.getEmail(scanner, "Nhập email: ");
                    String phone = InputData.getPhoneNumber(scanner, "Nhập số điện thoại: ");
                    manager.addUser(new User(name, email, phone));
                    System.out.println();
                    break;
                case 2:
                    System.out.println("\n--- DANH SÁCH NGƯỜI DÙNG ---");
                    manager.displayUsers();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("\n--- XÓA NGƯỜI DÙNG ---");
                    String deleteEmail = InputData.getString(scanner, "Nhập email người dùng cần xóa: ");
                    manager.deleteUserByEmail(deleteEmail);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lỗi: Lựa chọn không hợp lệ (phải từ 1 đến 4).\n");
                    break;
            }
        }
    }
}

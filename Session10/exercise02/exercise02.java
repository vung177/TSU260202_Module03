package Session10.exercise02;

import java.util.Scanner;

public class exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager manager = new BookManager();

        // Thêm một vài cuốn sách làm mẫu
        manager.addBook(new Book("Lập trình Java", "Rikkei", 2023));
        manager.addBook(new Book("Cấu trúc dữ liệu", "Rikkei Academy", 2022));

        while (true) {
            System.out.println("******************QUẢN LÝ SÁCH****************");
            System.out.println("1. Thêm sách mới");
            System.out.println("2. Hiển thị danh sách sách");
            System.out.println("3. Tìm kiếm sách theo tên");
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
                    System.out.println("\n--- THÊM SÁCH MỚI ---");
                    String title = InputData.getString(scanner, "Nhập tên sách: ");
                    String author = InputData.getString(scanner, "Nhập tác giả: ");
                    int year = InputData.getInt(scanner, "Nhập năm xuất bản: ");
                    manager.addBook(new Book(title, author, year));
                    System.out.println("Thêm sách thành công!\n");
                    break;
                case 2:
                    System.out.println("\n--- DANH SÁCH SÁCH ---");
                    manager.displayBooks();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("\n--- TÌM KIẾM SÁCH ---");
                    String searchTitle = InputData.getString(scanner, "Nhập tên sách cần tìm: ");
                    manager.searchBookByTitle(searchTitle);
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

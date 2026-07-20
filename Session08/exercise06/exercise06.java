package Session08.exercise06;

import java.util.Scanner;
import java.util.Calendar;

public class exercise06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager manager = new BookManager();

        while (true) {
            System.out.println("******************QUẢN LÝ SÁCH****************");
            System.out.println("1. Thêm quyển sách mới");
            System.out.println("2. Hiển thị tất cả quyển sách");
            System.out.println("3. Xóa quyển sách");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số từ 1 đến 4.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    addNewBookMenu(scanner, manager);
                    break;
                case 2:
                    manager.displayBooks();
                    break;
                case 3:
                    deleteBookMenu(scanner, manager);
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không chính xác. Vui lòng chọn từ 1 đến 4.\n");
                    break;
            }
        }
    }

    /**
     * Menu phụ: Nhập thông tin để thêm sách.
     */
    private static void addNewBookMenu(Scanner scanner, BookManager manager) {
        System.out.println("\n--- THÊM MỚI QUYỂN SÁCH ---");
        
        String title;
        while (true) {
            System.out.print("Nhập tiêu đề sách: ");
            title = scanner.nextLine().trim();
            if (title.isEmpty()) {
                System.out.println("Tiêu đề không được để trống.");
                continue;
            }
            break;
        }

        System.out.print("Nhập tác giả: ");
        String author = scanner.nextLine().trim();

        String isbn;
        while (true) {
            System.out.print("Nhập mã ISBN: ");
            isbn = scanner.nextLine().trim();
            if (isbn.isEmpty()) {
                System.out.println("Mã ISBN không được để trống.");
                continue;
            }
            if (manager.findBookByIsbn(isbn) != null) {
                System.out.println("Mã ISBN này đã tồn tại trong hệ thống. Vui lòng nhập mã khác.");
                continue;
            }
            break;
        }

        int year = 0;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        while (true) {
            System.out.print("Nhập năm xuất bản: ");
            try {
                year = Integer.parseInt(scanner.nextLine().trim());
                if (year <= 0 || year > currentYear + 5) { // Cho phép trước hoặc lệch một chút năm tương lai
                    System.out.println("Năm xuất bản không hợp lệ. Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Năm xuất bản phải là số nguyên.");
            }
        }

        Book b = new Book(title, author, isbn, year);
        manager.addBook(b);
        System.out.println();
    }

    /**
     * Menu phụ: Xóa sách theo ISBN.
     */
    private static void deleteBookMenu(Scanner scanner, BookManager manager) {
        System.out.println("\n--- XÓA QUYỂN SÁCH ---");
        System.out.print("Nhập mã ISBN cần xóa: ");
        String isbn = scanner.nextLine().trim();
        manager.removeBook(isbn);
        System.out.println();
    }
}

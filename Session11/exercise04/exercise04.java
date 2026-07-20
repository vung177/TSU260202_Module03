package Session11.exercise04;

import java.util.Scanner;

public class exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager manager = new ProductManager();

        // Nạp dữ liệu mẫu ban đầu để kiểm thử
        manager.addProduct(new Product(1, "Laptop Dell", 850.50));
        manager.addProduct(new Product(2, "Chuột không dây", 25.00));
        manager.addProduct(new Product(3, "Bàn phím cơ", 120.00));
        manager.addProduct(new Product(4, "Tai nghe bluetooth", 90.00));

        while (true) {
            System.out.println("******************QUẢN LÝ SẢN PHẨM****************");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Sửa thông tin sản phẩm theo ID");
            System.out.println("3. Xóa sản phẩm theo ID");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Lọc sản phẩm có giá lớn hơn 100");
            System.out.println("6. Tính tổng giá trị tất cả sản phẩm");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Lựa chọn phải là số nguyên từ 1 đến 7. Vui lòng nhập lại.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n--- THÊM SẢN PHẨM MỚI ---");
                    int id = InputData.getInt(scanner, "Nhập mã ID sản phẩm: ");
                    String name = InputData.getString(scanner, "Nhập tên sản phẩm: ");
                    double price = InputData.getDouble(scanner, "Nhập giá sản phẩm: ");
                    manager.addProduct(new Product(id, name, price));
                    System.out.println();
                    break;
                case 2:
                    System.out.println("\n--- SỬA SẢN PHẨM ---");
                    int updateId = InputData.getInt(scanner, "Nhập mã ID cần sửa: ");
                    if (!manager.getProducts().containsKey(updateId)) {
                        System.out.println("Lỗi: Không tìm thấy sản phẩm có ID " + updateId + "\n");
                        break;
                    }
                    String newName = InputData.getString(scanner, "Nhập tên sản phẩm mới: ");
                    double newPrice = InputData.getDouble(scanner, "Nhập giá sản phẩm mới: ");
                    manager.updateProduct(updateId, newName, newPrice);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("\n--- XÓA SẢN PHẨM ---");
                    int deleteId = InputData.getInt(scanner, "Nhập mã ID cần xóa: ");
                    manager.deleteProduct(deleteId);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
                    manager.displayAll();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("\n--- LỌC SẢN PHẨM GIÁ > 100 ---");
                    manager.filterPriceGreaterThan100();
                    System.out.println();
                    break;
                case 6:
                    System.out.println("\n--- TỔNG GIÁ TRỊ KHO HÀNG ---");
                    double total = manager.getTotalValue();
                    System.out.printf("Tổng giá trị của tất cả sản phẩm: %,.2f\n\n", total);
                    break;
                case 7:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lỗi: Lựa chọn không hợp lệ (phải từ 1 đến 7).\n");
                    break;
            }
        }
    }
}

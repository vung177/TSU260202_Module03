package Session07.exercise05;

import java.util.Scanner;
import java.util.ArrayList;

public class exercise05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> productList = new ArrayList<>();

        while (true) {
            System.out.println("******************QUẢN LÝ SẢN PHẨM****************");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số từ 1 đến 5.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    addProduct(scanner, productList);
                    break;
                case 2:
                    displayProducts(productList);
                    break;
                case 3:
                    updateProduct(scanner, productList);
                    break;
                case 4:
                    deleteProduct(scanner, productList);
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không chính xác. Vui lòng chọn từ 1 đến 5.\n");
                    break;
            }
        }
    }

    /**
     * Thêm mới sản phẩm vào danh sách.
     */
    public static void addProduct(Scanner scanner, ArrayList<Product> list) {
        System.out.println("\n--- THÊM MỚI SẢN PHẨM ---");
        
        String id;
        while (true) {
            System.out.print("Nhập mã sản phẩm: ");
            id = scanner.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("Mã sản phẩm không được để trống.");
                continue;
            }
            if (findProductById(list, id) != null) {
                System.out.println("Mã sản phẩm đã tồn tại. Vui lòng nhập mã khác.");
                continue;
            }
            break;
        }

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine().trim();

        double price = 0;
        while (true) {
            System.out.print("Nhập giá sản phẩm: ");
            try {
                price = Double.parseDouble(scanner.nextLine().replace(",", ".").trim());
                if (price < 0) {
                    System.out.println("Giá sản phẩm không được âm. Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Giá không hợp lệ. Vui lòng nhập số.");
            }
        }

        Product p = new Product(id, name, price);
        list.add(p);
        System.out.println("Thêm sản phẩm thành công!\n");
    }

    /**
     * Hiển thị danh sách sản phẩm.
     */
    public static void displayProducts(ArrayList<Product> list) {
        System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.\n");
            return;
        }
        for (Product p : list) {
            p.displayRow();
        }
        System.out.println("---------------------------\n");
    }

    /**
     * Cập nhật thông tin sản phẩm theo ID.
     */
    public static void updateProduct(Scanner scanner, ArrayList<Product> list) {
        System.out.println("\n--- CẬP NHẬT SẢN PHẨM ---");
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách trống. Không có sản phẩm nào để cập nhật.\n");
            return;
        }

        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String id = scanner.nextLine().trim();
        Product p = findProductById(list, id);

        if (p == null) {
            System.out.println("Không tìm thấy sản phẩm có mã: " + id + "\n");
            return;
        }

        System.out.print("Nhập tên mới (để trống nếu giữ nguyên \"" + p.getName() + "\"): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            p.setName(newName);
        }

        while (true) {
            System.out.print("Nhập giá mới (để trống nếu giữ nguyên \"" + p.getPrice() + "\"): ");
            String priceInput = scanner.nextLine().trim();
            if (priceInput.isEmpty()) {
                break; // Giữ nguyên giá cũ
            }
            try {
                double newPrice = Double.parseDouble(priceInput.replace(",", "."));
                if (newPrice < 0) {
                    System.out.println("Giá sản phẩm không được âm. Vui lòng nhập lại.");
                    continue;
                }
                p.setPrice(newPrice);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Giá không hợp lệ. Vui lòng nhập số.");
            }
        }

        System.out.println("Cập nhật sản phẩm thành công!\n");
    }

    /**
     * Xóa sản phẩm khỏi danh sách theo ID.
     */
    public static void deleteProduct(Scanner scanner, ArrayList<Product> list) {
        System.out.println("\n--- XÓA SẢN PHẨM ---");
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách trống. Không có sản phẩm để xóa.\n");
            return;
        }

        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String id = scanner.nextLine().trim();
        Product p = findProductById(list, id);

        if (p == null) {
            System.out.println("Không tìm thấy sản phẩm có mã: " + id + "\n");
            return;
        }

        list.remove(p);
        System.out.println("Xóa sản phẩm có mã \"" + id + "\" thành công!\n");
    }

    /**
     * Tìm kiếm sản phẩm trong danh sách theo ID.
     */
    public static Product findProductById(ArrayList<Product> list, String id) {
        if (list == null || id == null) {
            return null;
        }
        for (Product p : list) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}

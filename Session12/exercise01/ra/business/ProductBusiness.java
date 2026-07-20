package ra.business;

import ra.entity.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class ProductBusiness {
    private List<Product> productList;

    // Constructor khởi tạo danh sách sản phẩm
    public ProductBusiness() {
        this.productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return this.productList;
    }

    // Thêm sản phẩm mới
    public void addProduct(Scanner scanner) {
        System.out.println("\n--- THÊM SẢN PHẨM MỚI ---");
        Product product = new Product();
        product.inputData(scanner, this.productList);
        this.productList.add(product);
        System.out.println("Thêm sản phẩm thành công!");
    }

    // Hiển thị danh sách sản phẩm
    public void displayAll() {
        System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
        if (this.productList.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }
        this.productList.forEach(System.out::println);
    }

    // Cập nhật sản phẩm theo mã sản phẩm
    public void updateProduct(Scanner scanner) {
        System.out.println("\n--- CẬP NHẬT SẢN PHẨM ---");
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Mã sản phẩm phải là số nguyên.");
            return;
        }

        Product target = findProductById(id);
        if (target == null) {
            System.out.println("Lỗi: Không tìm thấy sản phẩm có mã ID: " + id);
            return;
        }

        System.out.println("Tìm thấy sản phẩm cần cập nhật: " + target);
        // Nhập thông tin cập nhật mới cho các trường (tránh trùng tên với các sản phẩm khác)
        target.inputData(scanner, this.productList);
        System.out.println("Cập nhật thông tin sản phẩm thành công!");
    }

    // Xóa sản phẩm theo mã sản phẩm
    public void deleteProduct(Scanner scanner) {
        System.out.println("\n--- XÓA SẢN PHẨM ---");
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Mã sản phẩm phải là số nguyên.");
            return;
        }

        Product target = findProductById(id);
        if (target == null) {
            System.out.println("Lỗi: Không tìm thấy sản phẩm có mã ID: " + id);
            return;
        }

        this.productList.remove(target);
        System.out.println("Xóa sản phẩm thành công!");
    }

    // Tìm kiếm sản phẩm gần đúng theo tên (không phân biệt hoa thường)
    public void searchByName(Scanner scanner) {
        System.out.println("\n--- TÌM KIẾM SẢN PHẨM THEO TÊN ---");
        System.out.print("Nhập từ khóa tìm kiếm: ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (Product p : this.productList) {
            if (p.getProductName().toLowerCase().contains(keyword)) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sản phẩm nào chứa từ khóa: \"" + keyword + "\"");
        }
    }

    // Sắp xếp sản phẩm theo giá tăng dần
    public void sortByPriceAsc() {
        System.out.println("\n--- DANH SÁCH SẮP XẾP THEO GIÁ TĂNG DẦN ---");
        if (this.productList.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        List<Product> sortedList = new ArrayList<>(this.productList);
        Collections.sort(sortedList, Comparator.comparingDouble(Product::getPrice));
        sortedList.forEach(System.out::println);
    }

    // Sắp xếp sản phẩm theo số lượng giảm dần
    public void sortByQuantityDesc() {
        System.out.println("\n--- DANH SÁCH SẮP XẾP THEO SỐ LƯỢNG GIẢM DẦN ---");
        if (this.productList.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        List<Product> sortedList = new ArrayList<>(this.productList);
        Collections.sort(sortedList, (p1, p2) -> Integer.compare(p2.getQuantity(), p1.getQuantity()));
        sortedList.forEach(System.out::println);
    }

    // Helper tìm sản phẩm theo mã ID
    private Product findProductById(int id) {
        for (Product p : this.productList) {
            if (p.getProductId() == id) {
                return p;
            }
        }
        return null;
    }
}

package Session11.exercise04;

import java.util.HashMap;
import java.util.Map;

public class ProductManager {
    private Map<Integer, Product> products;

    // Constructor khởi tạo
    public ProductManager() {
        this.products = new HashMap<>();
    }

    // Lấy HashMap lưu trữ
    public Map<Integer, Product> getProducts() {
        return this.products;
    }

    // Thêm sản phẩm mới (chặn trùng khóa ID)
    public void addProduct(Product p) {
        if (p == null) return;
        if (this.products.containsKey(p.getId())) {
            System.out.println("Lỗi: Mã sản phẩm ID " + p.getId() + " đã tồn tại.");
            return;
        }
        this.products.put(p.getId(), p);
        System.out.println("Thêm sản phẩm thành công!");
    }

    // Sửa sản phẩm
    public void updateProduct(int id, String newName, double newPrice) {
        Product p = this.products.get(id);
        if (p == null) {
            System.out.println("Lỗi: Không tìm thấy sản phẩm có ID " + id);
            return;
        }
        p.setName(newName);
        p.setPrice(newPrice);
        System.out.println("Cập nhật thông tin sản phẩm thành công!");
    }

    // Xóa sản phẩm theo khóa ID
    public void deleteProduct(int id) {
        if (!this.products.containsKey(id)) {
            System.out.println("Lỗi: Không tìm thấy sản phẩm có ID " + id);
            return;
        }
        Product removed = this.products.remove(id);
        System.out.println("Đã xóa sản phẩm: " + removed);
    }

    // Hiển thị tất cả sản phẩm
    public void displayAll() {
        if (this.products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
        } else {
            this.products.values().forEach(System.out::println);
        }
    }

    // Lọc sản phẩm có giá > 100 sử dụng Stream
    public void filterPriceGreaterThan100() {
        System.out.println("Danh sách sản phẩm có giá > 100:");
        long count = this.products.values().stream()
                .filter(p -> p.getPrice() > 100)
                .peek(System.out::println)
                .count();
        if (count == 0) {
            System.out.println("(Không có sản phẩm nào có giá lớn hơn 100)");
        }
    }

    // Tính tổng giá trị sản phẩm sử dụng Stream
    public double getTotalValue() {
        return this.products.values().stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}

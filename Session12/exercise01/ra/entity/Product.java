package ra.entity;

import java.util.List;
import java.util.Scanner;

public class Product {
    private static int autoId = 1;

    private int productId;
    private String productName;
    private float price;
    private String category;
    private int quantity;

    // Constructor không tham số
    public Product() {
        this.productId = autoId++;
    }

    // Constructor đầy đủ tham số
    public Product(int productId, String productName, float price, String category, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    // Các phương thức getter/setter
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Phương thức nhập đầy đủ thông tin của sản phẩm (Signature chuẩn đề bài yêu cầu)
    public void inputData(Scanner scanner) {
        inputData(scanner, java.util.Collections.emptyList());
    }

    // Nạp chồng (Overload) nhận danh sách sản phẩm hiện tại để validate trùng tên sản phẩm
    public void inputData(Scanner scanner, List<Product> existingProducts) {
        // 1. Tên sản phẩm: 10-50 ký tự, không trùng lặp
        while (true) {
            System.out.print("Nhập tên sản phẩm (10-50 ký tự): ");
            String name = scanner.nextLine().trim();
            if (name.length() < 10 || name.length() > 50) {
                System.out.println("Lỗi: Tên sản phẩm phải có độ dài từ 10 đến 50 ký tự.");
                continue;
            }
            boolean isDuplicate = false;
            for (Product p : existingProducts) {
                if (p.getProductId() != this.productId && p.getProductName().equalsIgnoreCase(name)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                System.out.println("Lỗi: Tên sản phẩm đã tồn tại. Vui lòng nhập tên khác.");
                continue;
            }
            this.productName = name;
            break;
        }

        // 2. Giá sản phẩm: float > 0
        while (true) {
            System.out.print("Nhập giá sản phẩm (> 0): ");
            try {
                float val = Float.parseFloat(scanner.nextLine().replace(",", ".").trim());
                if (val <= 0) {
                    System.out.println("Lỗi: Giá sản phẩm phải lớn hơn 0.");
                    continue;
                }
                this.price = val;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Giá sản phẩm phải là một số thực.");
            }
        }

        // 3. Loại sản phẩm: tối đa 200 ký tự
        while (true) {
            System.out.print("Nhập loại sản phẩm (tối đa 200 ký tự): ");
            String cat = scanner.nextLine().trim();
            if (cat.isEmpty()) {
                System.out.println("Lỗi: Loại sản phẩm không được để trống.");
                continue;
            }
            if (cat.length() > 200) {
                System.out.println("Lỗi: Loại sản phẩm không được vượt quá 200 ký tự.");
                continue;
            }
            this.category = cat;
            break;
        }

        // 4. Số lượng tồn kho: int >= 0
        while (true) {
            System.out.print("Nhập số lượng tồn kho (>= 0): ");
            try {
                int qty = Integer.parseInt(scanner.nextLine().trim());
                if (qty < 0) {
                    System.out.println("Lỗi: Số lượng tồn kho phải lớn hơn hoặc bằng 0.");
                    continue;
                }
                this.quantity = qty;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Số lượng tồn kho phải là số nguyên.");
            }
        }
    }

    // Ghi đè phương thức toString() hiển thị thông tin sản phẩm
    @Override
    public String toString() {
        return "Mã SP: " + this.productId +
               " | Tên: " + this.productName +
               " | Giá: " + this.price +
               " | Loại: " + this.category +
               " | Tồn kho: " + this.quantity;
    }
}

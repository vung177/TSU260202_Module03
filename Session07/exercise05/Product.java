package Session07.exercise05;

import java.util.Locale;

public class Product {
    private String id;
    private String name;
    private double price;

    // Constructor mặc định
    public Product() {
    }

    // Constructor có tham số
    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getter và Setter cho thuộc tính id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter và Setter cho thuộc tính name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter và Setter cho thuộc tính price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Phương thức hiển thị thông tin sản phẩm theo dạng dòng
    public void displayRow() {
        System.out.printf(Locale.US, "Mã SP: %-10s | Tên SP: %-20s | Giá: %,.2f VND\n", 
                this.id, this.name, this.price);
    }
}

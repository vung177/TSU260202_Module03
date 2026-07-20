package Session11.exercise04;

public class Product {
    private int id;
    private String name;
    private double price;

    // Constructor đầy đủ tham số
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getter và Setter cho các thuộc tính
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Ghi đè phương thức toString hiển thị chi tiết sản phẩm
    @Override
    public String toString() {
        return "ID: " + this.id + " | Tên SP: " + this.name + " | Giá: " + this.price;
    }
}

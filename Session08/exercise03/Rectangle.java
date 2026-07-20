package Session08.exercise03;

public class Rectangle implements Colorable {
    private double length;
    private double width;
    private String color;

    // Constructor mặc định
    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
        this.color = "Không màu";
    }

    // Constructor có tham số
    public Rectangle(double length, double width) {
        this.length = (length <= 0) ? 1.0 : length;
        this.width = (width <= 0) ? 1.0 : width;
        this.color = "Không màu";
    }

    // Getter và Setter cho length
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        }
    }

    // Getter và Setter cho width
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        }
    }

    // Getter cho color
    public String getColor() {
        return color;
    }

    // Triển khai phương thức setColor từ interface Colorable
    @Override
    public void setColor(String color) {
        this.color = (color == null || color.trim().isEmpty()) ? "Không màu" : color;
    }

    // Phương thức hiển thị thông tin
    public void display() {
        System.out.println("Hình Chữ Nhật - Chiều dài: " + this.length + ", Chiều rộng: " + this.width + " | Màu sắc: " + this.color);
    }
}

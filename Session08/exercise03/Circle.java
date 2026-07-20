package Session08.exercise03;

public class Circle implements Colorable {
    private double radius;
    private String color;

    // Constructor mặc định
    public Circle() {
        this.radius = 1.0;
        this.color = "Không màu";
    }

    // Constructor có tham số
    public Circle(double radius) {
        this.radius = (radius <= 0) ? 1.0 : radius;
        this.color = "Không màu";
    }

    // Getter và Setter cho radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
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
        System.out.println("Hình Tròn - Bán kính: " + this.radius + " | Màu sắc: " + this.color);
    }
}

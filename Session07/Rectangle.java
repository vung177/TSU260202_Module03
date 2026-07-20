package Session07;

import java.util.Locale;

public class Rectangle {
    private double length;
    private double width;

    // Constructor mặc định (chiều dài và chiều rộng = 1)
    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }

    // Constructor có tham số
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Getter và Setter
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Phương thức tính diện tích
    public double getArea() {
        return this.length * this.width;
    }

    // Phương thức tính chu vi
    public double getPerimeter() {
        return 2 * (this.length + this.width);
    }

    // Phương thức hiển thị thông tin
    public void display() {
        System.out.printf(Locale.US, "Chiều dài: %.2f\n", this.length);
        System.out.printf(Locale.US, "Chiều rộng: %.2f\n", this.width);
        System.out.printf(Locale.US, "Diện tích: %.2f\n", getArea());
        System.out.printf(Locale.US, "Chu vi: %.2f\n\n", getPerimeter());
    }
}

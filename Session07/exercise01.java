package Session07;

import java.util.Scanner;
import java.util.Locale;

class Rectangle {
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

public class exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Tạo hình chữ nhật với Constructor mặc định ---");
        Rectangle rect1 = new Rectangle();
        rect1.display();

        System.out.println("--- Tạo hình chữ nhật với Constructor có tham số ---");
        double length = 0;
        double width = 0;

        while (true) {
            System.out.print("Nhập chiều dài: ");
            try {
                length = Double.parseDouble(scanner.nextLine().replace(",", ".").trim());
                if (length <= 0) {
                    System.out.println("Chiều dài phải lớn hơn 0. Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Đầu vào không hợp lệ. Vui lòng nhập số.");
            }
        }

        while (true) {
            System.out.print("Nhập chiều rộng: ");
            try {
                width = Double.parseDouble(scanner.nextLine().replace(",", ".").trim());
                if (width <= 0) {
                    System.out.println("Chiều rộng phải lớn hơn 0. Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Đầu vào không hợp lệ. Vui lòng nhập số.");
            }
        }

        Rectangle rect2 = new Rectangle(length, width);
        System.out.println("\nThông tin hình chữ nhật vừa tạo:");
        rect2.display();

        scanner.close();
    }
}

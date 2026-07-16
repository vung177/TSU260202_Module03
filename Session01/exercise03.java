package Session01;

import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu người dùng
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu người dùng nhập bán kính
        System.out.printf("Nhập bán kính của hình tròn: ");

        // Khai báo biến radius và area
        double radius = scanner.nextDouble();
        double area = Math.PI * radius * radius;

        // Hiển thị diện tích hình tròn
        if (radius == 0) {
            System.out.println("Diện tích của hình tròn là: 0");
        } else {
            System.out.printf("Diện tích của hình tròn là: %.2f%n", area);
        }
        scanner.close();
    }
}

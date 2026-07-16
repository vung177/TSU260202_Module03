package Session01;

import java.util.Scanner;

public class exercise06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập chiều rộng và chiều cao từ bàn phím
        System.out.print("Nhập chiều rộng (width): ");
        float width = scanner.nextFloat();

        System.out.print("Nhập chiều cao (height): ");
        float height = scanner.nextFloat();

        // Tính diện tích và chu vi
        float area = width * height;
        float circumference = 2 * (width + height);

        // In kết quả ra màn hình
        System.out.printf("Diện tích : %.2f%n", area);
        System.out.printf("Chu vi : %.2f%n", circumference);

        scanner.close();
    }
}

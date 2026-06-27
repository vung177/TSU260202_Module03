package Session01;

import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập bán kính của hình tròn: ");
        double radius = scanner.nextDouble();
        double area = Math.PI * radius * radius;
        if (radius == 0) {
            System.out.println("Diện tích : 0");
        } else {
            System.out.printf("Diện tích : %.2f\n", area);
        }
        scanner.close();
    }
}

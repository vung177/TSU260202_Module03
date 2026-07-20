package Session07.exercise01;

import java.util.Scanner;
import java.util.Locale;

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

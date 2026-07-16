package Session02;

import java.util.Scanner;

public class exercise07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập cạnh thứ nhất: ");
        int a = scanner.nextInt();
        System.out.print("Nhập cạnh thứ hai: ");
        int b = scanner.nextInt();
        System.out.print("Nhập cạnh thứ ba: ");
        int c = scanner.nextInt();

        // Kiểm tra tính hợp lệ của 3 cạnh tam giác
        if (a <= 0 || b <= 0 || c <= 0 || (a + b <= c) || (a + c <= b) || (b + c <= a)) {
            System.out.println("Ba cạnh không tạo thành tam giác.");
        } else {
            // Phân loại tam giác theo thứ tự yêu cầu
            if (a == b && b == c) {
                System.out.println("Đây là tam giác đều.");
            } else if (a == b || b == c || a == c) {
                System.out.println("Đây là tam giác cân.");
            } else if ((a * a == b * b + c * c) || (b * b == a * a + c * c) || (c * c == a * a + b * b)) {
                System.out.println("Đây là tam giác vuông.");
            } else {
                System.out.println("Đây là tam giác thường.");
            }
        }

        scanner.close();
    }
}

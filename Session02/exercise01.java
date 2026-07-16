package Session02;

import java.util.Scanner;

public class exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập một số nguyên từ bàn phím
        System.out.print("Nhập một số nguyên n: ");
        int n = scanner.nextInt();

        // Sử dụng câu lệnh if-else để phân loại kết quả
        if (n == 0) {
            System.out.println("Số không phải chẵn cũng không phải lẻ");
        } else if (n % 2 == 0) {
            System.out.println("Số " + n + " là số chẵn");
        } else {
            System.out.println("Số " + n + " là số lẻ");
        }

        scanner.close();
    }
}

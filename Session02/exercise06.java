package Session02;

import java.util.Scanner;

public class exercise06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập một số nguyên N: ");
        int n = scanner.nextInt();

        // Nếu số là âm, chuyển thành số dương
        int temp = Math.abs(n);
        int sum = 0;

        // Tách và cộng dồn từng chữ số
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        System.out.println("Tổng các chữ số là: " + sum);

        scanner.close();
    }
}

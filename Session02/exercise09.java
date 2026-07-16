package Session02;

import java.util.Scanner;

public class exercise09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = -1;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Nhập một số nguyên dương N: ");
            String input = scanner.nextLine().trim();

            if (input.matches("\\d+")) {
                n = Integer.parseInt(input);
                if (n > 0) {
                    isValid = true;
                } else {
                    System.out.println("Số nhập vào không hợp lệ");
                }
            } else {
                System.out.println("Số nhập vào không hợp lệ");
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            if (isArmstrong(i)) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(i);
            }
        }
        System.out.println(sb.toString());

        scanner.close();
    }

    public static boolean isArmstrong(int num) {
        if (num == 0) {
            return true;
        }
        int k = countDigits(num);
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            sum += power(digit, k);
            temp /= 10;
        }
        return sum == num;
    }

    public static int countDigits(int num) {
        if (num == 0) return 1;
        int count = 0;
        int temp = num;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    public static int power(int base, int exp) {
        int res = 1;
        for (int i = 0; i < exp; i++) {
            res *= base;
        }
        return res;
    }
}

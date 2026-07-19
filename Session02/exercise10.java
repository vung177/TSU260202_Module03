package Session02;

import java.util.Scanner;
import java.util.HashSet;

public class exercise10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập một số nguyên dương N: ");
        int n = scanner.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (isHappy(i)) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(i);
            }
        }

        System.out.println("Các số Happy nhỏ hơn hoặc bằng " + n + " là: " + sb.toString());

        scanner.close();
    }

    public static boolean isHappy(int num) {
        HashSet<Integer> visited = new HashSet<>();
        int x = num;
        while (x != 1 && !visited.contains(x)) {
            visited.add(x);
            int sum = 0;
            int temp = x;
            while (temp > 0) {
                int digit = temp % 10;
                sum += digit * digit;
                temp /= 10;
            }
            x = sum;
        }
        return x == 1;
    }
}

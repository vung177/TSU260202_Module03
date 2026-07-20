package Session04;

import java.util.Scanner;
import java.util.Arrays;

public class exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập kích thước mảng: ");
        int size = scanner.nextInt();

        // Kiểm tra mảng rỗng
        if (size <= 0) {
            System.out.println("Kích thước rỗng");
            scanner.close();
            return;
        }

        int[] arr = new int[size];
        System.out.println("Nhập các phần tử cho mảng:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Hiển thị mảng ban đầu
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));

        // Đảo ngược mảng
        reverseArray(arr);

        // Hiển thị mảng sau khi đảo ngược
        System.out.println("Mảng sau khi đảo ngược: " + Arrays.toString(arr));

        scanner.close();
    }

    public static void reverseArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            // Hoán đổi phần tử đầu và cuối mảng
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }
}

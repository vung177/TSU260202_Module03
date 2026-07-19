package Session04;

import java.util.Scanner;
import java.util.Arrays;

public class exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập kích thước mảng: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Nhập các phần tử cho mảng:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Sắp xếp mảng bằng thuật toán sắp xếp chọn
        selectionSort(arr);

        // In kết quả
        System.out.println("Mảng sau khi sắp xếp theo thứ tự giảm dần: " + Arrays.toString(arr));
        System.out.println("Phần tử lớn nhất trong mảng là: " + arr[0]);

        scanner.close();
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            // Tráo đổi phần tử
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }
    }
}

package Session04;

import java.util.Scanner;
import java.util.Arrays;

public class exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập kích thước mảng: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Nhập các phần tử cho mảng:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Sắp xếp mảng bằng thuật toán nổi bọt (Bubble Sort) theo thứ tự giảm dần
        bubbleSort(arr);

        // In kết quả
        System.out.println("Mảng sau khi sắp xếp theo thứ tự giảm dần: " + Arrays.toString(arr));

        scanner.close();
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Tráo đổi phần tử
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Nếu không có sự hoán đổi nào, mảng đã sắp xếp xong
            if (!swapped) {
                break;
            }
        }
    }
}

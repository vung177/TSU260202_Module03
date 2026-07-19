package Session04;

import java.util.Scanner;

public class exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập kích thước của mảng: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Nhập các giá trị cho mảng");
        for (int i = 0; i < size; i++) {
            System.out.print("Giá trị thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        scanner.close();
        System.out.println("Tổng các phần tử trong mảng: " + sum);
    }
}

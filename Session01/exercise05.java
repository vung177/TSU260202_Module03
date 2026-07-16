package Session01;

import java.util.Scanner;

public class exercise05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập tử số và mẫu số của phân số thứ nhất
        System.out.print("Nhập tử số phân số 1: ");
        int a = scanner.nextInt();
        System.out.print("Nhập mẫu số phân số 1: ");
        int b = scanner.nextInt();

        // Nhập tử số và mẫu số của phân số thứ hai
        System.out.print("Nhập tử số phân số 2: ");
        int c = scanner.nextInt();
        System.out.print("Nhập mẫu số phân số 2: ");
        int d = scanner.nextInt();

        // Tính tổng theo công thức: (a * d + b * c) / (b * d)
        int tongTu = a * d + b * c;
        int tongMau = b * d;

        // In kết quả ra màn hình
        System.out.println("kết quả : " + tongTu + "/" + tongMau);

        scanner.close();
    }
}

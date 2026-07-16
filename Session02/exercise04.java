package Session02;

import java.util.Scanner;

public class exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = -1;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Nhập tuổi của bạn: ");
            String input = scanner.nextLine().trim();

            if (input.matches("\\d+")) {
                age = Integer.parseInt(input);
                if (age > 0) {
                    isValid = true;
                } else {
                    System.out.println("Vui lòng nhập vào một số nguyên và lớn hơn 0");
                }
            } else {
                System.out.println("Vui lòng nhập vào một số nguyên và lớn hơn 0");
            }
        }

        System.out.println("Tuổi của bạn là " + age + " .");

        scanner.close();
    }
}

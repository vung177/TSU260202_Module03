package Session07.exercise03;

import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Khởi tạo đối tượng Person thứ nhất
        System.out.println("--- Nhập thông tin người thứ nhất ---");
        System.out.print("Nhập tên: ");
        String name1 = scanner.nextLine().trim();
        int age1 = 0;
        while (true) {
            System.out.print("Nhập tuổi: ");
            try {
                age1 = Integer.parseInt(scanner.nextLine().trim());
                if (age1 <= 0) {
                    System.out.println("Tuổi phải lớn hơn 0. Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Tuổi không hợp lệ. Vui lòng nhập số nguyên.");
            }
        }
        Person p1 = new Person(name1, age1);

        // Khởi tạo đối tượng Person thứ hai
        System.out.println("\n--- Nhập thông tin người thứ hai ---");
        System.out.print("Nhập tên: ");
        String name2 = scanner.nextLine().trim();
        int age2 = 0;
        while (true) {
            System.out.print("Nhập tuổi: ");
            try {
                age2 = Integer.parseInt(scanner.nextLine().trim());
                if (age2 <= 0) {
                    System.out.println("Tuổi phải lớn hơn 0. Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Tuổi không hợp lệ. Vui lòng nhập số nguyên.");
            }
        }
        Person p2 = new Person(name2, age2);

        // So sánh tuổi của hai đối tượng
        System.out.println("\n--- Kết quả so sánh ---");
        compareAge(p1, p2);

        scanner.close();
    }

    /**
     * So sánh tuổi giữa hai đối tượng Person và in ra kết quả.
     * 
     * @param p1 đối tượng Person thứ nhất
     * @param p2 đối tượng Person thứ hai
     */
    public static void compareAge(Person p1, Person p2) {
        if (p1 == null || p2 == null) {
            return;
        }

        if (p1.getAge() > p2.getAge()) {
            System.out.println(p1.getName() + " (" + p1.getAge() + " tuổi) lớn tuổi hơn " + p2.getName() + " (" + p2.getAge() + " tuổi).");
        } else if (p1.getAge() < p2.getAge()) {
            System.out.println(p2.getName() + " (" + p2.getAge() + " tuổi) lớn tuổi hơn " + p1.getName() + " (" + p1.getAge() + " tuổi).");
        } else {
            System.out.println(p1.getName() + " và " + p2.getName() + " bằng tuổi nhau (" + p1.getAge() + " tuổi).");
        }
    }
}

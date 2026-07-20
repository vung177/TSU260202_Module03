package Session11.exercise01;

import java.util.ArrayList;
import java.util.List;

public class exercise01 {
    public static void main(String[] args) {
        // 1. Tạo một danh sách số nguyên
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(12);
        numbers.add(8);
        numbers.add(23);
        numbers.add(42);
        numbers.add(7);
        numbers.add(16);

        System.out.println("Danh sách số nguyên ban đầu: " + numbers);

        // 2. Sử dụng Lambda Expression để in ra tất cả các số chẵn trong danh sách
        System.out.print("Các số chẵn trong danh sách: ");
        numbers.stream()
               .filter(n -> n % 2 == 0) // Lambda lọc số chẵn
               .forEach(n -> System.out.print(n + " ")); // Lambda in từng số
        System.out.println();

        // 3. Sử dụng Lambda Expression để tính tổng của tất cả các số trong danh sách
        // Sử dụng reduce với Lambda (a, b) -> a + b đại diện cho phép cộng dồn tích lũy
        int sum = numbers.stream()
                         .reduce(0, (a, b) -> a + b);

        System.out.println("Tổng của tất cả các số trong danh sách: " + sum);
    }
}

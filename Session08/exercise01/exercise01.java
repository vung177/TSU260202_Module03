package Session08.exercise01;

import java.util.ArrayList;

public class exercise01 {
    public static void main(String[] args) {
        System.out.println("--- KHỞI TẠO DANH SÁCH ĐỘNG VẬT ---");
        ArrayList<Animals> animalList = new ArrayList<>();

        // Thêm các đối tượng hợp lệ
        animalList.add(new Dog("Kiki", 3, "Poodle"));
        animalList.add(new Cat("Miu", 2, "Trắng"));
        animalList.add(new Dog("Milu", 5, "Becgie"));
        animalList.add(new Cat("Mun", 1, "Đen"));

        // Thêm đối tượng chứa dữ liệu không hợp lệ để kiểm thử cơ chế kiểm tra lỗi
        System.out.println("\n[Kiểm thử kiểm soát lỗi nhập liệu]");
        animalList.add(new Dog("", -2, "Corgi")); // Tên rỗng, tuổi âm
        animalList.add(new Cat("Mimi", -1, "Vàng")); // Tuổi âm
        System.out.println("------------------------------------\n");

        // Duyệt danh sách và hiển thị thông tin
        System.out.println("--- DANH SÁCH THÔNG TIN CHI TIẾT ---");
        for (Animals animal : animalList) {
            // Gọi phương thức displayInfo()
            animal.displayInfo();
            // Gọi phương thức makeSound()
            System.out.println(", Tiếng kêu: " + animal.makeSound());
        }
    }
}

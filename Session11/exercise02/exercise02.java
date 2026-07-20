package Session11.exercise02;

import java.util.Arrays;
import java.util.List;

public class exercise02 {
    public static void main(String[] args) {
        // 1. Tạo một danh sách gồm 10 đối tượng Student
        List<Student> students = Arrays.asList(
            new Student("Nguyễn Văn An", 20, 8.5),
            new Student("Trần Thị Bình", 21, 6.2),
            new Student("Phạm Hồng Cường", 19, 7.8),
            new Student("Lê Hoàng Dũng", 22, 5.5),
            new Student("Đỗ Hương Giang", 20, 9.0),
            new Student("Vũ Thu Hương", 21, 6.8),
            new Student("Bùi Tuấn Khánh", 19, 8.0),
            new Student("Hoàng Phương Lan", 20, 7.2),
            new Student("Phan Văn Minh", 22, 4.8),
            new Student("Ngô Đức Nam", 21, 7.5)
        );

        System.out.println("--- DANH SÁCH SINH VIÊN BAN ĐẦU ---");
        students.forEach(System.out::println);

        // 2 & 3. Sử dụng Streams lọc ra sinh viên có điểm > 7.0 và sắp xếp theo tên
        System.out.println("\n--- SINH VIÊN CÓ ĐIỂM > 7.0 (SẮP XẾP THEO TÊN) ---");
        students.stream()
                .filter(s -> s.getGrade() > 7.0) // Lọc sinh viên điểm > 7.0
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName())) // Sắp xếp theo tên tăng dần
                .forEach(System.out::println); // In danh sách kết quả
    }
}

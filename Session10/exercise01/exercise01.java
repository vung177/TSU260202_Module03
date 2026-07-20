package Session10.exercise01;

import java.util.Scanner;
import java.util.ArrayList;

public class exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        while (true) {
            System.out.println("******************QUẢN LÝ SINH VIÊN****************");
            System.out.println("1. Thêm sinh viên mới");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Lựa chọn phải là số nguyên từ 1 đến 3. Vui lòng nhập lại.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent(scanner, studentList);
                    break;
                case 2:
                    displayStudents(studentList);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lỗi: Lựa chọn không hợp lệ (phải từ 1 đến 3).\n");
                    break;
            }
        }
    }

    /**
     * Thêm sinh viên mới (Có xử lý lỗi nhập liệu bằng try/catch).
     */
    public static void addStudent(Scanner scanner, ArrayList<Student> list) {
        System.out.println("\n--- THÊM SINH VIÊN MỚI ---");
        
        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Tên sinh viên không được để trống. Nhập lại: ");
            name = scanner.nextLine().trim();
        }

        int age = 0;
        while (true) {
            System.out.print("Nhập tuổi sinh viên: ");
            try {
                age = Integer.parseInt(scanner.nextLine().trim());
                if (age <= 0) {
                    // Tự ném ra ngoại lệ IllegalArgumentException nếu tuổi âm/bằng 0
                    throw new IllegalArgumentException("Tuổi phải là số nguyên dương lớn hơn 0.");
                }
                break; // Nhập đúng thì thoát khỏi vòng lặp
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Tuổi phải là số nguyên. Vui lòng nhập lại.");
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }

        double avgScore = 0;
        while (true) {
            System.out.print("Nhập điểm trung bình (0.0 - 10.0): ");
            try {
                avgScore = Double.parseDouble(scanner.nextLine().replace(",", ".").trim());
                if (avgScore < 0 || avgScore > 10) {
                    // Tự ném ngoại lệ nếu điểm nằm ngoài biên
                    throw new IllegalArgumentException("Điểm trung bình phải nằm trong khoảng từ 0.0 đến 10.0.");
                }
                break; // Nhập đúng thì thoát khỏi vòng lặp
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Điểm trung bình phải là một số thực. Vui lòng nhập lại.");
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }

        Student s = new Student(name, age, avgScore);
        list.add(s);
        System.out.println("Thêm sinh viên thành công!\n");
    }

    /**
     * Hiển thị danh sách sinh viên.
     */
    public static void displayStudents(ArrayList<Student> list) {
        System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách trống.\n");
            return;
        }
        for (Student s : list) {
            s.displayRow();
        }
        System.out.println("---------------------------\n");
    }
}

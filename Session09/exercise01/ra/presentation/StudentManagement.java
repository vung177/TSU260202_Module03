package ra.presentation;

import ra.entity.Student;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();

        // Thêm sẵn một vài sinh viên làm dữ liệu mẫu
        studentList.add(new Student("SV001", "Nguyễn Văn A", 20, "Công nghệ thông tin"));
        studentList.add(new Student("SV002", "Trần Thị B", 21, "Quản trị kinh doanh"));
        studentList.add(new Student("SV003", "Lê Văn C", 22, "Công nghệ thông tin"));

        while (true) {
            System.out.println("*********************QUẢN LÝ SINH VIÊN********************");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Cập nhật thông tin sinh viên theo mã sinh viên");
            System.out.println("4. Xóa sinh viên theo mã sinh viên");
            System.out.println("5. Tìm sinh viên theo tên sinh viên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số từ 1 đến 6.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    displayStudents(studentList);
                    break;
                case 2:
                    addStudents(scanner, studentList);
                    break;
                case 3:
                    updateStudent(scanner, studentList);
                    break;
                case 4:
                    deleteStudent(scanner, studentList);
                    break;
                case 5:
                    searchStudentByName(scanner, studentList);
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không chính xác. Vui lòng chọn từ 1 đến 6.\n");
                    break;
            }
        }
    }

    /**
     * 1. Hiển thị danh sách sinh viên.
     */
    public static void displayStudents(ArrayList<Student> list) {
        System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.\n");
            return;
        }
        for (Student s : list) {
            s.displayData();
        }
        System.out.println("---------------------------\n");
    }

    /**
     * 2. Thêm sinh viên (hỗ trợ nhập số lượng để thêm nhiều sinh viên cùng lúc).
     */
    public static void addStudents(Scanner scanner, ArrayList<Student> list) {
        System.out.println("\n--- THÊM SINH VIÊN ---");
        System.out.print("Nhập số lượng sinh viên muốn thêm: ");
        int count = 0;
        try {
            count = Integer.parseInt(scanner.nextLine().trim());
            if (count <= 0) {
                System.out.println("Số lượng sinh viên phải lớn hơn 0.\n");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Số lượng không hợp lệ.\n");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println("\nNhập thông tin cho sinh viên thứ " + (i + 1) + ":");
            Student s = new Student();
            while (true) {
                s.inputData(scanner);
                // Kiểm tra xem ID nhập vào có trùng lặp không
                if (findStudentById(list, s.getStudentId()) != null) {
                    System.out.println("Lỗi: Mã sinh viên \"" + s.getStudentId() + "\" đã tồn tại. Vui lòng nhập lại thông tin sinh viên.");
                    continue;
                }
                break;
            }
            list.add(s);
            System.out.println("Thêm sinh viên thành công!");
        }
        System.out.println();
    }

    /**
     * 3. Cập nhật thông tin sinh viên theo mã sinh viên.
     */
    public static void updateStudent(Scanner scanner, ArrayList<Student> list) {
        System.out.println("\n--- CẬP NHẬT THÔNG TIN SINH VIÊN ---");
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.\n");
            return;
        }

        System.out.print("Nhập mã sinh viên cần cập nhật: ");
        String id = scanner.nextLine().trim();
        Student s = findStudentById(list, id);

        if (s == null) {
            System.out.println("Mã sinh viên không tồn tại\n");
            return;
        }

        System.out.println("Tìm thấy sinh viên. Tiến hành cập nhật:");
        s.inputUpdateData(scanner);
        System.out.println("Cập nhật thông tin sinh viên thành công!\n");
    }

    /**
     * 4. Xóa sinh viên theo mã sinh viên.
     */
    public static void deleteStudent(Scanner scanner, ArrayList<Student> list) {
        System.out.println("\n--- XÓA SINH VIÊN ---");
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.\n");
            return;
        }

        System.out.print("Nhập mã sinh viên cần xóa: ");
        String id = scanner.nextLine().trim();
        Student s = findStudentById(list, id);

        if (s == null) {
            System.out.println("Mã sinh viên không tồn tại\n");
            return;
        }

        list.remove(s);
        System.out.println("Xóa sinh viên có mã \"" + id + "\" thành công!\n");
    }

    /**
     * 5. Tìm sinh viên theo tên sinh viên.
     */
    public static void searchStudentByName(Scanner scanner, ArrayList<Student> list) {
        System.out.println("\n--- TÌM KIẾM SINH VIÊN THEO TÊN ---");
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.\n");
            return;
        }

        System.out.print("Nhập tên sinh viên cần tìm: ");
        String searchName = scanner.nextLine().trim().toLowerCase();

        int count = 0;
        System.out.println("Kết quả tìm kiếm cho \"" + searchName + "\":");
        for (Student s : list) {
            if (s.getStudentName().toLowerCase().contains(searchName)) {
                s.displayData();
                count++;
            }
        }

        System.out.println("Tổng số lượng sinh viên tìm thấy: " + count + "\n");
    }

    /**
     * Helper: Tìm kiếm sinh viên theo ID.
     */
    public static Student findStudentById(ArrayList<Student> list, String id) {
        if (list == null || id == null) {
            return null;
        }
        for (Student s : list) {
            if (s.getStudentId().equalsIgnoreCase(id.trim())) {
                return s;
            }
        }
        return null;
    }
}

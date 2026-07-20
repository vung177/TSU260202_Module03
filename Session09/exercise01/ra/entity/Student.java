package ra.entity;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private String major;

    // Constructor không tham số
    public Student() {
    }

    // Constructor đầy đủ tham số
    public Student(String studentId, String studentName, int age, String major) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.major = major;
    }

    // Getter và Setter
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    // Phương thức nhập đầy đủ thông tin của sinh viên
    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sinh viên: ");
        this.studentId = scanner.nextLine().trim();
        while (this.studentId.isEmpty()) {
            System.out.print("Mã sinh viên không được để trống. Nhập lại: ");
            this.studentId = scanner.nextLine().trim();
        }

        System.out.print("Nhập tên sinh viên: ");
        this.studentName = scanner.nextLine().trim();
        while (this.studentName.isEmpty()) {
            System.out.print("Tên sinh viên không được để trống. Nhập lại: ");
            this.studentName = scanner.nextLine().trim();
        }

        while (true) {
            System.out.print("Nhập tuổi sinh viên: ");
            try {
                this.age = Integer.parseInt(scanner.nextLine().trim());
                if (this.age <= 0) {
                    System.out.println("Tuổi phải lớn hơn 0.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Tuổi không hợp lệ. Vui lòng nhập số nguyên.");
            }
        }

        System.out.print("Nhập chuyên ngành: ");
        this.major = scanner.nextLine().trim();
        while (this.major.isEmpty()) {
            System.out.print("Chuyên ngành không được để trống. Nhập lại: ");
            this.major = scanner.nextLine().trim();
        }
    }

    // Phương thức nhập thông tin để cập nhật (cho phép bỏ qua)
    public void inputUpdateData(Scanner scanner) {
        System.out.print("Nhập tên mới (để trống nếu giữ nguyên \"" + this.studentName + "\"): ");
        String nameInput = scanner.nextLine().trim();
        if (!nameInput.isEmpty()) {
            this.studentName = nameInput;
        }

        while (true) {
            System.out.print("Nhập tuổi mới (để trống nếu giữ nguyên \"" + this.age + "\"): ");
            String ageInput = scanner.nextLine().trim();
            if (ageInput.isEmpty()) {
                break;
            }
            try {
                int newAge = Integer.parseInt(ageInput);
                if (newAge <= 0) {
                    System.out.println("Tuổi phải lớn hơn 0.");
                    continue;
                }
                this.age = newAge;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Tuổi không hợp lệ. Vui lòng nhập số nguyên.");
            }
        }

        System.out.print("Nhập chuyên ngành mới (để trống nếu giữ nguyên \"" + this.major + "\"): ");
        String majorInput = scanner.nextLine().trim();
        if (!majorInput.isEmpty()) {
            this.major = majorInput;
        }
    }

    // Phương thức hiển thị thông tin của sinh viên
    public void displayData() {
        System.out.printf("Mã SV: %-10s | Tên SV: %-20s | Tuổi: %-3d | Chuyên ngành: %s\n", 
                this.studentId, this.studentName, this.age, this.major);
    }
}

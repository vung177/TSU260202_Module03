package Session10.exercise04;

import java.util.ArrayList;

public class AttendanceManager implements Manage<Student> {
    private ArrayList<Student> students;

    // Constructor khởi tạo
    public AttendanceManager() {
        this.students = new ArrayList<>();
    }

    // Getter trả về danh sách
    public ArrayList<Student> getStudents() {
        return this.students;
    }

    // Ghi đè phương thức thêm sinh viên
    @Override
    public void add(Student item) {
        if (item != null) {
            this.students.add(item);
            System.out.println("Thêm sinh viên vào danh sách điểm danh thành công!");
        }
    }

    // Ghi đè phương thức sửa sinh viên theo index
    @Override
    public void update(int index, Student item) {
        if (index < 0 || index >= this.students.size()) {
            System.out.println("Lỗi: Chỉ số (index) " + index + " vượt quá phạm vi danh sách.");
            return;
        }
        if (item != null) {
            this.students.set(index, item);
            System.out.println("Cập nhật thông tin sinh viên tại index " + index + " thành công!");
        }
    }

    // Ghi đè phương thức xóa sinh viên theo index
    @Override
    public void delete(int index) {
        if (index < 0 || index >= this.students.size()) {
            System.out.println("Lỗi: Chỉ số (index) " + index + " vượt quá phạm vi danh sách.");
            return;
        }
        Student removed = this.students.remove(index);
        System.out.println("Đã xóa sinh viên \"" + removed.getName() + "\" khỏi danh sách điểm danh!");
    }

    // Ghi đè phương thức hiển thị danh sách sinh viên kèm chỉ số index
    @Override
    public void display() {
        if (this.students.isEmpty()) {
            System.out.println("Danh sách điểm danh trống.");
        } else {
            for (int i = 0; i < this.students.size(); i++) {
                System.out.println("[" + i + "] " + this.students.get(i));
            }
        }
    }
}

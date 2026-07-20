package Session13.exercise04;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    // Hiển thị danh sách sinh viên
    public void displayStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "{call get_all_students()}";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("full_name");
                LocalDate dob = rs.getDate("date_of_birth").toLocalDate();
                String email = rs.getString("email");
                list.add(new Student(id, name, dob, email));
            }
            System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
            if (list.isEmpty()) {
                System.out.println("Không có sinh viên nào.");
            } else {
                list.forEach(System.out::println);
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Lỗi khi lấy danh sách: " + e.getMessage() + "\n");
        }
    }

    // Thêm sinh viên
    public void addStudent(String fullName, LocalDate dob, String email) {
        String sql = "{call add_student(?, ?, ?)}";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, fullName);
            stmt.setDate(2, java.sql.Date.valueOf(dob));
            stmt.setString(3, email);
            stmt.execute();
            System.out.println("Thêm sinh viên thành công!\n");
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm sinh viên: " + e.getMessage() + "\n");
        }
    }

    // Tìm sinh viên theo tên (chứa)
    public void searchStudent(String nameFragment) {
        String sql = "{call search_student(?)}";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, nameFragment);
            try (ResultSet rs = stmt.executeQuery()) {
                List<Student> results = new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("student_id");
                    String name = rs.getString("full_name");
                    LocalDate dob = rs.getDate("date_of_birth").toLocalDate();
                    String email = rs.getString("email");
                    results.add(new Student(id, name, dob, email));
                }
                System.out.println("\n--- KẾT QUẢ TÌM KIẾM ---");
                if (results.isEmpty()) {
                    System.out.println("Không tìm thấy sinh viên nào phù hợp.");
                } else {
                    results.forEach(System.out::println);
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi tìm kiếm sinh viên: " + e.getMessage() + "\n");
        }
    }

    // Các phương thức đã có ở bài tập 3 để sửa, xóa, tìm kiếm theo ID
    public Student findStudentById(int id) {
        String sql = "{call find_student_by_id(?)}";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("full_name");
                    LocalDate dob = rs.getDate("date_of_birth").toLocalDate();
                    String email = rs.getString("email");
                    return new Student(id, name, dob, email);
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi khi tìm sinh viên: " + e.getMessage());
        }
        return null;
    }

    public void updateStudent(int id, String fullName, LocalDate dob, String email) {
        String sql = "{call update_student(?, ?, ?, ?)}";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, fullName);
            stmt.setDate(3, java.sql.Date.valueOf(dob));
            stmt.setString(4, email);
            stmt.execute();
            System.out.println("Cập nhật sinh viên thành công!\n");
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật: " + e.getMessage() + "\n");
        }
    }

    public void deleteStudent(int id) {
        String sql = "{call delete_student(?)}";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Xóa sinh viên thành công!\n");
        } catch (SQLException e) {
            System.out.println("Lỗi khi xóa: " + e.getMessage() + "\n");
        }
    }
}

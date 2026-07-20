package Session13.exercise02;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    // 1. Gọi get_all_students hiển thị danh sách sinh viên
    public void displayStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "{call get_all_students()}";

        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("full_name");
                java.sql.Date dobSql = rs.getDate("date_of_birth");
                LocalDate dob = dobSql != null ? dobSql.toLocalDate() : LocalDate.now();
                String email = rs.getString("email");
                students.add(new Student(id, name, dob, email));
            }

            System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
            if (students.isEmpty()) {
                System.out.println("Không có sinh viên nào trong danh sách.");
            } else {
                students.forEach(System.out::println);
            }
            System.out.println();

        } catch (SQLException e) {
            System.out.println("Lỗi cơ sở dữ liệu khi lấy danh sách: " + e.getMessage() + "\n");
        }
    }

    // 2. Gọi add_student để thêm sinh viên mới
    public void addStudent(String fullName, LocalDate dob, String email) {
        String sql = "{call add_student(?, ?, ?)}";

        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, fullName);
            stmt.setDate(2, java.sql.Date.valueOf(dob));
            stmt.setString(3, email);

            stmt.execute();
            System.out.println("Thêm mới sinh viên thành công!\n");

        } catch (SQLException e) {
            System.out.println("Lỗi cơ sở dữ liệu khi thêm sinh viên: " + e.getMessage() + "\n");
        }
    }
}

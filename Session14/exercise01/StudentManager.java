package Session14.exercise01;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class StudentManager {
    /**
     * Thêm nhiều sinh viên vào bảng `students` bằng stored procedure `add_students`.
     * Sử dụng transaction để đảm bảo nếu một sinh viên nào đó gây lỗi thì toàn bộ
     * các bản ghi đều được rollback.
     */
    public void addStudents() {
        // Chuẩn bị danh sách sinh viên mẫu (ít nhất 3 sinh viên)
        List<Student> students = new ArrayList<>();
        students.add(new Student("Nguyen Van A", 20));
        students.add(new Student("Tran Thi B", 22));
        students.add(new Student("Le Van C", 19));

        String sql = "{call add_students(?, ?)}"; // stored procedure nhận name, age
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = DatabaseConnection.getConnection();
            // Bắt đầu transaction
            conn.setAutoCommit(false);
            stmt = conn.prepareCall(sql);
            for (Student s : students) {
                stmt.setString(1, s.getName());
                stmt.setInt(2, s.getAge());
                stmt.execute();
            }
            // Nếu mọi thứ chạy tốt, commit
            conn.commit();
            System.out.println("Thêm sinh viên thành công! Đã chèn " + students.size() + " bản ghi.");
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm sinh viên: " + e.getMessage());
            // Rollback nếu có lỗi
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Đã rollback transaction.");
                } catch (SQLException ex) {
                    System.out.println("Lỗi khi rollback: " + ex.getMessage());
                }
            }
        } finally {
            // Đóng tài nguyên
            try { if (stmt != null) stmt.close(); } catch (SQLException ignored) {}
            try { if (conn != null) conn.setAutoCommit(true); conn.close(); } catch (SQLException ignored) {}
        }
    }
}

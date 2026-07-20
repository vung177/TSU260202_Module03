package Session14.exercise02;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class StudentManager {
    /**
     * Cập nhật thông tin sinh viên bằng stored procedure `update_student`.
     * Thực hiện trong một transaction để đảm bảo toàn bộ thay đổi thành công.
     */
    public void updateStudent(int id, String newName, int newAge) {
        String sql = "{call update_student(?, ?, ?)}"; // id, name, age
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); // bắt đầu transaction
            stmt = conn.prepareCall(sql);
            stmt.setInt(1, id);
            stmt.setString(2, newName);
            stmt.setInt(3, newAge);
            stmt.execute();
            conn.commit();
            System.out.println("Cập nhật sinh viên thành công! (ID = " + id + ")");
        } catch (SQLException e) {
            System.out.println("Lỗi khi cập nhật sinh viên: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Đã rollback transaction.");
                } catch (SQLException ex) {
                    System.out.println("Lỗi khi rollback: " + ex.getMessage());
                }
            }
        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException ignored) {}
            try { if (conn != null) conn.setAutoCommit(true); conn.close(); } catch (SQLException ignored) {}
        }
    }
}

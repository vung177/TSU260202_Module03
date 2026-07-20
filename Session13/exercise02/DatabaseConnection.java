package Session13.exercise02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/session13_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    // Danh sách mật khẩu chạy thử tự động để tương thích với máy local của người dùng
    private static final String[] PASSWORDS = {"root", "123456", "1234", "", "admin"};

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Driver tự động đăng ký trong môi trường hiện đại
        }

        SQLException lastException = null;
        for (String password : PASSWORDS) {
            try {
                return DriverManager.getConnection(URL, USER, password);
            } catch (SQLException e) {
                lastException = e;
            }
        }
        // Nếu thử hết tất cả mật khẩu mà vẫn không được thì mới ném lỗi
        throw lastException;
    }
}

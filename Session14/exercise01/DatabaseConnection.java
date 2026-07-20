package Session14.exercise01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/session14_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String[] PASSWORDS = {"root", "123456", "1234", "", "admin"};

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // Driver auto-registered in modern JVMs
        }
        SQLException last = null;
        for (String pw : PASSWORDS) {
            try {
                return DriverManager.getConnection(URL, USER, pw);
            } catch (SQLException e) {
                last = e;
            }
        }
        throw last;
    }
}

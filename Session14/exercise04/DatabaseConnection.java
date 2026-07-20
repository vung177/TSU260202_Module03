package Session14.exercise04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Helper class to obtain a JDBC connection to the Session 14 database.
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/session14_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String[] PASSWORDS = {"", "root", "123456", "1234", "admin"};

    public static Connection getConnection() throws SQLException {
        for (String pwd : PASSWORDS) {
            try {
                Connection conn = DriverManager.getConnection(URL, USER, pwd);
                if (conn != null && !conn.isClosed()) {
                    return conn;
                }
            } catch (SQLException e) {
                // try next password silently
            }
        }
        throw new SQLException("Unable to connect to database with provided credentials.");
    }
}

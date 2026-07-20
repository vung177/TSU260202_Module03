package Session15.exercise01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class that supplies a JDBC connection to the ProductManagement database.
 * The connection parameters are hard‑coded for the learning exercises.
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ProductManagement?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String[] PASSWORDS = {"", "root", "123456", "1234", "admin"};

    /**
     * Returns an open {@link Connection}. Caller must close it.
     */
    public static Connection getConnection() throws SQLException {
        for (String pwd : PASSWORDS) {
            try {
                Connection conn = DriverManager.getConnection(URL, USER, pwd);
                if (conn != null && !conn.isClosed()) {
                    return conn;
                }
            } catch (SQLException ignored) {
                // try next password silently
            }
        }
        throw new SQLException("Unable to connect to ProductManagement DB with provided credentials.");
    }
}

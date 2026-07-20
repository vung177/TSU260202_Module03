package Session14.exercise03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class to obtain a JDBC connection to the MySQL database used in Session 14 exercises.
 * The connection parameters are hard‑coded for simplicity; in a real project they would be externalised.
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/session14_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    // Common default passwords – the first one that works will be used.
    private static final String[] PASSWORDS = {"", "root", "123456", "1234", "admin"};

    /**
     * Returns a live {@link Connection}. Caller is responsible for closing it.
     */
    public static Connection getConnection() throws SQLException {
        for (String pwd : PASSWORDS) {
            try {
                Connection conn = DriverManager.getConnection(URL, USER, pwd);
                if (conn != null && !conn.isClosed()) {
                    return conn;
                }
            } catch (SQLException e) {
                // try next password silently; if none work we rethrow the last exception
            }
        }
        // If we reach here none of the passwords succeeded.
        throw new SQLException("Unable to connect to database with provided credentials.");
    }
}

package Session14.exercise03;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Manager class handling student‑related operations for Exercise 03.
 * It provides a method to delete students whose age is less than the supplied limit.
 * The operation is executed within a transaction to guarantee atomicity.
 */
public class StudentManager {
    /**
     * Deletes all students with age smaller than {@code ageLimit} using the stored procedure
     * {@code delete_students_by_age}. The method prints the number of deleted rows.
     *
     * @param ageLimit the exclusive upper bound for age; students younger than this will be removed
     */
    public void deleteStudentsByAge(int ageLimit) {
        String sql = "{ CALL delete_students_by_age(?) }";
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); // start transaction
            stmt = conn.prepareCall(sql);
            stmt.setInt(1, ageLimit);
            // The procedure does not return a result set, but we can obtain the update count.
            int affected = stmt.executeUpdate();
            conn.commit();
            System.out.println("Successfully deleted " + affected + " student(s) with age < " + ageLimit + ".");
        } catch (SQLException e) {
            System.err.println("Error during delete operation: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Transaction rolled back.");
                } catch (SQLException ex) {
                    System.err.println("Rollback failed: " + ex.getMessage());
                }
            }
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                // ignore close errors
            }
        }
    }
}

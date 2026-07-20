package Session15.exercise01;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object that interacts with the ProductManagement database via stored procedures.
 * All mutating operations are executed inside a transaction to guarantee atomicity.
 */
public class ProductDAO {

    /** Retrieve all products. */
    public List<Product> getAllProducts() throws SQLException {
        List<Product> list = new ArrayList<>();
        String sql = "{ CALL get_all_products() }";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        }
        return list;
    }

    /** Check whether a given catalog exists. Returns true if at least one product uses it. */
    public boolean catalogExists(String catalog) throws SQLException {
        String sql = "{ CALL check_catalog_exists(?, ?) }";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, catalog);
            stmt.registerOutParameter(2, java.sql.Types.INTEGER);
            stmt.execute();
            int count = stmt.getInt(2);
            return count > 0;
        }
    }

    /** Add a new product. Returns generated id (via SELECT LAST_INSERT_ID()). */
    public int addProduct(Product p) throws SQLException {
        String sql = "{ CALL add_product(?, ?, ?, ?, ?, ?) }";
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setString(1, p.getName());
                stmt.setFloat(2, p.getPrice());
                stmt.setString(3, p.getTitle());
                stmt.setDate(4, p.getCreated());
                stmt.setString(5, p.getCatalog());
                stmt.setBoolean(6, p.isStatus());
                stmt.execute();
                // Retrieve generated id
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        p.setId(rs.getInt(1));
                    }
                }
                conn.commit();
                return p.getId();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }

    /** Update existing product by id. */
    public void updateProduct(Product p) throws SQLException {
        String sql = "{ CALL update_product(?, ?, ?, ?, ?, ?, ?) }";
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setInt(1, p.getId());
                stmt.setString(2, p.getName());
                stmt.setFloat(3, p.getPrice());
                stmt.setString(4, p.getTitle());
                stmt.setDate(5, p.getCreated());
                stmt.setString(6, p.getCatalog());
                stmt.setBoolean(7, p.isStatus());
                stmt.execute();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }

    /** Delete product by id. */
    public void deleteProduct(int id) throws SQLException {
        String sql = "{ CALL delete_product(?) }";
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setInt(1, id);
                stmt.execute();
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }

    /** Get product by id. Returns null if not found. */
    public Product getProductById(int id) throws SQLException {
        String sql = "{ CALL get_product_by_id(?) }";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        }
        return null;
    }

    /** Search products by name (partial match). */
    public List<Product> searchByName(String nameFragment) throws SQLException {
        List<Product> list = new ArrayList<>();
        String sql = "{ CALL search_product_by_name(?) }";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, nameFragment);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        }
        return list;
    }

    /** Count products in a given catalog. */
    public int countByCatalog(String catalog) throws SQLException {
        String sql = "{ CALL count_products_by_catalog(?, ?) }";
        try (Connection conn = DatabaseConnection.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, catalog);
            stmt.registerOutParameter(2, java.sql.Types.INTEGER);
            stmt.execute();
            return stmt.getInt(2);
        }
    }

    /** Helper to map a ResultSet row to a Product object. */
    private Product mapRow(ResultSet rs) throws SQLException {
        int id = rs.getInt("Product_Id");
        String name = rs.getString("Product_Name");
        float price = rs.getFloat("Product_Price");
        String title = rs.getString("Product_Title");
        Date created = rs.getDate("Product_created");
        String catalog = rs.getString("Product_catalog");
        boolean status = rs.getBoolean("Product_Status");
        return new Product(id, name, price, title, created, catalog, status);
    }
}

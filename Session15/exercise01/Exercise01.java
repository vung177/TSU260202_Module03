package Session15.exercise01;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Console driver for the Product Management application.
 * Provides a menu matching the specification and delegates all DB work to {@link ProductDAO}.
 */
public class Exercise01 {
    private static final ProductDAO dao = new ProductDAO();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = InputHelper.readInt("Choose an option: ");
            try {
                switch (choice) {
                    case 1:
                        listAllProducts();
                        break;
                    case 2:
                        addProduct();
                        break;
                    case 3:
                        updateProduct();
                        break;
                    case 4:
                        deleteProduct();
                        break;
                    case 5:
                        searchByName();
                        break;
                    case 6:
                        sortByPrice();
                        break;
                    case 7:
                        countByCatalog();
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            }
            System.out.println(); // blank line between operations
        }
    }

    private static void printMenu() {
        System.out.println("********************PRODUCT MANAGEMENT****************");
        System.out.println("1. Danh sách sản phẩm");
        System.out.println("2. Thêm mới sản phẩm");
        System.out.println("3. Cập nhật sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm");
        System.out.println("6. Sắp xếp sản phẩm theo giá tăng dần");
        System.out.println("7. Thống kê số lượng sản phẩm theo danh mục");
        System.out.println("0. Thoát");
    }

    private static void listAllProducts() throws SQLException {
        List<Product> products = dao.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        System.out.println("--- Danh sách sản phẩm ---");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    private static void addProduct() throws SQLException {
        System.out.println("--- Thêm mới sản phẩm ---");
        String name = InputHelper.readString("Tên sản phẩm: ");
        float price = InputHelper.readFloat("Giá sản phẩm (>0): ");
        String title = InputHelper.readString("Tiêu đề sản phẩm: ");
        String createdStr = InputHelper.readString("Ngày tạo (yyyy-MM-dd): ");
        Date created = Date.valueOf(createdStr); // will throw IllegalArgumentException if format wrong
        String catalog = InputHelper.readString("Danh mục sản phẩm: ");
        // status bit defaults to 1 (active). Ask user if they want inactive.
        String statusInput = InputHelper.readString("Trạng thái (1 = active, 0 = inactive) [default 1]: ");
        boolean status = statusInput.isEmpty() || statusInput.equals("1");
        Product p = new Product(name, price, title, created, catalog, status);
        try {
            int generatedId = dao.addProduct(p);
            System.out.println("Thêm thành công. ID mới: " + generatedId);
        } catch (SQLException e) {
            System.err.println("Thêm thất bại: " + e.getMessage());
        }
    }

    private static void updateProduct() throws SQLException {
        System.out.println("--- Cập nhật sản phẩm ---");
        int id = InputHelper.readInt("Nhập ID sản phẩm cần cập nhật: ");
        Product existing = dao.getProductById(id);
        if (existing == null) {
            System.out.println("Không tìm thấy sản phẩm với ID " + id);
            return;
        }
        // Prompt for new values (allow keep old by pressing Enter)
        String name = InputHelper.readString("Tên mới (hiện tại: " + existing.getName() + "): ");
        if (name.isEmpty()) name = existing.getName();
        float price = InputHelper.readFloat("Giá mới (hiện tại: " + existing.getPrice() + "): ");
        String title = InputHelper.readString("Tiêu đề mới (hiện tại: " + existing.getTitle() + "): ");
        if (title.isEmpty()) title = existing.getTitle();
        String createdStr = InputHelper.readString("Ngày tạo mới (yyyy-MM-dd) (hiện tại: " + existing.getCreated() + "): ");
        Date created = createdStr.isEmpty() ? existing.getCreated() : Date.valueOf(createdStr);
        String catalog = InputHelper.readString("Danh mục mới (hiện tại: " + existing.getCatalog() + "): ");
        if (catalog.isEmpty()) catalog = existing.getCatalog();
        String statusInput = InputHelper.readString("Trạng thái (1=active,0=inactive) (hiện tại: " + (existing.isStatus()?"1":"0") + "): ");
        boolean status = statusInput.isEmpty() ? existing.isStatus() : statusInput.equals("1");

        Product updated = new Product(id, name, price, title, created, catalog, status);
        dao.updateProduct(updated);
        System.out.println("Cập nhật thành công.");
    }

    private static void deleteProduct() throws SQLException {
        System.out.println("--- Xóa sản phẩm ---");
        int id = InputHelper.readInt("Nhập ID sản phẩm cần xóa: ");
        dao.deleteProduct(id);
        System.out.println("Xóa thành công (nếu tồn tại).");
    }

    private static void searchByName() throws SQLException {
        System.out.println("--- Tìm kiếm sản phẩm theo tên ---");
        String fragment = InputHelper.readString("Nhập một phần của tên sản phẩm: ");
        List<Product> results = dao.searchByName(fragment);
        if (results.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm nào.");
            return;
        }
        System.out.println("Kết quả tìm kiếm:");
        for (Product p : results) {
            System.out.println(p);
        }
    }

    private static void sortByPrice() throws SQLException {
        System.out.println("--- Sắp xếp sản phẩm theo giá tăng dần ---");
        List<Product> products = dao.getAllProducts();
        Collections.sort(products, Comparator.comparing(Product::getPrice));
        for (Product p : products) {
            System.out.println(p);
        }
    }

    private static void countByCatalog() throws SQLException {
        System.out.println("--- Thống kê số lượng sản phẩm theo danh mục ---");
        String catalog = InputHelper.readString("Nhập tên danh mục: ");
        int count = dao.countByCatalog(catalog);
        System.out.println("Số lượng sản phẩm trong danh mục '" + catalog + "': " + count);
    }
}

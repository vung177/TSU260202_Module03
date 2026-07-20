package Session07.exercise06;

import java.util.Scanner;
import java.util.ArrayList;

public class exercise06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Category> categoryList = new ArrayList<>();

        while (true) {
            System.out.println("******************QUẢN LÝ DANH MỤC****************");
            System.out.println("1. Thêm mới danh mục");
            System.out.println("2. Hiển thị danh sách danh mục");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Tìm kiếm danh mục theo tên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số từ 1 đến 6.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    addCategory(scanner, categoryList);
                    break;
                case 2:
                    displayCategories(categoryList);
                    break;
                case 3:
                    updateCategory(scanner, categoryList);
                    break;
                case 4:
                    deleteCategory(scanner, categoryList);
                    break;
                case 5:
                    searchCategoryByName(scanner, categoryList);
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không chính xác. Vui lòng chọn từ 1 đến 6.\n");
                    break;
            }
        }
    }

    /**
     * Thêm mới danh mục vào danh sách.
     */
    public static void addCategory(Scanner scanner, ArrayList<Category> list) {
        System.out.println("\n--- THÊM MỚI DANH MỤC ---");
        
        String id;
        while (true) {
            System.out.print("Nhập mã danh mục: ");
            id = scanner.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("Mã danh mục không được để trống.");
                continue;
            }
            if (findCategoryById(list, id) != null) {
                System.out.println("Mã danh mục đã tồn tại. Vui lòng nhập mã khác.");
                continue;
            }
            break;
        }

        System.out.print("Nhập tên danh mục: ");
        String name = scanner.nextLine().trim();

        System.out.print("Nhập mô tả danh mục: ");
        String description = scanner.nextLine().trim();

        Category c = new Category(id, name, description);
        list.add(c);
        System.out.println("Thêm danh mục thành công!\n");
    }

    /**
     * Hiển thị toàn bộ danh sách danh mục.
     */
    public static void displayCategories(ArrayList<Category> list) {
        System.out.println("\n--- DANH SÁCH DANH MỤC ---");
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách danh mục trống.\n");
            return;
        }
        for (Category c : list) {
            c.displayRow();
        }
        System.out.println("---------------------------\n");
    }

    /**
     * Cập nhật thông tin danh mục theo ID.
     */
    public static void updateCategory(Scanner scanner, ArrayList<Category> list) {
        System.out.println("\n--- CẬP NHẬT DANH MỤC ---");
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách trống. Không có danh mục nào để cập nhật.\n");
            return;
        }

        System.out.print("Nhập mã danh mục cần cập nhật: ");
        String id = scanner.nextLine().trim();
        Category c = findCategoryById(list, id);

        if (c == null) {
            System.out.println("Không tìm thấy danh mục có mã: " + id + "\n");
            return;
        }

        System.out.print("Nhập tên mới (để trống nếu giữ nguyên \"" + c.getName() + "\"): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            c.setName(newName);
        }

        System.out.print("Nhập mô tả mới (để trống nếu giữ nguyên \"" + c.getDescription() + "\"): ");
        String newDescription = scanner.nextLine().trim();
        if (!newDescription.isEmpty()) {
            c.setDescription(newDescription);
        }

        System.out.println("Cập nhật danh mục thành công!\n");
    }

    /**
     * Xóa danh mục khỏi danh sách theo ID.
     */
    public static void deleteCategory(Scanner scanner, ArrayList<Category> list) {
        System.out.println("\n--- XÓA DANH MỤC ---");
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách trống. Không có danh mục để xóa.\n");
            return;
        }

        System.out.print("Nhập mã danh mục cần xóa: ");
        String id = scanner.nextLine().trim();
        Category c = findCategoryById(list, id);

        if (c == null) {
            System.out.println("Không tìm thấy danh mục có mã: " + id + "\n");
            return;
        }

        list.remove(c);
        System.out.println("Xóa danh mục có mã \"" + id + "\" thành công!\n");
    }

    /**
     * Tìm kiếm danh mục theo tên (chấp nhận khớp một phần và không phân biệt hoa thường).
     */
    public static void searchCategoryByName(Scanner scanner, ArrayList<Category> list) {
        System.out.println("\n--- TÌM KIẾM DANH MỤC ---");
        if (list == null || list.isEmpty()) {
            System.out.println("Danh sách trống.\n");
            return;
        }

        System.out.print("Nhập tên danh mục cần tìm: ");
        String searchName = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        System.out.println("Kết quả tìm kiếm cho \"" + searchName + "\":");
        for (Category c : list) {
            if (c.getName().toLowerCase().contains(searchName)) {
                c.displayRow();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy danh mục nào khớp với tên vừa nhập.");
        }
        System.out.println();
    }

    /**
     * Helper tìm danh mục bằng ID.
     */
    public static Category findCategoryById(ArrayList<Category> list, String id) {
        if (list == null || id == null) {
            return null;
        }
        for (Category c : list) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }
}

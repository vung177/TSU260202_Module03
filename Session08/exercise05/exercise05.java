package Session08.exercise05;

import java.util.Scanner;

public class exercise05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CategoryManagement manager = new CategoryManagement();

        while (true) {
            System.out.println("******************QUẢN LÝ DANH MỤC****************");
            System.out.println("1. Thêm danh mục mới");
            System.out.println("2. Hiển thị tất cả danh mục");
            System.out.println("3. Cập nhật danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số từ 1 đến 5.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    addNewCategoryMenu(scanner, manager);
                    break;
                case 2:
                    displayAllCategoriesMenu(manager);
                    break;
                case 3:
                    updateCategoryMenu(scanner, manager);
                    break;
                case 4:
                    deleteCategoryMenu(scanner, manager);
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không chính xác. Vui lòng chọn từ 1 đến 5.\n");
                    break;
            }
        }
    }

    /**
     * Menu phụ: Thêm danh mục mới.
     */
    private static void addNewCategoryMenu(Scanner scanner, CategoryManagement manager) {
        System.out.println("\n--- THÊM MỚI DANH MỤC ---");
        int id = 0;
        while (true) {
            System.out.print("Nhập mã danh mục (ID là số nguyên): ");
            try {
                id = Integer.parseInt(scanner.nextLine().trim());
                if (id <= 0) {
                    System.out.println("Mã danh mục phải là số nguyên dương lớn hơn 0.");
                    continue;
                }
                if (manager.findById(id) != null) {
                    System.out.println("Mã danh mục đã tồn tại. Vui lòng nhập mã khác.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("ID không hợp lệ. Vui lòng nhập số nguyên.");
            }
        }

        String name;
        while (true) {
            System.out.print("Nhập tên danh mục: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Tên danh mục không được để trống.");
                continue;
            }
            break;
        }

        System.out.print("Nhập mô tả danh mục: ");
        String description = scanner.nextLine().trim();

        Category c = new Category(id, name, description);
        manager.addCategory(c);
        System.out.println();
    }

    /**
     * Menu phụ: Hiển thị tất cả danh mục.
     */
    private static void displayAllCategoriesMenu(CategoryManagement manager) {
        System.out.println("\n--- DANH SÁCH DANH MỤC HIỆN CÓ ---");
        Category[] list = manager.findAll();
        if (list == null || list.length == 0) {
            System.out.println("Danh sách danh mục trống.");
        } else {
            for (Category c : list) {
                c.displayRow();
            }
        }
        System.out.println("----------------------------------\n");
    }

    /**
     * Menu phụ: Cập nhật danh mục.
     */
    private static void updateCategoryMenu(Scanner scanner, CategoryManagement manager) {
        System.out.println("\n--- CẬP NHẬT DANH MỤC ---");
        Category[] list = manager.findAll();
        if (list == null || list.length == 0) {
            System.out.println("Danh sách trống. Không có danh mục nào để cập nhật.\n");
            return;
        }

        int id = 0;
        System.out.print("Nhập mã danh mục cần cập nhật: ");
        try {
            id = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("ID không hợp lệ.\n");
            return;
        }

        Category c = manager.findById(id);
        if (c == null) {
            System.out.println("Không tìm thấy danh mục có ID: " + id + "\n");
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

        manager.updateCategory(c);
        System.out.println();
    }

    /**
     * Menu phụ: Xóa danh mục.
     */
    private static void deleteCategoryMenu(Scanner scanner, CategoryManagement manager) {
        System.out.println("\n--- XÓA DANH MỤC ---");
        Category[] list = manager.findAll();
        if (list == null || list.length == 0) {
            System.out.println("Danh sách trống. Không có danh mục nào để xóa.\n");
            return;
        }

        int id = 0;
        System.out.print("Nhập mã danh mục cần xóa: ");
        try {
            id = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("ID không hợp lệ.\n");
            return;
        }

        manager.deleteById(id);
        System.out.println();
    }
}

package Session08.exercise05;

import java.util.Arrays;

public class CategoryManagement implements ICRUD {
    private Category[] categories;

    // Constructor khởi tạo mảng rỗng
    public CategoryManagement() {
        this.categories = new Category[0];
    }

    // Trả về mảng danh sách danh mục
    @Override
    public Category[] findAll() {
        return this.categories;
    }

    // Thêm danh mục vào danh sách (Sử dụng Arrays.copyOf để tăng kích thước mảng động)
    @Override
    public void addCategory(Category category) {
        if (category == null) {
            return;
        }
        // Kiểm tra xem ID đã tồn tại chưa
        if (findById(category.getId()) != null) {
            System.out.println("Lỗi: Mã danh mục " + category.getId() + " đã tồn tại.");
            return;
        }
        // Mở rộng mảng thêm 1 phần tử
        this.categories = Arrays.copyOf(this.categories, this.categories.length + 1);
        this.categories[this.categories.length - 1] = category;
        System.out.println("Thêm danh mục \"" + category.getName() + "\" thành công!");
    }

    // Cập nhật danh mục trong danh sách
    @Override
    public void updateCategory(Category category) {
        if (category == null) {
            return;
        }
        for (int i = 0; i < this.categories.length; i++) {
            if (this.categories[i].getId() == category.getId()) {
                this.categories[i] = category;
                System.out.println("Cập nhật danh mục thành công!");
                return;
            }
        }
        System.out.println("Lỗi: Không tìm thấy danh mục để cập nhật.");
    }

    // Xóa danh mục khỏi danh sách theo ID (Co nhỏ mảng sau khi xóa phần tử)
    @Override
    public void deleteById(int id) {
        int index = -1;
        for (int i = 0; i < this.categories.length; i++) {
            if (this.categories[i].getId() == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Lỗi: Không tìm thấy danh mục có ID: " + id);
            return;
        }

        // Tạo mảng mới nhỏ hơn 1 phần tử
        Category[] newCategories = new Category[this.categories.length - 1];
        for (int i = 0, k = 0; i < this.categories.length; i++) {
            if (i == index) {
                continue; // Bỏ qua phần tử cần xóa
            }
            newCategories[k++] = this.categories[i];
        }
        this.categories = newCategories;
        System.out.println("Xóa danh mục có ID: " + id + " thành công!");
    }

    // Helper tìm kiếm danh mục theo ID
    public Category findById(int id) {
        for (Category c : this.categories) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}

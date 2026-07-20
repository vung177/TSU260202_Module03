package Session08.exercise05;

public interface ICRUD {
    // Trả về mảng danh sách tất cả các danh mục
    Category[] findAll();

    // Thêm một danh mục mới
    void addCategory(Category category);

    // Cập nhật một danh mục đã tồn tại
    void updateCategory(Category category);

    // Xóa danh mục theo ID
    void deleteById(int id);
}

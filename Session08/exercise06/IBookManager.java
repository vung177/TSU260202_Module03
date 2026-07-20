package Session08.exercise06;

public interface IBookManager {
    // Thêm một quyển sách mới
    void addBook(Book book);

    // Xóa một quyển sách theo mã ISBN
    void removeBook(String isbn);

    // Hiển thị danh sách các quyển sách
    void displayBooks();
}

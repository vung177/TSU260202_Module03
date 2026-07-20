package Session10.exercise04;

public interface Manage<T> {
    // Thêm đối tượng mới
    void add(T item);

    // Cập nhật đối tượng tại vị trí index
    void update(int index, T item);

    // Xóa đối tượng tại vị trí index
    void delete(int index);

    // Hiển thị danh sách các đối tượng
    void display();
}

package Session08.exercise06;

import java.util.Arrays;

public class BookManager implements IBookManager {
    private Book[] books;

    // Constructor khởi tạo mảng rỗng
    public BookManager() {
        this.books = new Book[0];
    }

    // Thêm quyển sách vào danh sách (kiểm tra trùng ISBN và tự động mở rộng mảng)
    @Override
    public void addBook(Book book) {
        if (book == null) {
            return;
        }
        // Kiểm tra xem ISBN đã tồn tại chưa
        if (findBookByIsbn(book.getIsbn()) != null) {
            System.out.println("Lỗi: Mã ISBN \"" + book.getIsbn() + "\" đã tồn tại trong hệ thống.");
            return;
        }
        // Tăng kích thước mảng thêm 1 phần tử
        this.books = Arrays.copyOf(this.books, this.books.length + 1);
        this.books[this.books.length - 1] = book;
        System.out.println("Thêm quyển sách \"" + book.getTitle() + "\" thành công!");
    }

    // Xóa quyển sách khỏi danh sách theo mã ISBN
    @Override
    public void removeBook(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            System.out.println("Lỗi: Mã ISBN không được để trống.");
            return;
        }

        int index = -1;
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i].getIsbn().equalsIgnoreCase(isbn.trim())) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Lỗi: Không tìm thấy quyển sách nào có mã ISBN: " + isbn);
            return;
        }

        // Tạo mảng mới nhỏ hơn 1 phần tử
        Book[] newBooks = new Book[this.books.length - 1];
        for (int i = 0, k = 0; i < this.books.length; i++) {
            if (i == index) {
                continue; // Bỏ qua phần tử cần xóa
            }
            newBooks[k++] = this.books[i];
        }
        this.books = newBooks;
        System.out.println("Xóa quyển sách có mã ISBN \"" + isbn + "\" thành công!");
    }

    // Hiển thị danh sách các quyển sách
    @Override
    public void displayBooks() {
        System.out.println("\n--- DANH SÁCH SÁCH HIỆN CÓ ---");
        if (this.books == null || this.books.length == 0) {
            System.out.println("Danh sách sách trống.");
        } else {
            for (Book b : this.books) {
                System.out.println(b.getDetails());
            }
        }
        System.out.println("-------------------------------\n");
    }

    // Helper tìm kiếm sách bằng ISBN
    public Book findBookByIsbn(String isbn) {
        if (isbn == null) {
            return null;
        }
        for (Book b : this.books) {
            if (b.getIsbn().equalsIgnoreCase(isbn.trim())) {
                return b;
            }
        }
        return null;
    }
}

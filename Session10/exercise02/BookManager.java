package Session10.exercise02;

import java.util.ArrayList;

public class BookManager {
    private ArrayList<Book> books;

    // Constructor khởi tạo
    public BookManager() {
        this.books = new ArrayList<>();
    }

    // Thêm sách mới
    public void addBook(Book book) {
        if (book != null) {
            this.books.add(book);
        }
    }

    // Hiển thị danh sách sách hiện có
    public void displayBooks() {
        if (this.books.isEmpty()) {
            System.out.println("Chưa có sách nào trong danh sách.");
        } else {
            for (Book book : this.books) {
                System.out.println(book);
            }
        }
    }

    // Tìm kiếm sách theo tên (khớp một phần và không phân biệt hoa thường)
    public void searchBookByTitle(String searchTitle) {
        if (this.books.isEmpty()) {
            System.out.println("Danh sách sách trống.");
            return;
        }

        boolean found = false;
        String keyword = searchTitle.trim().toLowerCase();
        System.out.println("Kết quả tìm kiếm cho từ khóa \"" + searchTitle + "\":");
        for (Book book : this.books) {
            if (book.getTitle().toLowerCase().contains(keyword)) {
                System.out.println(book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sách nào khớp với tên tìm kiếm.");
        }
    }
}

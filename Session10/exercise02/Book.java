package Session10.exercise02;

public class Book {
    private String title;
    private String author;
    private int year;

    // Constructor đầy đủ tham số
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Getter cho các thuộc tính
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    // Ghi đè phương thức toString hiển thị chi tiết sách
    @Override
    public String toString() {
        return "Tên sách: " + this.title + " | Tác giả: " + this.author + " | Năm XB: " + this.year;
    }
}

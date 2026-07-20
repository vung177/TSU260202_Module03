package Session08.exercise06;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;

    // Constructor mặc định
    public Book() {
    }

    // Constructor đầy đủ tham số
    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    // Getter và Setter cho các thuộc tính
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Tác giả
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Ghi đè hoặc định nghĩa getIsbn theo yêu cầu đề bài
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Năm xuất bản
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // Trả về thông tin chi tiết của sách dưới dạng chuỗi
    public String getDetails() {
        return "Tên sách: " + this.title + " | Tác giả: " + this.author + " | ISBN: " + this.isbn + " | Năm XB: " + this.year;
    }
}

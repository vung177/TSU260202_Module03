package Session07.exercise02;

public class Book {
    private String title;
    private String author;
    private double price;

    // Constructor mặc định
    public Book() {
    }

    // Constructor có tham số
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        setPrice(price); // Gọi setter để tận dụng cơ chế kiểm tra tính hợp lệ
    }

    // Getter và Setter cho thuộc tính title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter và Setter cho thuộc tính author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter và Setter cho thuộc tính price (kiểm tra giá không được âm)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Lỗi: Giá sách không được phép là số âm!");
        } else {
            this.price = price;
        }
    }

    // Phương thức hiển thị thông tin sách
    public void displayInfo() {
        System.out.println("Tên sách: " + this.title);
        System.out.println("Tác giả : " + this.author);
        System.out.println("Giá sách: " + this.price + " VND");
    }
}

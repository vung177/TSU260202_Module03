package Session07.exercise02;

public class exercise02 {
    public static void main(String[] args) {
        System.out.println("--- Khởi tạo đối tượng Book ---");
        Book book = new Book("Lập trình Java Cơ Bản", "Rikkei Academy", 150000.0);
        book.displayInfo();

        System.out.println("\n--- Thay đổi giá sách thành giá trị hợp lệ (180,000 VND) ---");
        book.setPrice(180000.0);
        System.out.println("Giá sách sau khi cập nhật: " + book.getPrice() + " VND");

        System.out.println("\n--- Thử thay đổi giá sách thành giá trị không hợp lệ (-50,000 VND) ---");
        book.setPrice(-50000.0);
        System.out.println("Giá sách hiện tại: " + book.getPrice() + " VND (vẫn giữ nguyên giá cũ)");
    }
}

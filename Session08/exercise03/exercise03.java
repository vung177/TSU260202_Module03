package Session08.exercise03;

public class exercise03 {
    public static void main(String[] args) {
        System.out.println("--- KHỞI TẠO CÁC HÌNH HỌC ---");
        Circle circle = new Circle(5.0);
        Rectangle rect = new Rectangle(4.0, 6.0);
        Square square = new Square(3.5);

        // Hiển thị trạng thái ban đầu
        circle.display();
        rect.display();
        square.display();

        System.out.println("\n--- THIẾT LẬP MÀU SẮC CHO CÁC HÌNH ---");
        circle.setColor("Đỏ");
        rect.setColor("Xanh lá");
        square.setColor("Xanh dương");

        // Hiển thị trạng thái sau khi tô màu
        circle.display();
        rect.display();
        square.display();
    }
}

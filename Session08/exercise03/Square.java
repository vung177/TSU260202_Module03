package Session08.exercise03;

public class Square implements Colorable {
    private double side;
    private String color;

    // Constructor mặc định
    public Square() {
        this.side = 1.0;
        this.color = "Không màu";
    }

    // Constructor có tham số
    public Square(double side) {
        this.side = (side <= 0) ? 1.0 : side;
        this.color = "Không màu";
    }

    // Getter và Setter cho side
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if (side > 0) {
            this.side = side;
        }
    }

    // Getter cho color
    public String getColor() {
        return color;
    }

    // Triển khai phương thức setColor từ interface Colorable
    @Override
    public void setColor(String color) {
        this.color = (color == null || color.trim().isEmpty()) ? "Không màu" : color;
    }

    // Phương thức hiển thị thông tin
    public void display() {
        System.out.println("Hình Vuông - Cạnh: " + this.side + " | Màu sắc: " + this.color);
    }
}

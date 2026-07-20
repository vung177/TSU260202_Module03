package Session08.exercise01;

public class Cat extends Animals {
    private String furColor;

    // Constructor mặc định
    public Cat() {
        super();
        this.furColor = "Unknown";
    }

    // Constructor có tham số
    public Cat(String name, int age, String furColor) {
        super(name, age);
        this.furColor = (furColor == null || furColor.trim().isEmpty()) ? "Unknown" : furColor;
    }

    // Getter và Setter cho thuộc tính furColor
    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    // Ghi đè phương thức makeSound()
    @Override
    public String makeSound() {
        return "Meow Meow";
    }

    // Ghi đè phương thức displayInfo()
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.print(", Màu lông: " + this.furColor);
    }
}

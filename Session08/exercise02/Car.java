package Session08.exercise02;

public class Car extends Vehicle {
    
    // Constructor mặc định
    public Car() {
        super();
    }

    // Constructor có tham số
    public Car(String name, int speed) {
        super(name, speed);
    }

    // Ghi đè phương thức trừu tượng displayInfo()
    @Override
    public void displayInfo() {
        System.out.println("Xe hơi - Tên: " + getName() + " | Tốc độ tối đa: " + getSpeed() + " km/h");
    }
}

package Session08.exercise02;

public class Bike extends Vehicle {
    
    // Constructor mặc định
    public Bike() {
        super();
    }

    // Constructor có tham số
    public Bike(String name, int speed) {
        super(name, speed);
    }

    // Ghi đè phương thức trừu tượng displayInfo()
    @Override
    public void displayInfo() {
        System.out.println("Xe máy - Tên: " + getName() + " | Tốc độ tối đa: " + getSpeed() + " km/h");
    }
}

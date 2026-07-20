package Session08.exercise02;

public abstract class Vehicle {
    private String name;
    private int speed;

    // Constructor mặc định
    public Vehicle() {
        this.name = "Unknown";
        this.speed = 0;
    }

    // Constructor có tham số
    public Vehicle(String name, int speed) {
        this.name = (name == null || name.trim().isEmpty()) ? "Unknown" : name;
        this.speed = (speed < 0) ? 0 : speed;
    }

    // Getter và Setter cho name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = (name == null || name.trim().isEmpty()) ? "Unknown" : name;
    }

    // Getter và Setter cho speed
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = (speed < 0) ? 0 : speed;
    }

    // Phương thức thông thường
    public void start() {
        System.out.println("Vehicle is starting...");
    }

    // Phương thức trừu tượng
    public abstract void displayInfo();
}

package Session08.exercise01;

public class Animals {
    private String name;
    private int age;

    // Constructor mặc định
    public Animals() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Constructor có tham số
    public Animals(String name, int age) {
        setName(name);
        setAge(age);
    }

    // Getter và Setter cho thuộc tính name (kiểm tra tên trống)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Cảnh báo: Tên động vật không được để trống. Gán mặc định là 'Unknown'.");
            this.name = "Unknown";
        } else {
            this.name = name;
        }
    }

    // Getter và Setter cho thuộc tính age (kiểm tra tuổi âm)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Cảnh báo: Tuổi động vật không được âm. Gán mặc định là 0.");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    // Phương thức phát ra âm thanh chung
    public String makeSound() {
        return "Some generic sound";
    }

    // Phương thức hiển thị thông tin chung
    public void displayInfo() {
        System.out.print("Động vật - Tên: " + this.name + ", Tuổi: " + this.age);
    }
}

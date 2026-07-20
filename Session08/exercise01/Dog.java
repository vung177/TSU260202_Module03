package Session08.exercise01;

public class Dog extends Animals {
    private String breed;

    // Constructor mặc định
    public Dog() {
        super();
        this.breed = "Unknown";
    }

    // Constructor có tham số
    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = (breed == null || breed.trim().isEmpty()) ? "Unknown" : breed;
    }

    // Getter và Setter cho thuộc tính breed
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    // Ghi đè phương thức makeSound()
    @Override
    public String makeSound() {
        return "Woof Woof";
    }

    // Ghi đè phương thức displayInfo()
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.print(", Giống: " + this.breed);
    }
}

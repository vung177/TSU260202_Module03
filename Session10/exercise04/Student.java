package Session10.exercise04;

public class Student {
    private String name;

    // Constructor có tham số
    public Student(String name) {
        this.name = name;
    }

    // Getter và Setter cho name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Ghi đè toString hiển thị thông tin sinh viên
    @Override
    public String toString() {
        return this.name;
    }
}

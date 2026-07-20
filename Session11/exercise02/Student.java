package Session11.exercise02;

public class Student {
    private String name;
    private int age;
    private double grade;

    // Constructor đầy đủ tham số
    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getter và Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    // Ghi đè toString hiển thị thông tin sinh viên
    @Override
    public String toString() {
        return "Tên: " + this.name + " | Tuổi: " + this.age + " | Điểm: " + this.grade;
    }
}

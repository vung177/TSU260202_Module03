package Session07.exercise04;

import java.util.Locale;

public class Student {
    private String name;
    private int age;
    private String className; // Dùng className vì 'class' là từ khóa bảo mật của Java
    private double avgScore;

    // Constructor mặc định
    public Student() {
    }

    // Constructor có tham số
    public Student(String name, int age, String className, double avgScore) {
        this.name = name;
        this.age = age;
        this.className = className;
        this.avgScore = avgScore;
    }

    // Getter và Setter cho thuộc tính name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter và Setter cho thuộc tính age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter và Setter cho thuộc tính className
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    // Getter và Setter cho thuộc tính avgScore
    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    // Hiển thị thông tin sinh viên dưới dạng dòng
    public void displayRow() {
        System.out.printf(Locale.US, "Tên: %-15s | Tuổi: %-2d | Lớp: %-7s | ĐTB: %-4.1f\n", 
                this.name, this.age, this.className, this.avgScore);
    }
}

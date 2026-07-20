package Session10.exercise01;

import java.util.Locale;

public class Student {
    private String name;
    private int age;
    private double avgScore;

    // Constructor không tham số
    public Student() {
    }

    // Constructor đầy đủ tham số
    public Student(String name, int age, double avgScore) {
        this.name = name;
        this.age = age;
        this.avgScore = avgScore;
    }

    // Getter và Setter cho các thuộc tính
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

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    // Hiển thị thông tin sinh viên
    public void displayRow() {
        System.out.printf(Locale.US, "Tên SV: %-20s | Tuổi: %-3d | Điểm TB: %-4.2f\n", 
                this.name, this.age, this.avgScore);
    }
}

package Session11.exercise02;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public void display() {
        // Giữ nguyên định dạng in ấn của code mẫu để đồng bộ
        System.out.printf("| name : %20s | age : %5d | grade : %5f.2 |\n", name, age, grade);
    }
}

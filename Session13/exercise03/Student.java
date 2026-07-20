package Session13.exercise03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {
    private int studentId;
    private String fullName;
    private LocalDate dateOfBirth;
    private String email;

    // Constructor đầy đủ tham số
    public Student(int studentId, String fullName, LocalDate dateOfBirth, String email) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    // Getter và Setter
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Ghi đè toString hiển thị thông tin sinh viên
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "ID: " + this.studentId + 
               " | Họ tên: " + this.fullName + 
               " | Ngày sinh: " + this.dateOfBirth.format(formatter) + 
               " | Email: " + this.email;
    }
}

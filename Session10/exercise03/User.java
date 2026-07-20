package Session10.exercise03;

public class User {
    private String name;
    private String email;
    private String phoneNumber;

    // Constructor đầy đủ tham số
    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getter cho các thuộc tính
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Ghi đè phương thức toString hiển thị chi tiết người dùng
    @Override
    public String toString() {
        return "Tên: " + this.name + " | Email: " + this.email + " | SĐT: " + this.phoneNumber;
    }
}

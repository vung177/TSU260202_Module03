package Session10.exercise03;

import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users;

    // Constructor khởi tạo
    public UserManager() {
        this.users = new ArrayList<>();
    }

    // Thêm người dùng mới (chặn trùng email)
    public void addUser(User user) {
        if (user == null) {
            return;
        }
        if (findUserByEmail(user.getEmail()) != null) {
            System.out.println("Lỗi: Email \"" + user.getEmail() + "\" đã tồn tại trong hệ thống.");
            return;
        }
        this.users.add(user);
        System.out.println("Thêm người dùng thành công!");
    }

    // Xóa người dùng theo mã email
    public void deleteUserByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Lỗi: Email không được để trống.");
            return;
        }
        User user = findUserByEmail(email);
        if (user == null) {
            System.out.println("Lỗi: Không tìm thấy người dùng có email: " + email);
            return;
        }
        this.users.remove(user);
        System.out.println("Xóa người dùng thành công!");
    }

    // Hiển thị danh sách người dùng
    public void displayUsers() {
        if (this.users.isEmpty()) {
            System.out.println("Danh sách người dùng trống.");
        } else {
            for (User user : this.users) {
                System.out.println(user);
            }
        }
    }

    // Helper tìm kiếm người dùng theo email
    public User findUserByEmail(String email) {
        if (email == null) {
            return null;
        }
        for (User user : this.users) {
            if (user.getEmail().equalsIgnoreCase(email.trim())) {
                return user;
            }
        }
        return null;
    }
}

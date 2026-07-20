package Session11.exercise03;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class exercise03 {
    public static void main(String[] args) {
        // Tạo danh sách người dùng
        List<User> users = Arrays.asList(
                new User("alice", "alice@example.com"),
                new User("bob", "bob@example.com"),
                new User("charlie", "charlie@example.com")
        );

        // Tìm kiếm người dùng theo username
        Optional<User> userOptional = findUserByUsername(users, "bob");

        // Sử dụng các phương thức của Optional
        if (userOptional.isPresent()) {
            System.out.println("Người dùng tìm thấy: " + userOptional.get());
        } else {
            System.out.println("Không tìm thấy người dùng.");
        }

        // Sử dụng orElse để cung cấp giá trị mặc định
        User defaultUser = userOptional.orElse(new User("default", "default@example.com"));
        System.out.println("Người dùng (mặc định nếu không tìm thấy): " + defaultUser);

        // Sử dụng ifPresent để thực hiện hành động nếu có giá trị
        userOptional.ifPresent(user -> System.out.println("Email của người dùng: " + user.getEmail()));
    }

    // Phương thức trả về Optional<User>
    private static Optional<User> findUserByUsername(List<User> users, String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }
}

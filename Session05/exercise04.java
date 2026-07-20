package Session05;

import java.util.Scanner;
import java.util.regex.Pattern;

public class exercise04 {
    // Biểu thức chính quy (regex) kiểm tra định dạng email theo tiêu chí đề bài:
    // - Username: chữ cái, chữ số, dấu chấm (.), dấu gạch dưới (_)
    // - Ký tự @
    // - Domain: chữ cái, chữ số, có thể chứa dấu chấm (.)
    // - TLD (đuôi miền): dài 2-6 ký tự, chỉ chứa chữ cái
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,6})+$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập địa chỉ email: ");
        String email = scanner.nextLine().trim();

        // Kiểm tra tính hợp lệ của email
        if (isValidEmail(email)) {
            System.out.println("Email hợp lệ");
        } else {
            System.out.println("Email không hợp lệ");
        }

        scanner.close();
    }

    /**
     * Kiểm tra tính hợp lệ của địa chỉ email bằng biểu thức chính quy.
     * 
     * @param email chuỗi chứa địa chỉ email cần kiểm tra
     * @return true nếu email hợp lệ, ngược lại trả về false.
     */
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return Pattern.matches(EMAIL_REGEX, email);
    }
}

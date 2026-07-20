package Session05;

import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào một chuỗi: ");
        String input = scanner.nextLine();

        // Thực hiện thay thế các ký tự số bằng *
        String result = replaceDigits(input);

        // Hiển thị kết quả
        System.out.println("Chuỗi sau khi thay thế: " + result);

        scanner.close();
    }

    /**
     * Thay thế tất cả các ký tự số (0-9) trong chuỗi bằng ký tự *.
     * 
     * @param text chuỗi văn bản gốc
     * @return chuỗi đã thay thế tất cả ký tự số bằng *
     */
    public static String replaceDigits(String text) {
        if (text == null) {
            return null;
        }
        // Sử dụng regex [0-9] hoặc \\d để khớp với các ký tự số từ 0 đến 9
        return text.replaceAll("[0-9]", "*");
    }
}

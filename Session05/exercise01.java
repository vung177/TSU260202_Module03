package Session05;

import java.util.Scanner;

public class exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào một chuỗi văn bản: ");
        String text = scanner.nextLine();

        System.out.print("Nhập từ cần tìm: ");
        String word = scanner.nextLine();

        // Tìm vị trí của từ trong chuỗi
        int position = findWord(text, word);

        // Hiển thị kết quả
        if (position != -1) {
            System.out.println("Từ \"" + word + "\" xuất hiện tại vị trí đầu tiên là: " + position);
        } else {
            System.out.println("Từ \"" + word + "\" không xuất hiện trong chuỗi văn bản.");
        }

        scanner.close();
    }

    /**
     * Tìm vị trí xuất hiện đầu tiên của một từ trong chuỗi văn bản.
     * 
     * @param text chuỗi văn bản nguồn
     * @param word từ cần tìm kiếm
     * @return vị trí index (0-based) của từ nếu tìm thấy, ngược lại trả về -1.
     */
    public static int findWord(String text, String word) {
        if (text == null || word == null) {
            return -1;
        }
        return text.indexOf(word);
    }
}

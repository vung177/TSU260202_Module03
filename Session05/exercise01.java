package Session05;

import java.util.Scanner;

public class exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào một chuỗi văn bản: ");
        String text = scanner.nextLine().trim();

        System.out.print("Nhập từ cần tìm: ");
        String wordToFind = scanner.nextLine().trim();

        // Tìm vị trí của từ trong chuỗi
        int index = findWord(text, wordToFind);

        // Hiển thị kết quả
        if (index != -1) {
            System.out.println("Từ \"" + wordToFind + "\" xuất hiện tại vị trí đầu tiên là: " + index);
        } else {
            System.out.println("Từ \"" + wordToFind + "\" không xuất hiện trong chuỗi văn bản.");
        }

        scanner.close();
    }

    /**
     * Tìm vị trí xuất hiện đầu tiên của một từ trong chuỗi văn bản.
     * 
     * @param text chuỗi văn bản nguồn
     * @param wordToFind từ cần tìm kiếm
     * @return vị trí index (0-based) của từ nếu tìm thấy, ngược lại trả về -1.
     */
    public static int findWord(String text, String wordToFind) {
        if (text == null || wordToFind == null) {
            return -1;
        }
        return text.indexOf(wordToFind);
    }
}

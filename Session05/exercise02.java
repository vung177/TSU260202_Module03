package Session05;

public class exercise02 {
    public static void main(String[] args) {
        String original = "Hello, Java World!";
        System.out.println("Chuỗi ban đầu: " + original);

        StringBuilder sb = new StringBuilder(original);

        // Thao tác 1: Xóa các ký tự từ vị trí 5 đến 9 trong chuỗi (sử dụng hàm delete)
        deleteSubstring(sb, 5, 10);
        System.out.println("Chuỗi sau khi xóa: " + sb.toString());

        // Thao tác 2: Thay thế đoạn "World" bằng "Universe"
        replaceSubstring(sb, "World", "Universe");
        System.out.println("Chuỗi sau khi thay thế: " + sb.toString());
    }

    /**
     * Xóa một đoạn chuỗi con trong StringBuilder từ vị trí start đến end.
     * 
     * @param sb đối tượng StringBuilder cần thao tác
     * @param start vị trí bắt đầu xóa (inclusive)
     * @param end vị trí kết thúc xóa (exclusive)
     */
    public static void deleteSubstring(StringBuilder sb, int start, int end) {
        if (sb != null && start >= 0 && end <= sb.length() && start <= end) {
            sb.delete(start, end);
        }
    }

    /**
     * Thay thế một đoạn chuỗi con bằng chuỗi mới trong StringBuilder.
     * 
     * @param sb đối tượng StringBuilder cần thao tác
     * @param target chuỗi cần được thay thế
     * @param replacement chuỗi mới thay thế vào
     */
    public static void replaceSubstring(StringBuilder sb, String target, String replacement) {
        if (sb == null || target == null || replacement == null) {
            return;
        }
        int startIdx = sb.indexOf(target);
        if (startIdx != -1) {
            sb.replace(startIdx, startIdx + target.length(), replacement);
        }
    }
}

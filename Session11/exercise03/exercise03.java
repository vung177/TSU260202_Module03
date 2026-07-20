package Session11.exercise03;

import java.time.LocalDate;
import java.util.Scanner;

public class exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChatManager manager = new ChatManager();

        // Nạp sẵn một số tin nhắn làm mẫu với các ngày khác nhau để phục vụ kiểm thử tính năng lọc
        manager.sendMessage(new Message("Alice", "Chào mọi người!", LocalDate.of(2026, 7, 19)));
        manager.sendMessage(new Message("Bob", "Hello Alice, khỏe không?", LocalDate.of(2026, 7, 19)));
        manager.sendMessage(new Message("Alice", "Hôm nay mình học bài Java Stream nhé.", LocalDate.of(2026, 7, 20)));
        manager.sendMessage(new Message("Charlie", "Tuyệt vời, cho mình tham gia học với!", LocalDate.of(2026, 7, 20)));

        while (true) {
            System.out.println("******************ỨNG DỤNG CHAT CONSOLE****************");
            System.out.println("1. Gửi tin nhắn mới (Tự động lưu ngày hôm nay)");
            System.out.println("2. Xem toàn bộ lịch sử chat");
            System.out.println("3. Lọc tin nhắn theo người gửi");
            System.out.println("4. Lọc tin nhắn theo ngày (dd/MM/yyyy)");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Lựa chọn phải là số nguyên từ 1 đến 5. Vui lòng nhập lại.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n--- GỬI TIN NHẮN ---");
                    String sender = InputData.getString(scanner, "Nhập tên người gửi: ");
                    String content = InputData.getString(scanner, "Nhập nội dung tin nhắn: ");
                    manager.sendMessage(new Message(sender, content));
                    System.out.println("Gửi tin nhắn thành công!\n");
                    break;
                case 2:
                    System.out.println("\n--- LỊCH SỬ CHAT ---");
                    manager.displayHistory();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("\n--- LỌC THEO NGƯỜI GỬI ---");
                    String searchSender = InputData.getString(scanner, "Nhập tên người gửi cần lọc: ");
                    manager.filterBySender(searchSender);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("\n--- LỌC THEO NGÀY ---");
                    // getLocalDate có sẵn cơ chế bắt lỗi try-catch cho định dạng ngày
                    LocalDate searchDate = InputData.getLocalDate(scanner, "Nhập ngày cần lọc (dd/MM/yyyy): ");
                    manager.filterByDate(searchDate);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lỗi: Lựa chọn không hợp lệ (phải từ 1 đến 5).\n");
                    break;
            }
        }
    }
}

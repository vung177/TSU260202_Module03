package Session11.exercise03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ChatManager {
    private List<Message> messages;

    // Constructor khởi tạo
    public ChatManager() {
        this.messages = new ArrayList<>();
    }

    // Gửi tin nhắn mới
    public void sendMessage(Message msg) {
        if (msg != null) {
            this.messages.add(msg);
        }
    }

    // Hiển thị lịch sử chat
    public void displayHistory() {
        if (this.messages.isEmpty()) {
            System.out.println("Chưa có tin nhắn nào trong lịch sử.");
        } else {
            this.messages.forEach(System.out::println);
        }
    }

    // Lọc tin nhắn theo tên người gửi (sử dụng Streams)
    public void filterBySender(String senderName) {
        if (this.messages.isEmpty()) {
            System.out.println("Lịch sử chat trống.");
            return;
        }

        String keyword = senderName.trim().toLowerCase();
        List<Message> result = this.messages.stream()
                .filter(msg -> msg.getSender().toLowerCase().contains(keyword))
                .toList();

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy tin nhắn nào từ người gửi \"" + senderName + "\".");
        } else {
            System.out.println("Kết quả lọc từ người gửi \"" + senderName + "\":");
            result.forEach(System.out::println);
        }
    }

    // Lọc tin nhắn theo ngày chỉ định (sử dụng Streams)
    public void filterByDate(LocalDate date) {
        if (this.messages.isEmpty()) {
            System.out.println("Lịch sử chat trống.");
            return;
        }

        List<Message> result = this.messages.stream()
                .filter(msg -> msg.getTimestamp().isEqual(date))
                .toList();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (result.isEmpty()) {
            System.out.println("Không tìm thấy tin nhắn nào gửi ngày " + date.format(formatter) + ".");
        } else {
            System.out.println("Kết quả lọc vào ngày " + date.format(formatter) + ":");
            result.forEach(System.out::println);
        }
    }
}

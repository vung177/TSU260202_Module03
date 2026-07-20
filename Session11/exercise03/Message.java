package Session11.exercise03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Message {
    private String sender;
    private String content;
    private LocalDate timestamp;

    // Constructor tự động lấy ngày hiện tại
    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDate.now();
    }

    // Constructor đầy đủ tham số
    public Message(String sender, String content, LocalDate timestamp) {
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }

    // Getter và Setter
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    // Ghi đè phương thức toString hiển thị chi tiết tin nhắn
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "[" + this.timestamp.format(formatter) + "] " + this.sender + ": " + this.content;
    }
}

package Session08.exercise05;

public class Category {
    private int id;
    private String name;
    private String description;

    // Constructor không tham số
    public Category() {
    }

    // Constructor full tham số
    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getter và Setter cho id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter và Setter cho name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter và Setter cho description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Phương thức hiển thị dòng thông tin danh mục
    public void displayRow() {
        System.out.printf("Mã DM: %-5d | Tên DM: %-20s | Mô tả: %s\n", 
                this.id, this.name, this.description);
    }
}

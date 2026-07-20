package Session07.exercise06;

public class Category {
    private String id;
    private String name;
    private String description;

    // Constructor mặc định
    public Category() {
    }

    // Constructor có tham số
    public Category(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getter và Setter cho thuộc tính id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter và Setter cho thuộc tính name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter và Setter cho thuộc tính description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Hiển thị thông tin danh mục dưới dạng dòng
    public void displayRow() {
        System.out.printf("Mã DM: %-10s | Tên DM: %-20s | Mô tả: %s\n", 
                this.id, this.name, this.description);
    }
}

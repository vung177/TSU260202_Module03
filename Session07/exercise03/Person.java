package Session07.exercise03;

public class Person {
    private String name;
    private int age;

    // Constructor mặc định
    public Person() {
    }

    // Constructor có tham số
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter và Setter cho thuộc tính name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter và Setter cho thuộc tính age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

package Session08.exercise02;

public class exercise02 {
    public static void main(String[] args) {
        System.out.println("--- KHỞI TẠO CÁC PHƯƠNG TIỆN ---");
        Vehicle myCar = new Car("Audi R8", 320);
        Vehicle myBike = new Bike("Honda SH", 120);

        // Gọi phương thức start()
        System.out.println("\n[Kiểm thử phương thức start()]");
        myCar.start();
        myBike.start();

        // Gọi phương thức displayInfo()
        System.out.println("\n[Kiểm thử phương thức displayInfo()]");
        myCar.displayInfo();
        myBike.displayInfo();
    }
}

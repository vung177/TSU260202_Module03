package Session01;

public class exercise04 {
    public static void main(String[] args) {
        // Khai báo hai số nguyên a và b và khởi tạo các giá trị bất kỳ
        int a = 10;
        int b = 5;

        // Thực hiện các phép toán
        int tong = a + b;
        int hieu = a - b;
        int tich = a * b;
        int thuong = a / b;
        int du = a % b;

        // In giá trị 2 biến a, b và kết quả các phép tính ra màn hình
        System.out.println("a = " + a + " và b = " + b);
        System.out.println("Tổng 2 số a+b = " + tong);
        System.out.println("Hiệu 2 số a-b = " + hieu);
        System.out.println("Tích 2 số a*b = " + tich);
        System.out.println("Thương 2 số a/b = " + thuong);
        System.out.println("Số dư khi chia số a cho b = " + du);
    }
}

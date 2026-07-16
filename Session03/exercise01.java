package Session03;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========= NHẬP THÔNG TIN HÓA ĐƠN =========");
        System.out.print("Nhập tên khách hàng: ");
        String customerName = scanner.nextLine().trim();

        System.out.print("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine().trim();

        System.out.print("Nhập giá sản phẩm: ");
        String priceInput = scanner.nextLine().replace(".", "").trim();
        double price = Double.parseDouble(priceInput);

        System.out.print("Nhập số lượng mua: ");
        String qtyInput = scanner.nextLine().replace(".", "").trim();
        int quantity = Integer.parseInt(qtyInput);

        System.out.print("Khách có thẻ thành viên? (true/false): ");
        String memberInput = scanner.nextLine().trim();
        boolean isMember = Boolean.parseBoolean(memberInput);

        // Tính toán các giá trị
        double subtotal = price * quantity;
        double discount = isMember ? subtotal * 0.1 : 0;
        double vat = subtotal * 0.08;
        double total = subtotal - discount + vat;

        // In kết quả theo đúng định dạng
        System.out.println("============= HÓA ĐƠN =============");
        System.out.println("Khách hàng: " + customerName);
        System.out.println("Sản phẩm : " + productName);
        System.out.println("Số lượng : " + quantity);
        System.out.println("Đơn giá   : " + formatCurrency(price) + " VND");
        System.out.println("Thành tiền: " + formatCurrency(subtotal) + " VND");
        System.out.println("Giảm giá thành viên (10%): " + formatCurrency(discount));
        System.out.println("Tiền VAT (8%):   " + formatCurrency(vat) + " VND");
        System.out.println("Tổng thanh toán: " + formatCurrency(total) + " VND");
        System.out.println("========================================");

        scanner.close();
    }

    public static String formatCurrency(double amount) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
        return df.format(amount);
    }
}

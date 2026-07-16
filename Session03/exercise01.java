package Session03;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tên khách hàng: ");
        String customerName = scanner.nextLine().trim();

        System.out.print("Sản phẩm: ");
        String productName = scanner.nextLine().trim();

        System.out.print("Giá: ");
        String priceInput = scanner.nextLine().replace(".", "").trim();
        double price = Double.parseDouble(priceInput);

        System.out.print("Số lượng: ");
        String qtyInput = scanner.nextLine().replace(".", "").trim();
        int quantity = Integer.parseInt(qtyInput);

        System.out.print("Thẻ thành viên: ");
        String memberInput = scanner.nextLine().trim();
        boolean isMember = Boolean.parseBoolean(memberInput);

        // Tính toán các giá trị
        double subtotal = price * quantity;
        double discount = isMember ? subtotal * 0.1 : 0;
        double vat = subtotal * 0.08;
        double total = subtotal - discount + vat;

        // In kết quả
        System.out.println("Khách hàng: " + customerName);
        System.out.println("Sản phẩm: " + productName);
        System.out.println("Giá: " + formatCurrency(price) + " VND");
        System.out.println("Số lượng: " + quantity);
        System.out.println("Thành tiền: " + formatCurrency(subtotal) + " VND");
        System.out.println("Giảm giá: " + (discount > 0 ? formatCurrency(discount) : "0"));
        System.out.println("Tiền VAT: " + formatCurrency(vat) + " VND");
        System.out.println("Tổng thanh toán: " + formatCurrency(total) + " VND");

        scanner.close();
    }

    public static String formatCurrency(double amount) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,##0", symbols);
        return df.format(amount);
    }
}

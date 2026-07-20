package Session08.exercise04;

public class exercise04 {
    public static void main(String[] args) {
        System.out.println("--- KHỞI TẠO CÁC TÀI KHOẢN NGÂN HÀNG ---");
        BankAccount accA = new BankAccount("TK_A01", 1000000.0, "Nguyễn Văn A", "0987654321");
        BankAccount accB = new BankAccount("TK_B02", 200000.0, "Trần Thị B", "0912345678");

        System.out.println("Trạng thái số dư trước khi chuyển tiền:");
        accA.displayBalance();
        accB.displayBalance();

        System.out.println("\n--- THỰC HIỆN CHUYỂN TIỀN (300,000 VND từ A sang B) ---");
        transfer(accA, accB, 300000.0);

        System.out.println("\nTrạng thái số dư sau khi chuyển tiền thành công:");
        accA.displayBalance();
        accB.displayBalance();

        System.out.println("\n--- THỰC HIỆN CHUYỂN TIỀN LỖI (Thử chuyển 1,000,000 VND từ A sang B) ---");
        transfer(accA, accB, 1000000.0);

        System.out.println("\nTrạng thái số dư hiện tại:");
        accA.displayBalance();
        accB.displayBalance();
    }

    /**
     * Phương thức thực hiện giao dịch chuyển tiền từ tài khoản nguồn sang tài khoản đích.
     * 
     * @param fromAcc tài khoản nguồn
     * @param toAcc tài khoản đích
     * @param amount số tiền chuyển
     */
    public static void transfer(BankAccount fromAcc, BankAccount toAcc, double amount) {
        if (fromAcc == null || toAcc == null) {
            System.out.println("Lỗi: Tài khoản không tồn tại.");
            return;
        }

        if (amount <= 0) {
            System.out.println("Lỗi: Số tiền chuyển phải lớn hơn 0 VND.");
            return;
        }

        if (fromAcc.getBalance() < amount) {
            System.out.println("Lỗi: Tài khoản nguồn \"" + fromAcc.getAccountId() + "\" không đủ số dư để thực hiện giao dịch này.");
            return;
        }

        // Trừ tiền tài khoản nguồn
        fromAcc.withdraw(amount);
        // Cộng tiền vào tài khoản đích
        toAcc.deposit(amount);
        System.out.println("Giao dịch chuyển khoản thành công!");
    }
}

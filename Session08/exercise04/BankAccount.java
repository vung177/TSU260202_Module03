package Session08.exercise04;

import java.util.Locale;

public class BankAccount implements IBank {
    private String accountId;
    private double balance;
    private String userName;
    private String phoneNumber;

    // Constructor mặc định
    public BankAccount() {
    }

    // Constructor có tham số
    public BankAccount(String accountId, double balance, String userName, String phoneNumber) {
        this.accountId = accountId;
        this.balance = (balance < 0) ? 0 : balance;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
    }

    // Getter và Setter cho các thuộc tính
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = (balance < 0) ? 0 : balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Triển khai phương thức deposit (nạp tiền)
    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Lỗi: Số tiền nạp phải lớn hơn 0 VND.");
            return;
        }
        this.balance += amount;
    }

    // Triển khai phương thức withdraw (rút tiền)
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Lỗi: Số tiền rút phải lớn hơn 0 VND.");
            return;
        }
        if (amount > this.balance) {
            System.out.println("Lỗi: Số dư tài khoản không đủ để thực hiện giao dịch.");
            return;
        }
        this.balance -= amount;
    }

    // Phương thức hiển thị số dư tài khoản
    public void displayBalance() {
        System.out.printf(Locale.US, "TK: %s | Chủ TK: %-15s | Số dư: %,.2f VND\n", 
                this.accountId, this.userName, this.balance);
    }
}

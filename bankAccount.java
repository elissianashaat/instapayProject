package BankAPI;

public class bankAccount {
    String bankName;
    private long bankAccNumber;
    private double balance;
    private String mobileNumber;
    String userName;

    public bankAccount(String BankName,double Balance, long AccNumber, String Number, String UserName) {
        bankName = BankName;
        bankAccNumber = AccNumber;
        balance = Balance;
        mobileNumber = Number;
        userName = UserName;
    }

    public double getBalance() {
        return balance;
    }

    public long getBankAccNumber() {
        return bankAccNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setBalance(double Balance, char Char) {
        if (Char == '+') {
            balance += Balance;
        } else if (Char == '-') {
            balance -= Balance;

        }
    }
}

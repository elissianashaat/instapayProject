package WalletAPI;

public class walletAccount {
    String walletProviderName;
    private double balance;
    private String mobileNumber;
    String userName;
    public walletAccount(String WalletProvider,double Balance,String Number,String Username){
        walletProviderName=WalletProvider;
        balance=Balance;
        mobileNumber=Number;
        userName=Username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getUserName() {
        return userName;
    }

    public double getBalance() {
        return balance;
    }

    public String getWalletProviderName() {
        return walletProviderName;
    }

    public void setBalance(double Balance,char Char) {
        if(Char=='-'){
            balance-=Balance;
        }
        else {
            balance+=Balance;
        }
    }
}

package SignUp;
import WalletAPI.walletAccount;

public class WalletAccProfile extends User{
    walletAccount WalletAccount;
    public void setWalletAccount(walletAccount account)
    {
        WalletAccount=account;
    }
    public walletAccount getWalletAccount()
    {
        return WalletAccount;
}

    @Override
    public void setAccountBalance(double b, char c) {
        if(c=='+'){
        WalletAccount.setBalance(b,'+');
        }
        else{
            WalletAccount.setBalance(b,'-');
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Account Type: "+getType());
        System.out.println("Username: "+getUsername());
        System.out.println("Mobile Number: "+getMobileNumber());
        System.out.println("Balance: "+getBalance());
        System.out.println("Wallet Account Number: "+getWalletAccount().getMobileNumber());
    }
}

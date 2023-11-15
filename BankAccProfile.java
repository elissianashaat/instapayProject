package SignUp;

import BankAPI.bankAccount;

public class BankAccProfile extends User{
    bankAccount account;
    public void setAccount(bankAccount acc)
    {
        account=acc;

    }
    public bankAccount getAccount()
    {
        return account;
    }

    @Override
    public void setAccountBalance(double b, char c) {
        if(c=='-'){
            account.setBalance(b,'-');
        }
        else{
            account.setBalance(b,'+');
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Account Type: "+getType());
        System.out.println("Username: "+getUsername());
        System.out.println("Mobile Number: "+getMobileNumber());
        System.out.println("Balance: "+getBalance());
        System.out.println("Bank Account Number: "+getAccount().getBankAccNumber());
    }
}

package WalletAPI;

import java.util.Vector;

public class WalletAPI {
    private Vector<walletAccount> walletAccounts=new Vector<walletAccount>();
    public boolean checkAccValid(String WalletAccount){
        for (int i=0;i<walletAccounts.size();i++){
            if(WalletAccount.equals(walletAccounts.get(i).getMobileNumber())){
                return true;
            }
        }
        return false;
    }
    public boolean checkBalance(walletAccount WalletAccount,double Balance){
        for (int i=0;i<walletAccounts.size();i++){
            if(WalletAccount==walletAccounts.get(i)){
                if(walletAccounts.get(i).getBalance()>=Balance){
                    return true;
                }
            }
        }
        return false;
    }
    public void updateBalance(walletAccount WalletAccount,double Balance,char Char){
        for (int i=0;i<walletAccounts.size();i++){
            if(WalletAccount.getMobileNumber().equals(walletAccounts.get(i).getMobileNumber())){


                if(Char=='-'){
                    if(checkBalance(walletAccounts.get(i),Balance)){
                        walletAccounts.get(i).setBalance(Balance,Char);
                        notify(Char);
                        return;
                    }
                    else{
                        System.out.println("Insufficient Balance");
                        return;
                    }

                }
                else{
                    walletAccounts.get(i).setBalance(Balance,Char);

                    notify(Char);
                    return;
                }
            }
        }
        System.out.println("Unsuccessful Transaction");
    }
    public void notify(char Char){
        if(Char=='-'){
            System.out.println("Wallet has successfully withdrawn balance from your account");
        }
        else{
            System.out.println("Wallet has successfully deposited balance into your account");
        }
    }

    public void setWalletAccounts(Vector<walletAccount> walletAccounts) {
        this.walletAccounts = walletAccounts;
    }

    public Vector<walletAccount> getWalletAccounts() {
        return walletAccounts;
    }
}

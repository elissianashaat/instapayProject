package Transaction;
import SignUp.User;
import WalletAPI.*;

import java.util.Vector;

public class WalletTransfer extends transactionsStrategy{
    WalletAPI walletapi;

    @Override
    public Vector<User> transfer(Vector<User> users) {
        int user=0,receiver=-1;
        for (int i = 0; i < users.size(); i++) {
            if(getSender()==users.get(i)){
                if(users.get(i).getBalance()>=getPaymentAmount()){
                    user=i;
                }
                else {
                    System.out.println("Insufficient Balance");
                    return users;
                }
            }
        }
        for (int i = 0; i < walletapi.getWalletAccounts().size(); i++) {
            if(getReciever().equals(walletapi.getWalletAccounts().get(i).getMobileNumber())){
                receiver=i;
            }
        }
        users.get(user).setBalance(getPaymentAmount(),'-');
        walletapi.updateBalance(walletapi.getWalletAccounts().get(receiver),getPaymentAmount(),'+');
        System.out.println("Successful Transaction");
        return users;

    }

    public void setWalletapi(WalletAPI walletapi) {
        this.walletapi = walletapi;
    }

    public WalletAPI getWalletapi() {
        return walletapi;
}

}

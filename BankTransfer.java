package Transaction;

import SignUp.User;

import java.util.Vector;
import BankAPI.*;

public class BankTransfer extends transactionsStrategy{
    BankAPI bankapi;

    @Override
    public Vector<User> transfer(Vector<User> users) {
        int user=0,receiver=-1;
        for (int i = 0; i < users.size(); i++) {
            if(getSender().equals(users.get(i))){
                if(users.get(i).getBalance()>=getPaymentAmount()){
                    users.get(i).setBalance(getPaymentAmount(),'-');
                    user=i;
                }
                else {
                    System.out.println("Insufficient Balance");
                    return users;
                }
            }
        }
        for (int i = 0; i < bankapi.getBankAccounts().size(); i++) {
            if(getReciever().equals(bankapi.getBankAccounts().get(i).getMobileNumber())){
                receiver=i;
            }
            else{
                System.out.println("Reciever not found");
                return users;
            }
        }
        users.get(user).setBalance(getPaymentAmount(),'-');
        bankapi.updateBalance(bankapi.getBankAccounts().get(receiver),getPaymentAmount(),'+');
        System.out.println("Successful Transaction");
        return users;
    }
    public BankAPI getBankapi() {
        return bankapi;
    }

    public void setBankapi(BankAPI bankapi) {
        this.bankapi = bankapi;
}

}

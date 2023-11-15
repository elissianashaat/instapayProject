
import SignUp.User;

import java.util.Vector;

public class InstaPayTransfer extends transactionsStrategy{

    public Vector<User> transfer(Vector<User> users) {
        int user=0,receiver=-1;
        for (int i = 0; i < users.size(); i++) {
            if((getSender().getUsername().equals(users.get(i).getUsername())) && (getSender().getPassword().equals(users.get(i).getPassword()))){
                if(users.get(i).getBalance()>=getPaymentAmount()){
                    System.out.println("Sufficient Balance");
                    user=i;
                    break;
                }
                else {
                    System.out.println("Insufficient Balance");
                    return users;
                }
            }
        }
        for (int j = 0; j < users.size(); j++) {
            if((getReciever().equals(users.get(j).getMobileNumber()))){
                receiver=j;
                break;
            }
        }
        if(receiver==-1){
            System.out.println("Receiver not found");
            return users;
        }
        users.get(user).setBalance(getPaymentAmount(),'-');
        users.get(receiver).setBalance(getPaymentAmount(),'+');
        System.out.println("Successful Transaction");
        return users;
    }
}

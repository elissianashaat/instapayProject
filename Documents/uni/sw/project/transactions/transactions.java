import SignUp.User;

import java.util.Vector;

public class transaction {
    transactionsStrategy transactions;

    public void setTransactions(transactionsStrategy transactions) {
        this.transactions = transactions;
    }

    public Vector<User> transfer(Vector<User> users){
        return transactions.transfer(users);
    }

}

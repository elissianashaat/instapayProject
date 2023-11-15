
import SignUp.User;

import java.util.Vector;

public abstract class transactionsStrategy {
    private User sender;
    private String reciever;
    private double paymentAmount;

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public abstract Vector<User> transfer(Vector<User> users);


    public double getPaymentAmount() {
        return paymentAmount;
    }

    public User getSender() {
        return sender;
    }

    public String getReciever() {
        return reciever;
    }

}

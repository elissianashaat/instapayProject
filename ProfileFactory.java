package SignUp;

public class ProfileFactory {
    public User signUp(String type) {
        User user;
        String userType = type.toLowerCase();

        if (userType.equals("bank account"))
        {
            user = new BankAccProfile();
        }
        else
        {
            user = new WalletAccProfile();
        }
        return user;
}

}

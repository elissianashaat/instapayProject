package SignUp;

public class BankAccProfile extends User
{
    bankAccount account;
    public void setAccount(bankAccount acc)
    {
        account=acc;
    }
    public bankAccount getAccount()
    {
        return account;
    }
}

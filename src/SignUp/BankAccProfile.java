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

    @Override
    public void setType()
    {
     Type="bank account";
    }
}

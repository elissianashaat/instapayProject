package SignUp;

public class WalletProviderProfile extends User
{
WalletAccount walletAccount;

    @Override
    public void setType()
    {
        Type="wallet account";
    }
    public void setWalletAccount(WalletAccount account)
    {
        walletAccount=account;
    }
    public WalletAccount getWalletAccount()
    {
        return walletAccount;
    }
}

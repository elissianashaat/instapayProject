package SignUp;

public abstract class User {
    private double Balance;
    private String Username;
    private String Password;
    private String MobileNumber;
    public  String Type;
    public User(){Balance=0;}
    public abstract void setAccountBalance(double b,char c);
    public void setBalance(Double b,char c)
    {
        if(c=='-')
        {
            Balance-=b;
            setAccountBalance(b,c);
        } else if (c=='+')
        {
            Balance+=b;
            setAccountBalance(b,c);
        }
    }
    public void setUsername(String user){Username=user;}
    public void setPassword(String password){Password=password;}
    public void setMobileNumber(String number){MobileNumber=number;}
    public  void setType(String type){
        this.Type=type;
    }

    public String getType() {return Type;}
    public double getBalance(){return Balance;}
    public String getUsername(){return Username;}
    public String getPassword(){return Password;}
    public String getMobileNumber(){return MobileNumber;}
    public boolean PasswordValidation()
    {
        if(Password.length()<8)
        {
            System.out.println("Password must be at least 8 characters");
            return false;
        }
        else if (!Password.matches(".*\\d"))
        {
            System.out.println("Password must contain at least one digit.");
            return false;
        }
        else if (!Password.matches(".*[A-Z].*"))
        {
            System.out.println("Password must contain at least one uppercase letter");
            return false;
        }
        else if (!Password.matches(".*[a-z].*"))
        {
            System.out.println("Password must contain at least one lowercase letter");
            return false;
        }
        else
            return true;
    }
    public abstract void printDetails();

}

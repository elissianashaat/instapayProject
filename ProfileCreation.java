package SignUp;

import java.util.Vector;

public class ProfileCreation {
    public ProfileFactory profilefactory=new ProfileFactory();
    public User createAccount(String Type)
    {
        return profilefactory.signUp(Type);
    }

}

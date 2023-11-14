package SignUp;

import javax.swing.*;
import java.util.List;
public class ProfileCreation
{
    public ProfileFactory profilefactory;
    public List<User> profileList;
    public User createAccount(String Type)
    {
        return profilefactory.signUp(Type);
    }
    public void addUsers(User user)
    {
        profileList.add(user);
        System.out.println("User added successfully");
    }
}

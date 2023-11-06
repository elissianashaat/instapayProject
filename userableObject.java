import java.util.LinkedList;
import java.util.List;

public class userableObject {
    private List<users> userList;

    public userableObject() {
        userList = new LinkedList<>();
    }
    public void update(users user) {
        userList.add(user);
        System.out.println("User added to the list: " + user.getUserName());
    }
}

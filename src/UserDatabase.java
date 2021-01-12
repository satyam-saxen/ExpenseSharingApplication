import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static Map<String,User> users = new HashMap<String,User>();

    public static void addUserInDatabase(User user){
        users.put(user.getPhoneNumber(),user);
    }
    public static Map<String, User> getUsers(){
        return users;
    }
}

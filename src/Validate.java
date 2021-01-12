import java.util.ArrayList;
import java.util.Map;

public class Validate {

    public static Boolean validateUser(User user)
    {
        Map<String,User> users =  UserDatabase.getUsers();
        if(users.containsKey(user.getPhoneNumber()))
            return true;
        else
            return false;
    }

}

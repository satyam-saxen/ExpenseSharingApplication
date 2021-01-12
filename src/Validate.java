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

    public static Boolean validateInput(String inputString)
    {
        if(inputString.length()>1 || inputString.isEmpty())
            return false;
        else if(inputString.charAt(0)<='0' && inputString.charAt(0)>'9')
            return false;
        return true;
    }

}

import java.util.ArrayList;
import java.util.Map;

public class Validate {

    public static Boolean validateUser(String phone)
    {
        Map<String,User> users =  UserDatabase.getUsers();
        if(users.containsKey(phone))
            return true;
        else
            return false;
    }

    public static Boolean validateAction(String action)
    {
        if(action.length()>1 || action.isEmpty())
            return false;
        else if(action.charAt(0)<='0' && action.charAt(0)>'9')
            return false;
        return true;
    }

    public static Boolean validateRegistration(String newUser){
        System.out.println(newUser);
        String []userDetails = newUser.split(",");
        if(userDetails.length != 2)
            return false;
        if(userDetails[1].length() != 10)
            return false;

        if(Validate.validateUser(userDetails[1])){
            System.out.println("Some user have already registered with the phone number please try with new phone number");
        }

        UserDatabase.addUserInDatabase(new User(userDetails[0],userDetails[1]));
        return true;
    }

}

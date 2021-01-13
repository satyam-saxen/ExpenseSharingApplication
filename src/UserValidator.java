import java.util.Map;

public class UserValidator implements Validator{
    @Override
    public Boolean validate(String newUser) {
        String []userDetails = newUser.split(",");
        if(userDetails.length != 2)
            return false;
        if(userDetails[1].length() != 10)
            return false;

        if(UserValidator.validateUser(userDetails[1])){
            System.out.println("Some user have already registered with the phone number please try with new phone number");
            return false;
        }

        return true;
    }

    public static Boolean validateUser(String phone)
    {
        Map<String,User> users =  UserDatabase.getUsers();
        if(users.containsKey(phone))
            return true;
        else
            return false;
    }
}

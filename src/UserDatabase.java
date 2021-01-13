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

    public static User findUserById(int id){
        for(User user : users.values()){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public static void updateUserInDatabase(User user,String []updatedInfo){
//        User updatedUser = new User(updatedInfo[0])
        users.get(updatedInfo[1]).setName(updatedInfo[0]);
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static Map<Integer,User> users = new HashMap<Integer, User>();

    public static Integer addUserInDatabase(User user){
        users.put(user.getId(),user);
        return user.getId();
    }
    public static Map<Integer, User> getUsers(){
        return users;
    }

    public static User findUserById(int data){
        Integer id = data;
        return users.get(id);
    }

    public static void updateUserInDatabase(User user,String []updatedInfo){
        users.get(user.getId()).setName(updatedInfo[0]);
        users.get(user.getId()).setPhoneNumber(updatedInfo[1]);
    }
}

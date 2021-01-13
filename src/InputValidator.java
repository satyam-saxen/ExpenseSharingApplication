import java.util.ArrayList;

public class InputValidator implements Validator{

    public Boolean validate(String action){
        if(action.length()>1 || action.isEmpty())
            return false;
        else if(action.charAt(0)<='0' && action.charAt(0)>'9')
            return false;
        return true;
    }

    public Boolean validateDesc(String desc) {
        if(desc.length()>0)
            return true;
        return false;
    }

    public Boolean validateCost(Double cost) {
        return cost>=0 ? true : false;
    }

    public Boolean validateExpenseUsers(String expenseUsers, ArrayList<User> users){
        if(expenseUsers.length() == 0)
            return false;
        String []userIds = expenseUsers.split(",");
        boolean flag = true;
        for(String u: userIds){
            User user = UserDatabase.findUserById(Integer.parseInt(u));
            if(user == null){
                flag = false;
                break;
            }
            users.add(user);
        }
        return flag;
    }

    public Boolean validatePayer(String payerId){
        if(payerId.length() == 0)
            return false;
        User user = UserDatabase.findUserById(Integer.parseInt(payerId));
        if(user == null)
            return false;
        return true;
    }

}

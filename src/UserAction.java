import java.util.Map;
import java.util.Scanner;

public class UserAction {

    Scanner scanner = new Scanner(System.in);
    Validator userValidator = new UserValidator();
    Printable printer = new ConsolePrinter();
    String error = "Some error occured, please try again";

    public void registerUser(){
        String userInfo = scanner.nextLine();
        if(userValidator.validate(userInfo)){
            String []userDetails = userInfo.split(",");
            Integer id = UserDatabase.addUserInDatabase(new User(userDetails[0],userDetails[1]));
            printer.print("User "+userDetails[0] + " registered with id "+id);
        }else{
            printer.print(error);
        }

    }

    public void displayAllUser(){
        Map<Integer, User> users = UserDatabase.getUsers();
        if(users.isEmpty()){
            printer.print(error);
        }else{
            printer.print("Current Registered users are -:");
            users.forEach((k,v) -> printer.print(v.getId() + " " + v.getName() + " " + v.getPhoneNumber()));
        }
    }

    public void updateUser(){
        printer.print("Which registered user do you want to edit?");
        displayAllUser();
        int id = scanner.nextInt();
        User user = UserDatabase.findUserById(id);
        if(user != null){
            printer.print("Please enter new details");
            String updatedInfo = "";
            scanner.nextLine();
            updatedInfo = scanner.nextLine();
            if(userValidator.validate(updatedInfo)){
                String []userDetails = updatedInfo.split(",");
                UserDatabase.updateUserInDatabase(user,userDetails);
                printer.print("User "+userDetails[0] + " updated");
            }else{
                printer.print(error);
            }
        }
    }

}

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;
import java.util.Scanner;

public class ESA {

    public void run(){
        Boolean appRun = true;
        do{
            System.out.println("Please choose your next action from the list-");
            System.out.println("1. Register a new user");
            System.out.println("2. Display all registered users");
            System.out.println("3. Edit an already added user (name & phone number only)");
            System.out.println("4. Add a new expense");
            System.out.println("5. Display all added expenses");
            System.out.println("6. Edit an already existing expense");
            System.out.println("7. Delete an expense");
            System.out.println("8. Display debts");
            System.out.println("9. Exit the application");

            Scanner scanner = new Scanner(System.in);
            String action = scanner.next();
            if(Validate.validateAction(action)){
                char actionMode = action.charAt(0);
                if(actionMode == '9'){
                    appRun = false;
                }else{
                    //perform action
                    if(actionMode == '1'){
                        System.out.println("To register a new user, please provide their name & phone number separated by a comma");
                        String newUser = "Satyam,8865011413";
                        if(Validate.validateRegistration(newUser)){

                        }else{
                            System.out.println("Something wrong");
                        }

                    }else if(actionMode == '2'){
                        Map<String, User> users = UserDatabase.getUsers();
                        if(users.isEmpty()){
                            System.out.println("No User Register yet");
                        }else{
                            for(int user=0;user<users.size();user++)
                            {
                                System.out.println(users.get("8865011413").getName());
                            }
                        }
                    }
                }
            }else{
                System.out.println("Invalid action, please try again !!");
            }
            System.out.println();

        }while(appRun);
    }
}

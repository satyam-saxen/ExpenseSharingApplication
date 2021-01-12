import java.lang.reflect.MalformedParameterizedTypeException;
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
            if(Validate.validateInput(action)){
                if(action.charAt(0) == '9'){
                    appRun = false;
                }else{
                    //perform action
                }
            }else{
                System.out.println("Invalid action, please try again !!");
            }
            System.out.println();

        }while(appRun);
    }
}

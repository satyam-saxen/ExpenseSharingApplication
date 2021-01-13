import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;
import java.util.Scanner;

public class ESA {

    Boolean appRun = true;
    Validator inputValidator = new InputValidator();
    Menu menu = new Menu();
    Printable printer = new ConsolePrinter();
    UserAction userAction = new UserAction();
    String error = "Some error occured, please try again";
    public void run(){

        do{
            String availabelOptions = menu.getMenu();
            printer.print(availabelOptions);
            String action = menu.getAction();
            if(inputValidator.validate(action)){
                char actionMode = action.charAt(0);
                performAction(actionMode);
            }else{
                printer.print(error);
            }
            printer.print("");

        }while(appRun);
    }

    private void performAction(char action){
        switch (action){
            case '1':
                userAction.registerUser();
                break;
            case '2':
                userAction.displayAllUser();
                break;
            case '3':
                userAction.updateUser();
                break;
            case '4':
                break;
            case '5':
                break;
            case '6':
                break;
            case '7':
                break;
            case '8':
                break;
            case '9':
                appRun = false;
                break;

        }
    }

}

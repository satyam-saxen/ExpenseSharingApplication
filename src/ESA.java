import services.impl.ExpenseServiceImpl;
import services.impl.UserServiceImpl;

public class ESA {

    Boolean appRun = true;
    Validator inputValidator = new InputValidator();
    Menu menu = new Menu();
    Printable printer = new ConsolePrinter();
    UserServiceImpl userServiceImpl = new UserServiceImpl();
    ExpenseServiceImpl expenseServiceImpl = new ExpenseServiceImpl();
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
//                userServiceImpl.registerUser();
                break;
            case '2':
//                userServiceImpl.displayAllUser();
                break;
            case '3':
//                userServiceImpl.updateUser();
                break;
            case '4':
//                expenseServiceImpl.addExpense();
                break;
            case '5':
                expenseServiceImpl.displayAllExpenditure();
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

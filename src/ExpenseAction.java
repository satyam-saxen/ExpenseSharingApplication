import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseAction {

    Scanner scanner = new Scanner(System.in);
    Printable printer = new ConsolePrinter();
    InputValidator inputValidator = new InputValidator();
    ExpenseValidator expenseValidator = new ExpenseValidator();
    UserAction userAction = new UserAction();

    public void addExpense(){
        printer.print("Please enter the description of expense :-");
        String desc = "";
        desc = scanner.nextLine();
        if(!inputValidator.validateDesc(desc))
            return;
        printer.print("Please enter the total cost for expense(in Rs) :-");
        double cost = scanner.nextDouble();
        scanner.nextLine();
        if(!inputValidator.validateCost(cost))
            return;
        printer.print("Please enter comma separated ids of users who shared this expense :-");
        userAction.displayAllUser();
        String expenseUsers = "";
        expenseUsers = scanner.nextLine();
        ArrayList<User> users = new ArrayList<User>();
        if(!inputValidator.validateExpenseUsers(expenseUsers,users))
            return;
        printer.print("Please enter the user who paid for this expense :-");
        userAction.displayAllUser();
        String payerId = "";
        payerId = scanner.nextLine();
        if(!inputValidator.validatePayer(payerId))
            return;
        User payer = UserDatabase.findUserById(Integer.parseInt(payerId));
        Expenditure expenditure = new Expenditure(desc,cost,users,payer);
        ExpenseDatabase.addExpenditureInDatabase(expenditure);
        
    }
}

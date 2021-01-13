import java.util.Scanner;

public class Menu {

    public String getMenu(){
        String availableOptions = "Please choose your next action from the list-\n"+
        "1. Register a new user\n"+
        "2. Display all registered users\n"+
        "3. Edit an already added user (name & phone number only)\n"+
        "4. Add a new expense\n"+
        "5. Display all added expenses\n"+
        "6. Edit an already existing expense\n"+
        "7. Delete an expense\n"+
        "8. Display debts\n"+
        "9. Exit the application\n";
        return availableOptions;
    }

    public String getAction(){
        Scanner scanner = new Scanner(System.in);
        String action = scanner.next();
        return action;
    }

}

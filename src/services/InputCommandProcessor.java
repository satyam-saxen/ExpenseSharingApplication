package services;

import commands.CommandResponse;
import commands.InputCommand;
import commands.impl.*;
import services.impl.UserServiceImpl;

public class InputCommandProcessor {

    UserService userService = new UserServiceImpl();
    ExpenseService expenseService;
    CommandResponse commandResponse;

    public CommandResponse processInputCommand(InputCommand inputCommand){
        if(inputCommand instanceof AddUser){
            AddUser addUser = (AddUser)inputCommand;
            Integer id = userService.registerUser(addUser.getName(),addUser.getPhoneNumber());
            if(id == -1){
                commandResponse.setResponseDescription("Error");
                commandResponse.setStatus(false);
            }
            commandResponse.setResponseDescription("User "+addUser.getName() + " registered with id "+ id);
            commandResponse.setStatus(true);
            return commandResponse;
        }else if(inputCommand instanceof DisplayUser){
            DisplayUser displayUser = (DisplayUser)inputCommand;
            userService.getAllUsers();//  ASK_THIS_ONE
            commandResponse.setResponseDescription("");
            commandResponse.setStatus(true);
        }else if(inputCommand instanceof EditUser){
            EditUser editUser = (EditUser)inputCommand;
            userService.updateUser(editUser.getId(),editUser.getName(),editUser.getPhoneNumber());
        }else if(inputCommand instanceof AddExpense) {
            AddExpense addExpense = (AddExpense)inputCommand;
            expenseService.addExpense(addExpense.getDesc(),addExpense.getCost(),addExpense.getExpenseUsers(),addExpense.getPayer());
        }else if(inputCommand instanceof DisplayAllExpense){
            expenseService.displayAllExpenditure();
        }else if(inputCommand instanceof Exit){
            new CommandResponse("Process exit successfully",false);
        }
        return commandResponse;
    }

}

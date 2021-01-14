package services;

import commands.CommandResponse;
import commands.InputCommand;
import commands.impl.*;
import io.OutputParser;
import models.Expenditure;
import models.User;
import services.impl.ExpenseServiceImpl;
import services.impl.UserServiceImpl;

import java.util.Optional;

public class InputCommandProcessor {

    UserService userService = new UserServiceImpl();
    ExpenseService expenseService = new ExpenseServiceImpl();
    OutputParser outputParser = new OutputParser();

    public CommandResponse processInputCommand(InputCommand inputCommand){
        if(inputCommand instanceof AddUser){
            AddUser addUser = (AddUser)inputCommand;
            Integer id = userService.registerUser(addUser.getName(),addUser.getPhoneNumber());
            return outputParser.parseOutput(userService.getUserById(id).get());
        }else if(inputCommand instanceof DisplayUser){
            return outputParser.parseOutput(userService.getAllUsers());
        }else if(inputCommand instanceof EditUser){
            EditUser editUser = (EditUser)inputCommand;
            Optional<User> updatedUser = userService.updateUser(editUser.getId(), editUser.getName(), editUser.getPhoneNumber());
            return outputParser.parseOutput(updatedUser.get());
        }else if(inputCommand instanceof AddExpense) {
            AddExpense addExpense = (AddExpense)inputCommand;
            Integer id = expenseService.addExpense(addExpense.getDesc(), addExpense.getCost(), addExpense.getExpenseUsers(), addExpense.getPayer());
            return outputParser.parseOutput(expenseService.getExpenseById(id));
        }else if(inputCommand instanceof DisplayAllExpense){
            expenseService.displayAllExpenditure();
        }else if(inputCommand instanceof EditExpense){
            EditExpense editExpense = (EditExpense)inputCommand;
            Expenditure expenditure = expenseService.updateExpense(editExpense.getId(), editExpense.getDesc(), editExpense.getCost(), editExpense.getExpenseUsers(), editExpense.getPayer());
        }else if(inputCommand instanceof Exit){
            return new CommandResponse("Terminated Successfully",false);
        }
        return null;
    }

}

package io;

import commands.InputCommand;
import commands.impl.*;

public class InputParser {
    public InputCommand parseInput(String inputString){
        String [] inputCommandParts = inputString.split(",");
        if(inputCommandParts[0].equals("ADD_USER") && inputCommandParts.length == 3){
            return new AddUser(inputCommandParts[1],inputCommandParts[2]);
        }else if(inputCommandParts[0].equals("DISPLAY_USERS") && inputCommandParts.length == 1){
            return new DisplayUser();
        }else if(inputCommandParts[0].equals("EDIT_USER") && inputCommandParts.length == 4){
            return new EditUser(inputCommandParts[1],inputCommandParts[2],inputCommandParts[3]);
        }else if(inputCommandParts[0].equals("ADD_EXPENSE") && inputCommandParts.length >3){
            return new AddExpense(inputCommandParts[1],inputCommandParts[2],inputCommandParts,inputCommandParts[inputCommandParts.length-1]);
        }else if(inputCommandParts[0].equals("DISPLAY_EXPENSE") && inputCommandParts.length==1){
            return new DisplayAllExpense();
        }else if(inputCommandParts[0].equals("EXIT")){
            return new Exit();
        }
        return null;
    }
}

package io;

import services.UserService;

public class InputParser {
    UserService userService;
    public InputCommand parseInput(String inputString){
        String [] inputCommandParts = inputString.split(",");
        if(inputCommandParts[0].equals("ADD_USER") && inputCommandParts.length == 3){
            userService.registerUser(inputCommandParts[1],inputCommandParts[2]);
        }else if(inputCommandParts[0].equals("DISPLAY_USERS") && inputCommandParts.length == 1){
            userService.getAllUsers();
        }else if(inputCommandParts[0].equals("EDIT_USER") && inputCommandParts.length == 4){
            userService.updateUser(Integer.parseInt(inputCommandParts[0]),inputCommandParts[1],inputCommandParts[2]);
        }
        return new AddUser("","");
    }
}

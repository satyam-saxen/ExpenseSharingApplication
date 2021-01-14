package io;

import commands.CommandResponse;
import models.User;

import java.util.Map;
import java.util.Optional;


public class OutputParser {

    CommandResponse commandResponse = new CommandResponse();

    public CommandResponse parseOutput(Map<Integer,User> users){
        String outputString = "";
        if(users.isEmpty()){
            outputString = "No User Available";
        }else {
            for (User user : users.values()) {
                outputString += user.getId().toString() + " " + user.getName() + " " + user.getPhoneNumber() + "\n";
            }
        }
        commandResponse.setStatus(true);
        commandResponse.setResponseDescription(outputString);
        return commandResponse;
    }
    public CommandResponse parseOutput(Optional<User> user){
        String outputString = "";
        if(user.isPresent()){
            User u = user.get();
            outputString += u.getId().toString() + " " + u.getName() + " " + u.getPhoneNumber() + "\n";
        }else{
            outputString += "Error";
        }
        commandResponse.setStatus(true);
        commandResponse.setResponseDescription(outputString);
        return commandResponse;
    }
}

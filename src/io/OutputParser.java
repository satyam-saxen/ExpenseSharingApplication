package io;

import commands.CommandResponse;
import models.Debt;
import models.Expenditure;
import models.User;
import models.UserPair;

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

    public CommandResponse parseOutputs(Map<Integer,Expenditure> expenditures){
        String outputString = "";
        if(expenditures.isEmpty()){
            outputString = "No expense added";
        }else{
            for(Expenditure expenditure:expenditures.values()){
                outputString += expenditure.getId().toString() + " " + expenditure.getDesc() + " " + expenditure.getCost() +
                        expenditure.getExpenseUsers().size() + expenditure.getPayer().getName()+"\n";
            }
        }
        commandResponse.setStatus(true);
        commandResponse.setResponseDescription(outputString);
        return commandResponse;
    }

    public CommandResponse parseOutputss(Map<UserPair, Debt> debts){
        String outputString = "";
        if(debts.isEmpty()){
            outputString += "No expenditure added for showing debt record";
        }else{
            for(Debt debt: debts.values()){
                outputString += debt.getUserPair().getDebtor().getName() + " " +debt.getUserPair().getOwner().getName() +" " + debt.getCost() + "\n";
            }
        }
        commandResponse.setStatus(true);
        commandResponse.setResponseDescription(outputString);
        return commandResponse;
    }


    public CommandResponse parseOutput(User user){
        String outputString = "";
        if(user != null){
            outputString += user.getId().toString() + " " + user.getName() + " " + user.getPhoneNumber() + "\n";
        }else{
            outputString += "Error";
        }
        commandResponse.setStatus(true);
        commandResponse.setResponseDescription(outputString);
        return commandResponse;
    }

    public CommandResponse parseOutput(Optional<Expenditure> maybeExpenditure){
        String outputString = "";
        if(maybeExpenditure.isPresent()){
            Expenditure expenditure = maybeExpenditure.get();
            outputString += expenditure.getId().toString() + " " + expenditure.getDesc() + " " + expenditure.getCost() +"\n";
        }else{
            outputString += "Error";
        }
        commandResponse.setStatus(true);
        commandResponse.setResponseDescription(outputString);
        return commandResponse;
    }
}

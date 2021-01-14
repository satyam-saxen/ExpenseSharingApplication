package commands.impl;

import commands.InputCommand;

public class AddExpense implements InputCommand {
    private String desc;
    private String cost;
    private String [] expenseUsers;
    private String payer;

    public AddExpense(String desc, String cost, String[] expenseUsers, String payer) {
        this.desc = desc;
        this.cost = cost;
        this.expenseUsers = expenseUsers;
        this.payer = payer;
    }

    public String getDesc() {
        return desc;
    }

    public String getCost() {
        return cost;
    }

    public String[] getExpenseUsers() {
        return expenseUsers;
    }

    public String getPayer() {
        return payer;
    }
}

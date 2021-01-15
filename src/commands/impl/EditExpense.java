package commands.impl;

import commands.InputCommand;

public class EditExpense implements InputCommand {
    private String id;
    private String desc;
    private String cost;
    private String [] expenseUsers;
    private String payer;

    public EditExpense(String id,String desc, String cost, String[] expenseUsers, String payer) {
        this.id = id;
        this.desc = desc;
        this.cost = cost;
        this.expenseUsers = expenseUsers;
        this.payer = payer;
    }

    public String getId() {
        return id;
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

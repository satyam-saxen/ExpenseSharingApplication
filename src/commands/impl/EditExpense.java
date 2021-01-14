package commands.impl;

import commands.InputCommand;

public class EditExpense extends AddExpense implements InputCommand {
    private String id;
    public EditExpense(String desc, String cost, String[] expenseUsers, String payer) {
        super(desc, cost, expenseUsers, payer);
    }
    public EditExpense(String id,String desc, String cost, String[] expenseUsers, String payer) {
        super(desc, cost, expenseUsers, payer);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

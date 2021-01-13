import java.util.ArrayList;

public class Expenditure {
    private Integer id;
    private String desc;
    private ArrayList<User> expenseUsers;
    private User payer;

    public Expenditure(String desc, ArrayList<User> expenseUsers, User payer) {
        this.id = ExpenseIdGenerator.getUniqueId();
        this.desc = desc;
        this.expenseUsers = expenseUsers;
        this.payer = payer;
    }

    public Integer getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public ArrayList<User> getExpenseUsers() {
        return expenseUsers;
    }

    public User getPayer() {
        return payer;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setExpenseUsers(ArrayList<User> expenseUsers) {
        this.expenseUsers = expenseUsers;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }
}

package models;

import java.util.ArrayList;

public class Expenditure {
    private Integer id;
    private String desc;
    private double cost;
    private ArrayList<User> expenseUsers;
    private User payer;

    public Expenditure(Integer id,String desc, double cost, ArrayList<User> expenseUsers, User payer) {
        this.id = id;
        this.desc = desc;
        this.cost = cost;
        this.expenseUsers = expenseUsers;
        this.payer = payer;
    }

    public Integer getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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

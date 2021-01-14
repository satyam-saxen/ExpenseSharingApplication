package models;

public class Debt {
    private User debtor;
    private User owner;
    private double cost;

    public Debt(User debtor, User owner, double cost) {
        this.debtor = debtor;
        this.owner = owner;
        this.cost = cost;
    }

    public User getDebtor() {
        return debtor;
    }

    public void setDebtor(User debtor) {
        this.debtor = debtor;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

package models;

public class Debt {
    private UserPair userPair;
    private double cost;

    public Debt(UserPair userPair, double cost) {
        this.userPair = userPair;
        this.cost = cost;
    }

    public UserPair getUserPair() {
        return userPair;
    }

    public void setUserPair(UserPair userPair) {
        this.userPair = userPair;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

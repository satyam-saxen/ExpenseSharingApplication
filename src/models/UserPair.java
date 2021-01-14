package models;

public class UserPair {
    private User debtor;
    private User owner;

    public UserPair(User debtor, User owner) {
        this.debtor = debtor;
        this.owner = owner;
    }
}

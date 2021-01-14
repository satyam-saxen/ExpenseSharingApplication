package io;

public class AddUser implements InputCommand{
    private String name;
    private String phoneNumber;

    public AddUser(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}

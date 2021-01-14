package commands.impl;

import commands.InputCommand;

public class AddUser implements InputCommand {
    private String name;
    private String phoneNumber;

    public AddUser(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

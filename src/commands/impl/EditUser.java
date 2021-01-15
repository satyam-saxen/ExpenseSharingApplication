package commands.impl;

import commands.InputCommand;

public class EditUser implements InputCommand {
    private String id;
    private String name;
    private String phoneNumber;

    public EditUser(String id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

public class User {
    private static int unique_number=1;
    private int id;
    private String name;
    private String phoneNumber;

    public User(String name, String phoneNumber) {
        this.id = unique_number;
        this.name = name;
        this.phoneNumber = phoneNumber;
        unique_number++;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

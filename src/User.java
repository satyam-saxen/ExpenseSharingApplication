public class User {
    private Integer id;
    private String name;
    private String phoneNumber;

    public User(String name, String phoneNumber) {
        this.id = UserIdGenerator.getUniqueId();
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
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

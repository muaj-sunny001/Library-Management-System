package entities;

public class Admin extends User{

    public Admin(String username, String password, String name, String email) {
        super(username, password, name, email);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static Admin fromFileFormat(String data) {
        String[] parts = data.split(",");
        return new Admin(parts[0], parts[1], parts[2], parts[3]);
    }

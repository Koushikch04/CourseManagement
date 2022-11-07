package personPackage;

public class Admin{
    private String userName = "Nightmare";
    private int password = "Iiits@218".hashCode();

    public int changePassword(String oldPass, String newPass) {
        if(this.password!=oldPass.hashCode()) return 0;
        this.password = newPass.hashCode();
        return 1;
    }

    public int changeUsername(String oldUsername, String newUsername) {
        if(this.userName.equals(oldUsername)) {
            this.userName = newUsername;
            return 1;
        }
        return 0;
    }
    public int authentication(String username, String pass) {
        if(this.password == pass.hashCode() && this.userName.equals(username)) return 1;
        return 0;
    }
}

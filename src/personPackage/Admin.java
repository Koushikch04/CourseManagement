package personPackage;

public class Admin{
    private static String userName = "iiits";
    private static int password = "iiits@2022".hashCode();

    public static int authentication(String username, String pass) {
        try {
            if (password == pass.hashCode() && userName.equals(username)) return 1;
        }
        catch(NullPointerException e){
            System.out.println("Login Details cannot be Empty");
        }
        return 0;
    }
}

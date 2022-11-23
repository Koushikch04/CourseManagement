package personPackage;

public class Admin{
    private static String userName = "CourseManagement";
    private static int password = "Iiits@218".hashCode();

    public static int authentication(String username, String pass) {
        if(password == pass.hashCode() && userName.equals(username)) return 1;
        return 0;
    }
}

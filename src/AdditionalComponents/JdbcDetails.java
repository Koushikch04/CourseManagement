package AdditionalComponents;

public class JdbcDetails {
    private static String database = "java";
    private static String userName = "root";
    private static String password = "Suprit@123";

    public static String getDatabase() {
        return database;
    }

    public static void setDatabase(String database) {
        JdbcDetails.database = database;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        JdbcDetails.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        JdbcDetails.password = password;
    }
}

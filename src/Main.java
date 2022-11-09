
import CommandLine.*;
public class Main {

    public static void main(String[] args) {
//        try {
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab6", "root", "Suprit@123");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from boats");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("bname"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        CommandLineArguments commandLineArguments = new CommandLineArguments();
        System.out.println(commandLineArguments);
    }
}
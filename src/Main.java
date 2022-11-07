import personPackage.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab6", "root", "Suprit@123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from boats");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("bname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
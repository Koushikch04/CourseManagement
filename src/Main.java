import personPackage.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
//        Admin admin = new Admin();
//        Teacher teacher = new Teacher("Arjit", "Male", LocalDate.of(1990,10,12), "T1010", "CSE");
//        System.out.println("Dr. Shantana Roy is 41 years 0 months and 14 days.");
//        Teacher.addTeacher(teacher);
//        System.out.println(admin.authentication("Nightmare","iiiTs@218" ));
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
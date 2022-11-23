package Courses;
import AdditionalComponents.JdbcDetails;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class courseImport {
    public static void addCourses() throws SQLException, FileNotFoundException {
        String url="jdbc:mysql://localhost:3306/"+ JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con=DriverManager.getConnection(url,UserName,PassWord);
        Statement st = con.createStatement();
     String query="create table if not exists Courses (courseId int,title varchar(30),deptName varchar(30),credits int,primary key(courseId))";
         st.executeUpdate(query);
         query="insert into courses values(?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(query);
        Scanner sc=new Scanner(new File("C:\\Users\\chk24\\Downloads\\courseDetails.csv"));
        while(sc.hasNext())
        {
            String[] sl=sc.next().split(",");
            ps.setInt(1,Integer.parseInt(sl[0]));
            ps.setString(2,sl[1]);
            ps.setString(3,sl[2]);
            ps.setInt(4,Integer.parseInt(sl[3]));
            ps.executeUpdate();
        }
        con.close();
    }
}



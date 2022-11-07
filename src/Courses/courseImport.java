package Courses;
import java.io.File;
import java.sql.*;
import java.util.Scanner;

public class courseImport {
    public static void main(String[] args) throws Exception{
        String url="jdbc:mysql://localhost:3306/Courses";
        String UserName="root";
        String PassWord="root1234";
     Connection con=DriverManager.getConnection(url,UserName,PassWord);
//     String query="create table Courses (courseId int,title varchar(30),deptName varchar(30),credits int,primary key(courseId))";
//     try {
//         PreparedStatement st = con.prepareStatement(query);
//         st.executeUpdate();
//     }
//     catch(Exception e) {
//         System.out.println("Unable to execute update on query");
//     }
     String query="insert into courses values(?,?,?,?)";
    PreparedStatement st=con.prepareStatement(query);
    Scanner sc=new Scanner(new File("C:\\Users\\chk24\\Downloads\\courseDetails.csv"));
    while(sc.hasNext())
    {
        String[] sl=sc.next().split(",");
        st.setInt(1,Integer.parseInt(sl[0]));
        st.setString(2,sl[1]);
        st.setString(3,sl[2]);
        st.setInt(4,Integer.parseInt(sl[3]));
        st.executeUpdate();
    }
        con.close();
    }
}

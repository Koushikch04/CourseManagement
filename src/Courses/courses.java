package Courses;

import javax.swing.plaf.nimbus.State;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class courses {
     private String courseId;
     private String title;

     private String Abbreviation;
     private String deptName;
     private int credits;
      public courses() {
      }

    public String getAbbreviation() {
        return Abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        Abbreviation = abbreviation;
    }

    public courses(String courseId, String title, String abbreviation, String deptName, int credits) {
          setAbbreviation(abbreviation);
          setCourseId(courseId);
          setCredits(credits);
          setTitle(title);
          setDeptName(deptName);
      }
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public static void addCourses(int courseId,String title,String deptName,int credits)
    {

    }
    @Override
    public String toString() {
        return "courseId:"+getCourseId()+" title:"+getTitle()+" deptName:"+getDeptName()+" credits:"+getCredits();
    }
    public static void addCourses() throws SQLException, FileNotFoundException {
        String url = "jdbc:mysql://localhost:3306/lab3";
        String UserName = "root";
        String PassWord = "root1234";
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query="create table if not exists courses(courseId varchar(30),title varchar(30),  abbreviation varchar(30),deptName varchar(30), credits int,primary key(courseId))";
        Statement st=con.createStatement();
        st.executeUpdate(query);
        query="insert into courses values(?,?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(query);
        File file=new File("C:\\Users\\chk24\\Downloads\\course.csv");
        Scanner sc=new Scanner(file);
        while(sc.hasNextLine())
        {
            String[] str=sc.nextLine().split(",");
            ps.setString(1,str[0]);
            ps.setString(2,str[1]);
            ps.setString(3,str[2]);
            ps.setString(4,str[3]);
            ps.setInt(5,Integer.parseInt(str[4].trim()));
            ps.executeUpdate();
        }
    }
    public static void addCourse(courses course) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/lab3";
        String UserName = "root";
        String PassWord = "root1234";
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query="create table if not exists courses(courseId varchar(30),title varchar(30),  abbreviation varchar(30),deptName varchar(30), credits int,primary key(courseId))";
        Statement st=con.createStatement();
        st.executeUpdate(query);
        query="insert into courses values(?,?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setString(1,course.getCourseId());
        ps.setString(2,course.getTitle());
        ps.setString(3,course.getAbbreviation());
        ps.setString(4,course.getDeptName());
        ps.setInt(5,course.getCredits());
        ps.executeUpdate();
    }
    public static void removeCourse(courses cs) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/lab3";
        String UserName = "root";
        String PassWord = "root1234";
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query="delete from courses where courseId=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,cs.getCourseId());
        System.out.println(ps.executeUpdate()+" rows updated");
    }
}

package Courses;
import AdditionalComponents.JdbcDetails;
import AdditionalComponents.Message;
import personPackage.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class courses {
     private String courseId;
    private String InstructorId;

    public String getInstructorId() {
        return InstructorId;
    }

    public void setInstructorId(String instructorId) {
        InstructorId = instructorId;
    }

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

    public courses(String courseId, String InstructorId,String title, String abbreviation, String deptName, int credits) {
          setAbbreviation(abbreviation);
          setInstructorId(InstructorId);
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
    @Override
    public String toString() {
        return "courseId:"+getCourseId()+" title:"+getTitle()+" deptName:"+getDeptName()+" credits:"+getCredits();
    }

    public static void addCourses(String file) throws SQLException, FileNotFoundException {
        String url="jdbc:mysql://localhost:3306/"+ JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query="create table if not exists courses(courseId varchar(30),InstructorId varchar(30),title varchar(30),  abbreviation varchar(50),deptName varchar(30), credits int,primary key(courseId))";
        Statement st=con.createStatement();
        st.executeUpdate(query);
        query="insert into courses values(?,?,?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(query);
        Scanner sc=new Scanner(new File("src/Courses/"+file));
        while(sc.hasNextLine())
        {
            String[] str=sc.nextLine().split(",");
            ps.setString(1,str[0]);
            ps.setString(2,str[1]);
            ps.setString(3,str[2]);
            ps.setString(4,str[3]);
            ps.setString(5,str[4]);
            ps.setInt(6,Integer.parseInt(str[5].trim()));
            ps.executeUpdate();
        }
    }
    public static void addCourse(courses course) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query="create table if not exists courses(courseId varchar(30),InstructorId varchar(30),title varchar(30),  abbreviation varchar(50),deptName varchar(30), credits int,primary key(courseId))";
        Statement st=con.createStatement();
        st.executeUpdate(query);
        query="insert into courses values(?,?,?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setString(1,course.getCourseId());
        ps.setString(2,course.getInstructorId());
        ps.setString(3,course.getTitle());
        ps.setString(4,course.getAbbreviation());
        ps.setString(5,course.getDeptName());
        ps.setInt(6,course.getCredits());
        ps.executeUpdate();
    }

    public static void removeCourse(String courseId) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query="delete from courses where courseId=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,courseId);
        System.out.println(ps.executeUpdate()+" rows updated");
    }
    public static void removeAllCourses() throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query = "truncate courses";
        Statement st=con.createStatement();
        st.executeUpdate(query);
    }
    public static ArrayList<courses> Sort(String SortField,int order) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query = "select * from courses order by "+SortField;
        Statement st=con.createStatement();
        if(order==0)
            query+=" asc";
        else
            query+=" desc";
        ResultSet rs=st.executeQuery(query);;
        ArrayList<courses> courseList = new ArrayList<>();
        while(rs.next()){
            courses temp= new courses(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
           courseList.add(temp);
        }
       return courseList;
    }

    public static ArrayList<courses> numericSearch(String fieldName,String value,String operation) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query = "select * from courses where "+fieldName;
        if(operation.equals("-gt")){
            query+=">"+Double.parseDouble(value);
        }
        else if(operation.equals("-lt")){
            query+="<"+Double.parseDouble(value);
        }
        else if(operation.equals("-e")){
            query+="="+Double.parseDouble(value);
        }
        Statement st = con.createStatement();
        System.out.println(query);
        ResultSet rs = st.executeQuery(query);
         ArrayList<courses> al = new ArrayList<courses>();
        while(rs.next()){
            courses temp = new courses(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
            al.add(temp);
        }
        return al;
    }
    public static ArrayList<courses> Search(String fieldName,String Search) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query = "select * from courses where "+fieldName+"='"+Search+"'";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);;
        ArrayList<courses> courseList = new ArrayList<>();
        while(rs.next()){
            courses temp= new courses(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
            courseList.add(temp);
        }
        return courseList;
    }
    public static ArrayList<courses> partialSearch(String fieldName,String Search) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query = "select * from courses where "+fieldName+" like "+"'%"+Search+"%'";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);;
        ArrayList<courses> courseList = new ArrayList<>();
        while(rs.next()){
            courses temp= new courses(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
            courseList.add(temp);
        }
        return courseList;
    }
    public static void update(String Id,String Field,String newValue) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query="update courses set "+Field+"='"+newValue+"' where courseId='"+Id+"'";
        Statement st=con.createStatement();
        int res = st.executeUpdate(query);
        if(res == 0){
            Message.noRecords();
        }
        else {
            Message.updated();
        }
        con.close();
    }

    public static void updateViaCsv(String file) throws SQLException, FileNotFoundException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query = "update courses set InstructorId=?,title=?,abbreviation=?,deptName=?,credits=? where courseId=?";
        Scanner sc  = new Scanner(new File("src/Courses/"+file));
        PreparedStatement ps = con.prepareStatement(query);
        while(sc.hasNextLine()){
            String[] str = sc.nextLine().split(",");
            ps.setString(1,str[1]);
            ps.setString(2,str[2]);
            ps.setString(3,str[3]);
            ps.setString(4,str[4]);
            ps.setInt(5,Integer.parseInt(str[5]));
            ps.setString(6,str[0]);
            ps.executeUpdate();
        }


    }
}

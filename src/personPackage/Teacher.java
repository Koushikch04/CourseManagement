package personPackage;

import AdditionalComponents.JdbcDetails;
import AdditionalComponents.Date;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Teacher extends Person{
    private String teacherID;
    private String departmentName;
    private Double salary;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Teacher() {
        super();
    }

    public Teacher(String teacherID, String name, String deptName, String gender, Double salary, Date dob, String title) {
        super(name, gender, dob);
        this.teacherID = teacherID;
        this.departmentName = deptName;
        this.title = title;
        this.salary = salary;
    }


    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String calculateAge() {
        LocalDate curDate = LocalDate.now();
        Period period = Period.between(LocalDate.parse(super.getDob()), curDate);
        String ans = "Dr. " + super.getName() + " is " + period.getYears() + " years " + period.getMonths() + " months and " + period.getDays() + " days.";
        return ans;
    }

    public static void addTeachers(String file) throws SQLException, FileNotFoundException {
        String url="jdbc:mysql://localhost:3306/"+ JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        Statement st = con.createStatement();
        String query = "create table if not exists Teacher (teacherId varchar(10),name varchar(40),deptName varchar(30),gender varchar(30),salary numeric(10,0),dob Date,title varchar(30),primary key(teacherId))";
        st.executeUpdate(query);
        query = "insert into Teacher values(?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        Scanner sc = new Scanner(new File("personPackage/" + file));
        while (sc.hasNextLine()) {
            String[] sr = sc.nextLine().split(",");
            String[] sl = sr[5].split("-");
            int year = Integer.parseInt(sl[2]);
            int month = Integer.parseInt(sl[1]);
            int day = Integer.parseInt(sl[0]);

            ps.setString(1, sr[0]);
            ps.setString(2, sr[1]);
            ps.setString(3, sr[2]);
            ps.setString(4, sr[3]);
            ps.setDouble(5, Double.parseDouble(sr[4].trim()));
            ps.setDate(6, java.sql.Date.valueOf(year + "-" + month + "-" + day));
            ps.setString(7, sr[6]);
            ps.executeUpdate();
        }
    }

    public static void addTeacher(Teacher teacher) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query = "create table if not exists Teacher (teacherId varchar(10),name varchar(40),deptName varchar(30),gender varchar(30),salary numeric(10,0),dob Date,title varchar(30),primary key(teacherId))";
        Statement st = con.createStatement();
        st.executeUpdate(query);
        query = "insert into Teacher values(?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, teacher.getTeacherID());
        ps.setString(2, teacher.getName());
        ps.setString(3, teacher.getDepartmentName());
        ps.setString(4, teacher.getGender());
        ps.setDouble(5, teacher.getSalary());
        ps.setDate(6, java.sql.Date.valueOf(teacher.getDob()));
        ps.setString(7, teacher.getTitle());
        ps.executeUpdate();
        System.out.println("Teacher added");
    }

    public static void removeTeacher(String teacherID) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query = "delete from Teacher where teacherId=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, teacherID);
        ps.executeUpdate();
        System.out.println("Teacher removed successfully");
    }

    public static void removeTeachers() throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        Statement st = con.createStatement();
        String query = "truncate Teacher";
        st.executeUpdate(query);
    }


    public static ArrayList<Teacher> Sort(String sortField,int order) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query = "select * from teacher order by "+sortField;
        if(order==1)
            query+=" desc";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Teacher> teach = new ArrayList<>();
        while (rs.next()) {
            LocalDate ld=rs.getDate(6).toLocalDate();
            Teacher temp = new Teacher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), new Date(ld.getYear(),(short)ld.getDayOfMonth(),(short)ld.getDayOfMonth()), rs.getString(7));
            teach.add(temp);
        }
        return teach;
    }

    public static ArrayList<Teacher> Search(String fieldName,String Search) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query = "select * from teacher where " +fieldName+" like "+"'%"+Search+"%'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Teacher> teach = new ArrayList<>();
        while (rs.next()) {
            LocalDate ld=rs.getDate(6).toLocalDate();
            Teacher temp = new Teacher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), new Date(ld.getYear(),(short)ld.getDayOfMonth(),(short)ld.getDayOfMonth()), rs.getString(7));
            teach.add(temp);
        }
        return teach;
    }

    public static void update(String Id,String field,String newValue) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con= DriverManager.getConnection(url,UserName,PassWord);
        String query="update teacher set "+field+"=\""+newValue+"\" where teacherId=\""+Id+"\"";
        Statement st=con.createStatement();
        st.executeUpdate(query);
    }

    public static int authentication(String id, String dob) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con= DriverManager.getConnection(url,UserName,PassWord);
        String query = "select dob from teacher where teacherId=\"" + id + "\"";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(rs.next())  {
            String s = rs.getString(1).replace("-","");
            if(dob.equals(s)) return 1;
        }
        return 0;
    }

}
package personPackage;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;

public class Teacher extends Person{
    private String teacherID;
    private String departmentName;

    public Teacher(String name, String gender, LocalDate dob, String teacherID, String deptName) {
        super(name, gender, dob);
        this.teacherID = teacherID;
        this.departmentName = deptName;
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
        Period period = Period.between(super.getDob(), curDate);
        String ans = "Dr. " + super.getName() + " is " + period.getYears() + " years " + period.getMonths() + " months and " + period.getDays() + " days.";
        return ans;
    }

    public static void addTeacher(Teacher teacher) throws SQLException {
        String url="jdbc:mysql://localhost:3306/lab5";
        String UserName="root";
        String PassWord="root1234";
        Connection con= DriverManager.getConnection(url,UserName,PassWord);
        String query="create table if not exists Teacher  (ID varchar(10),name varchar(40),deptName varchar(30),dob Date,gender varchar(30),primary key(ID))";
        Statement st=con.createStatement();
        st.executeUpdate(query);
        query="insert into Teacher values(?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, teacher.getTeacherID());
        ps.setString(2,teacher.getName());
        ps.setString(3,teacher.getDepartmentName());
        ps.setDate(4,Date.valueOf(teacher.getDob()));
        ps.setString(5,teacher.getGender());
        ps.executeUpdate();
        System.out.println("Teacher added");
    }
    public static void removeTeacher(Teacher teacher) throws SQLException {
        String url="jdbc:mysql://localhost:3306/lab5";
        String UserName="root";
        String PassWord="root1234";
        Connection con= DriverManager.getConnection(url,UserName,PassWord);
        String query="delete from Teacher where  ID=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,teacher.getTeacherID());
        ps.executeUpdate();
    }
}

package Courses;

import AdditionalComponents.JdbcDetails;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Assignments {
    String courseNo;
    String AssignmentNo;
    String status;
    Double marks;

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getAssignmentNo() {
        return AssignmentNo;
    }

    public void setAssignmentNo(String assignmentNo) {
        AssignmentNo = assignmentNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public static void  addAssignments(String file) throws SQLException, FileNotFoundException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con=DriverManager.getConnection(url,UserName,PassWord);
        String query="create  table Assignments(CNo varchar(10),AssNO varchar(30),status varchar(30),marks numeric(2,0));";
        Statement st=con.createStatement();
        st.executeUpdate(query);
        Scanner sc=new Scanner(new File("C:/Users/chk24/Downloads/assignments.csv"));
        query="insert into Assignments values(?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(query);
        while(sc.hasNext())
        {
            String[] str=sc.next().split(",");
            ps.setString(1,str[0]);
            ps.setString(2,str[1]);
            ps.setString(3,"InComplete");
            ps.setDouble(4,0);
            ps.executeUpdate();
        }
        con.close();
    }

}

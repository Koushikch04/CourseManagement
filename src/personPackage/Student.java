package personPackage;
import com.mysql.cj.jdbc.exceptions.PacketTooBigException;

import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Locale;
import java.util.Scanner;

public class Student extends Person{
    private String studID;
    private String branch;

    public Student(String name, String gender, LocalDate dob, String studID, String deptName) {
        super(name, gender, dob);
        this.studID = studID;
        this.branch = deptName;
    }

    public String getStudID() {
        return studID;
    }

    public void setStudID(String studID) {
        this.studID = studID;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String calculateAge() {
        LocalDate curDate = LocalDate.now();
        Period period = Period.between(super.getDob(), curDate);
        String ans = super.getName() + " is " + period.getYears() + " years " + period.getMonths() + " months and " + period.getDays() + " days.";
        return ans;
    }

    public static void addStudents(String file) throws Exception {
        String url="jdbc:mysql://localhost:3306/lab9";
        String UserName="root";
        String PassWord="root1234";
        Connection con= DriverManager.getConnection(url,UserName,PassWord);
        Statement st=con.createStatement();
        String query="create table if not exists Students(studId varchar(30),name varchar(100),deptName varchar(30),dob Date,gender varchar(10),primary key(studId));";
        st.executeUpdate(query);
        query="insert into Students values(?,?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(query);
        Scanner sc=new Scanner(new File("src/personPackage/"+file));
        while(sc.hasNextLine())
        {
            SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
            SimpleDateFormat print = new SimpleDateFormat("MMM d, yyyy HH:mm:ss");
            String[] str=sc.nextLine().split(",");
            System.out.println("str[0]:"+str[0]+"str[1]:"+str[1]+"str[2]:"+str[2]+"str[3]:"+str[3]+"str[4]:"+str[4]);
            String[] sr=str[3].split("-");
            int year=Integer.parseInt(sr[2]);
            int month=Integer.parseInt(sr[1]);
            int day=Integer.parseInt(sr[0]);
            Date date=Date.valueOf(year+"-"+month+"-"+day);
            System.out.printf("%s\n",str[3]);
//            Date d1=Date.valueOf(str[3]);
            ps.setString(1,str[0].trim());
            ps.setString(2,str[1]);
            ps.setString(3,str[2]);
            ps.setDate(4,date);
            ps.setString(5,str[4]);
            ps.executeUpdate();
        }
    }
    public static void addStudent(Student student) throws Exception {
        String url="jdbc:mysql://localhost:3306/lab5";
        String UserName="root";
        String PassWord="root1234";
        Connection con= DriverManager.getConnection(url,UserName,PassWord);
        String query="insert into Students values(?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,student.getStudID());
        ps.setString(2,student.getName());
        ps.setString(3,student.getBranch());
        ps.setDate(4,Date.valueOf(student.getDob()));
        ps.setString(5, student.getGender());
        ps.executeUpdate();
    }



        public static void removeStudent(String studId) throws SQLException {
            String url="jdbc:mysql://localhost:3306/lab5";
            String UserName="root";
            String PassWord="root1234";
            Connection con= DriverManager.getConnection(url,UserName,PassWord);
            String query="delete from Students where studId=?";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1,studId);
            ps.executeUpdate();
        }
}


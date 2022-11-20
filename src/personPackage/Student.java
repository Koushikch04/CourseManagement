package personPackage;

import AdditionalComponents.JdbcDetails;
import AdditionalComponents.Date;
import AdditionalComponents.Message;

import java.util.*;
import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Locale;
import java.util.Scanner;

public class Student extends Person {
    private String studID;
    private String branch;

    public Student() {
        super();
    }
    public Student(String studID, String name, String deptName, Date dob, String gender) {
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
        Period period = Period.between(LocalDate.parse(super.getDob()), curDate);
        String ans = super.getName() + " is " + period.getYears() + " years " + period.getMonths() + " months and " + period.getDays() + " days.";
        return ans;
    }

    public static void addStudents(String file) throws Exception {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con= DriverManager.getConnection(url,UserName,PassWord);
        Statement st=con.createStatement();
        String query="create table if not exists Students(studId varchar(30) NOT NULL,name varchar(100) NOT NULL, deptName varchar(30) NOT NULL,dob Date,gender varchar(10) NOT NULL,primary key(studId));";
        st.executeUpdate(query);
        query="insert into Students values(?,?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(query);
        Scanner sc=new Scanner(new File("personPackage/"+file));
        while(sc.hasNextLine())
        {
            SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
            SimpleDateFormat print = new SimpleDateFormat("MMM d, yyyy HH:mm:ss");
            String[] str=sc.nextLine().split(",");
            String[] sr=str[3].split("-");
            int year=Integer.parseInt(sr[2]);
            int month=Integer.parseInt(sr[1]);
            int day=Integer.parseInt(sr[0]);
            java.sql.Date date= java.sql.Date.valueOf(year+"-"+month+"-"+day);
            ps.setString(1,str[0].trim());
            ps.setString(2,str[1]);
            ps.setString(3,str[2]);
            ps.setDate(4,date);
            ps.setString(5,str[4]);
            ps.executeUpdate();
        }
        con.close();
    }
    public static void addStudent(Student student) throws Exception {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con= DriverManager.getConnection(url,UserName,PassWord);
        Statement st=con.createStatement();
        String query="create table if not exists Students(studId varchar(30) NOT NULL,name varchar(100) NOT NULL, deptName varchar(30) NOT NULL,dob Date,gender varchar(10) NOT NULL,primary key(studId));";
        st.executeUpdate(query);
        query="insert into Students values(?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,student.getStudID());
        ps.setString(2,student.getName());
        ps.setString(3,student.getBranch());
        ps.setDate(4,java.sql.Date.valueOf(student.getDob()));
        ps.setString(5, student.getGender());
        ps.executeUpdate();
        con.close();
    }

    public static  ArrayList<Student> Sort( String sortField,int order) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con= DriverManager.getConnection(url,UserName,PassWord);
        String query="select * from students order by "+sortField;
        if(order==1) {
            query+=" desc";
        }
        PreparedStatement ps=con.prepareStatement(query);
        ResultSet rs;
        ArrayList<Student> list = null;
        try {
             rs = ps.executeQuery();
             list=new ArrayList<>();
            while(rs.next())
            {
                LocalDate ld=rs.getDate(4).toLocalDate();
                Student temp=new Student(rs.getString(1),rs.getString(2),rs.getString(3),new Date(ld.getYear(),(short)ld.getDayOfMonth(),(short)ld.getDayOfMonth()),rs.getString(5));
                list.add(temp);
            }
        }
        catch (SQLException e)
        {
            System.out.println("FieldName "+sortField+" is not valid");
        }
        con.close();
        return list;
    }


    public static  ArrayList<Student> Search( String fieldName,String Search) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con= DriverManager.getConnection(url,UserName,PassWord);

        String query = "select * from students where " +fieldName+" like "+"'%"+Search+"%'";
        PreparedStatement ps=con.prepareStatement(query);
        ResultSet rs;
        ArrayList<Student> list = null;
        try {
            rs = ps.executeQuery();
            list=new ArrayList<>();
            if(list.size()==0) Message.noRecords();
            while(rs.next())
            {
                LocalDate ld=rs.getDate(4).toLocalDate();
                Student temp=new Student(rs.getString(1),rs.getString(2),rs.getString(3),new Date(ld.getYear(),(short)ld.getDayOfMonth(),(short)ld.getDayOfMonth()),rs.getString(5));
                list.add(temp);
            }
        }
        catch (SQLException e)
        {
            Message.noRecords();
        }
        con.close();
        return list;
    }


    public static void removeStudent(String studId) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con= DriverManager.getConnection(url,UserName,PassWord);
        String query="delete from Students where studId=?";
        PreparedStatement ps= con.prepareStatement(query);
        ps.setString(1,studId);
        int x = ps.executeUpdate();
        if(x==0) {
            con.close();
            Message.noRecords();
        }
        con.close();
    }

    public static void removeStudents() throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con= DriverManager.getConnection(url,UserName,PassWord);
        Statement st=con.createStatement();
        String query="truncate Students";
        st.executeUpdate(query);
        con.close();
    }

    public static void update(String Id,String Field,String newValue) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con= DriverManager.getConnection(url,UserName,PassWord);

        String query="update students set "+Field+"=\""+newValue+"\" where studId=\""+Id+"\"";
        Statement st=con.createStatement();
        int x = st.executeUpdate(query);
        if(x==0) {
            con.close();
            Message.noRecords();
        }
        con.close();
    }

    public static int authentication(String id, String dob) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con= DriverManager.getConnection(url,UserName,PassWord);
        String query = "select dob from students where studId=\"" + id + "\"";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        if(rs.next())  {
            String s = rs.getString(1).replace("-","");
            if(dob.equals(s)) return 1;
        }
        con.close();
        return 0;
    }
}




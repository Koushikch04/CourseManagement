package personPackage;

import AdditionalComponents.Error;
import AdditionalComponents.JdbcDetails;
import AdditionalComponents.Date;
import AdditionalComponents.Message;

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

    @Override
    public String toString(){
      return "ID:"+getTeacherID()+" name:"+getName()+" deptName:"+getDepartmentName()+" gender:"+getGender()+" salary:"+getSalary()+" dob:"+getDob()+" title:"+getTitle();
    }

    public String calculateAge() {
        LocalDate curDate = LocalDate.now();
        Period period = Period.between(LocalDate.parse(super.getDob()), curDate);
        String ans = "Dr. " + super.getName() + " is " + period.getYears() + " years " + period.getMonths() + " months and " + period.getDays() + " days.";
        return ans;
    }

    public static void updateViaCSV(String file) throws SQLException, FileNotFoundException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con= DriverManager.getConnection(url,UserName,PassWord);
        Scanner sc=new Scanner(new File("src/personPackage/"+file));
        String query="update Teacher set name=?,deptName=?,gender=?,salary=?,dob=? where teacherId=?";
        PreparedStatement ps= con.prepareStatement(query);
        while(sc.hasNextLine())
        {
            String[] str=sc.nextLine().split(",");
            String[] sr=str[5].split("-");
            int year=Integer.parseInt(sr[2]);
            int month=Integer.parseInt(sr[1]);
            int day=Integer.parseInt(sr[0]);
            java.sql.Date date= java.sql.Date.valueOf(year+"-"+month+"-"+day);
            ps.setString(1,str[1]);
            ps.setString(2,str[2]);
            ps.setString(3,str[3]);
            ps.setDouble(4,Double.parseDouble(str[4]));
            ps.setDate(5,date);
            ps.setString(6,str[0]);
            ps.executeUpdate();
        }
    }


    public static void addTeachers(String file) throws SQLException, FileNotFoundException {
        String url="jdbc:mysql://localhost:3306/"+ JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        Statement st = con.createStatement();
        String query = "create table if not exists Teacher (teacherId varchar(10) NOT NULL,name varchar(40) NOT NULL,deptName varchar(30) NOT NULL,gender varchar(30) NOT NULL,salary numeric(10,0) NOT NULL,dob Date,title varchar(30) NOT NULL,primary key(teacherId))";
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
        con.close();
    }

    public static void addTeacher(Teacher teacher) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query = "create table if not exists Teacher (teacherId varchar(10) NOT NULL,name varchar(40) NOT NULL,deptName varchar(30) NOT NULL,gender varchar(30) NOT NULL,salary numeric(10,0) NOT NULL,dob Date,title varchar(30) NOT NULL,primary key(teacherId))";
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
        con.close();
    }

    public static void removeTeacher(String teacherID) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query = "delete from Teacher where teacherId=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, teacherID);
        int x = ps.executeUpdate();
        if(x==0) {
            con.close();
            Message.noRecords();
        }
        con.close();
    }

    public static void removeTeachers() throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        Statement st = con.createStatement();
        String query = "truncate Teacher";
        st.executeUpdate(query);
        con.close();
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
        con.close();
        return teach;
    }
    public static ArrayList<Teacher> Search(String fieldName,String Search) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query = "select * from teacher where " +fieldName+"='"+Search+"'";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Teacher> teach = new ArrayList<>();
        while (rs.next()) {
            LocalDate ld=rs.getDate(6).toLocalDate();
            Teacher temp = new Teacher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), new Date(ld.getYear(),(short)ld.getDayOfMonth(),(short)ld.getDayOfMonth()), rs.getString(7));
            teach.add(temp);
        }
        if(teach.size()==0) {
            con.close();
            Message.noRecords();
        }
        con.close();
        return teach;
    }
    public static ArrayList<Teacher> partialSearch(String fieldName, String Search) throws SQLException {
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
        if(teach.size()==0) {
            con.close();
            Message.noRecords();
        }
        con.close();
        return teach;
    }


    public static ArrayList<Teacher> numericSearch(String fieldName,String value,String operation) throws SQLException {
        String url="jdbc:mysql://localhost:3306/"+JdbcDetails.getDatabase();
        String UserName= JdbcDetails.getUserName();
        String PassWord=JdbcDetails.getPassword();
        Connection con = DriverManager.getConnection(url, UserName, PassWord);
        String query = "select * from Teacher where "+fieldName;
        if(operation.equals("-gt")){
            query+=">"+Double.parseDouble(value);
        }
        else if(operation.equals("-lt")){
            query+="<"+Double.parseDouble(value);
        }
        else if(operation.equals("-e")){
            query+="="+Double.parseDouble(value);
        }
        else{
            Error.errorMsg("Invalid Oper");
        }
        Statement st = con.prepareStatement(query);
        ResultSet rs = st.executeQuery(query);
        ArrayList<Teacher> teach = new ArrayList<>();
        while(rs.next()){
            LocalDate ld=rs.getDate(6).toLocalDate();
            Teacher temp = new Teacher(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),new Date(ld.getYear(),(short)ld.getMonthValue(),(short)ld.getDayOfMonth()),rs.getString(7));
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
        String query = "select dob from teacher where teacherId=\"" + id + "\"";
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
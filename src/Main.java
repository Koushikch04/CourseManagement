
import AdditionalComponents.Login;
import AdditionalComponents.Message;
import CommandLine.*;
import Courses.*;
import personPackage.Student;
import personPackage.Teacher;

import java.io.FileNotFoundException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.*;
import AdditionalComponents.Date;

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length == 1 && args[0].equals("-h")) {
            CommandLineArguments commandLineArguments = new CommandLineArguments();
            System.out.println(commandLineArguments);

        }
        if (args[1].equals("Students")) {
            StudentsCommands.connect(args);
        } else if (args[1].equals("Teachers")) {
            TeachersCommands.connect(args);
        } else if(args[1].equals("Courses")) {
            CoursesCommand.connect(args);
        }
//        if (args.length == 1 && args[0].equals("-h")) {
//            CommandLineArguments commandLineArguments = new CommandLineArguments();
//            System.out.println(commandLineArguments);
//        }
//
//        if (args[1].equals("Students")) {
//            StudentsCommands.connect(args);
//        } else if (args[1].equals("Teachers")) {
//            TeachersCommands.connect(args);
//        }
//        courses.UpdateCourses("C100","title","ADSA");
//        courses.studentCourses("S20210010007");
//        Student.authentication("S20210010007","2002-04-24");
//        Login.log("Teacher");
//        courses.removeAllCourses();
//        Message.removed();
//        courses.addCourses("courses.csv");
//        System.out.println(Teacher.authentication("adf","20211010"));
//        Student.studentCourses("S20210010120");
//        Student.StrongSearch("name","kou");
//        ArrayList<Student> al=Student.StrongSearch("name","x");
//        Iterator<Student> it=al.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//        Student.addStudents("Students.csv");
//        Student.updateViaID("Students.csv");
//        Teacher.updateViaID("Teachers.csv");
//        Student.update("S20210010007","dob","2004-04-24");
//        CommandLineArguments cs=new CommandLineArguments();
//        System.out.println(cs);
//        ArrayList<Teacher> teach = Teacher.numericSearch("salary","100000.000","-e");
//        ArrayList<courses> teach = courses.Search("title", "ADSA");
//        Iterator<courses> it = teach.iterator();
//        courses.UpdateCourses("C02","title","koushik");
//        courses.updateViaCsv("courses.csv");
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//        courses.addCourses("courses.csv");
//        courses cs = new courses("C14","I12","AD","Advanced Structures","CSE",4);
//        courses.removeAllCourses();

    }
}
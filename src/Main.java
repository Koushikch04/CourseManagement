
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
//        if (args.length == 1 && args[0].equals("-h")) {
//            CommandLineArguments commandLineArguments = new CommandLineArguments();
//            System.out.println(commandLineArguments);
//            return;
//        }
//        if (args[1].equals("Students")) {
//            StudentsCommands.connect(args);
//        } else if (args[1].equals("Teachers")) {
//            TeachersCommands.connect(args);
//        }
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
//        Student.studentCourses("S20210010122");
//        ArrayList<courses> al=courses.Search("courseId","C");
//        Iterator<courses> it=al.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//        Student.updateViaID("Students.csv");
        Teacher.updateViaID("Teachers.csv");
//        Student.update("S20210010007","dob","2004-04-24");
//        CommandLineArguments cs=new CommandLineArguments();
//        System.out.println(cs);
    }
}

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
//        Date d1=new Date(2004, (short) 06, (short) 31);
//        System.out.println(Teacher.authentication("adf","20211010"));
//        System.out.println("ABBOJU RAVI TEJA           ".trim());
//        Assignments.addAssignments("ksd");
//        courses.addCourses("courses.csv");
        Student.addStudents("Students.csv");
        }

}

import CommandLine.*;
import personPackage.Student;
import personPackage.Teacher;

import java.io.FileNotFoundException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException {
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


//        ArrayList<Student> ar = Student.SortByDob();

        ArrayList<Student> ar = Student.SortByBranch();

        Iterator<Student> it=ar.iterator();
        while(it.hasNext())
        {
            Student stud= (Student) it.next();
            System.out.println(stud.getStudID()+" "+stud.getName()+" "+stud.getDob()+" "+stud.getBranch()+" "+stud.getGender());
        }


//        ArrayList<Teacher> al=Teacher.SortByDob();
//        Iterator<Teacher> it=al.iterator();
//        while(it.hasNext())
//        {
//            Teacher t1=it.next();
//            System.out.println(t1.getTeacherID()+" "+t1.getName()+" "+t1.getDepartmentName()+" "+t1.getGender()+" "+t1.getDob());
//        }
    }
}
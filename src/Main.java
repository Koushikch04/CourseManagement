
import CommandLine.*;
import personPackage.Student;
import personPackage.Teacher;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if(args.length==1 && args[0].equals("-h")) {
            CommandLineArguments commandLineArguments = new CommandLineArguments();
            System.out.println(commandLineArguments);
            return;
        }
        if(args[1].equals("Students")) {
            StudentsCommands.connect(args);
        } else if(args[1].equals("Teachers")) {
            TeachersCommands.connect(args);
        }
//        ArrayList<Student> ar = Student.SortByBranch();
//        Iterator<Student> it=ar.iterator();
//        while(it.hasNext())
//        {
//            Student stud= (Student) it.next();
//            System.out.println(stud.getStudID()+" "+stud.getName()+" "+stud.getDob()+" "+stud.getBranch()+" "+stud.getGender());
//        }
    }
}
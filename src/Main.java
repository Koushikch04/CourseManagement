
import CommandLine.*;
import personPackage.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        if(args.length==2) {
            if(args[0].equals("-add")) {
                if(args[1].equals("Student")) AddStudentCommand.add(args);
                else if(args[1].equals("Teacher")) AddTeacherCommand.add(args);
            }
        } else if(args.length==3) {
            if(args[0].equals("-add")) {
                if(args[1].equals("Students")) AddStudentCommand.add(args);
                else if(args[1].equals("Teachers")) AddTeacherCommand.add(args);
            }
        }
    }
}
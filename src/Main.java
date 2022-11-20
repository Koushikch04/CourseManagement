
import AdditionalComponents.Login;
import CommandLine.*;
import personPackage.Student;
import personPackage.Teacher;

import java.io.FileNotFoundException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length == 1 && args[0].equals("-h")) {
            CommandLineArguments commandLineArguments = new CommandLineArguments();
            System.out.println(commandLineArguments);
            return;
        }
        if (args[1].equals("Students")) {
            StudentsCommands.connect(args);
        } else if (args[1].equals("Teachers")) {
            TeachersCommands.connect(args);
        }
//        Login.log("Teacher");
//        System.out.println(Teacher.authentication("adf","20211010"));
//        CommandLineArguments cs=new CommandLineArguments();
//        System.out.println(cs);
    }
}
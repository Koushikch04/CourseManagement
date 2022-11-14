
import CommandLine.*;

public class Main {

    public static void main(String[] args) {
        if(args.length==1 && args[0].equals("-h")) {
            CommandLineArguments commandLineArguments = new CommandLineArguments();
            System.out.println(commandLineArguments);
            return;
        }
        if(args[1].equals("Student")) {
            StudentsCommands.connect(args);
        } else if(args[1].equals("Teacher")) {
            TeachersCommands.connect(args);
        }
    }
}
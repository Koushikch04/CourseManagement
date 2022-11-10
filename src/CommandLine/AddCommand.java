package CommandLine;
import personPackage.*;
import Graphics.*;
public class AddCommand {
    public static void add(String[] args) {
        if(args.length==2) {
            if(args[1].equals("Student")) {

                Student stud = StudentGUI.addStudentGUI();
                System.out.println(stud.getName() + " HI " + stud.getStudID() + " " + stud.getBranch() + " " + stud.getGender() + " " + stud.getDob());
            }
        }
    }
}

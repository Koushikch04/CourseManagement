package CommandLine;

public class CommandLineArguments {


    public String toString() {
        String s = "";
        s += "-add Student                  : For adding a particular Student!\n";
        s += "-add Students <filename>      : For adding students data through CSV File!\n";
        s += "-add Teacher                  : For adding a particular teacher!\n";
        s += "-add Teacher <filename>       : For adding teachers data through CSV File!\n";
        s += "-add Courses <filename>       : For adding the courses through CSV File!\n";
        s += "-rmv Student <studID>         : For removing student with the following studID!\n";
        s += "-rmv Teacher <teacherID>      : For removing Teacher with the following teacherID!\n";
        s += "-rmv <courseID> <branch>      : For removing course with courseID from the following branch!\n";
        s += "-details Students             : For displaying the details of all the students!\n";
        s += "-details Teacher              : For displaying the details of all the teachers!\n";
        s += "-details Student <studID>     : For displaying the details of a particular student with the given studID!\n";
        s += "-details Teacher <teacherID>  : For displaying the details of a particular teacher with the given teacherID!\n";
        s += "-h                            : For displaying all the command line functions!\n";
        return s;
    }
}

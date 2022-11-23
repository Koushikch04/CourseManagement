package CommandLine;

public class CommandLineArguments {

    public String toString() {

        String s = "";
        s += "-add <person>                                             : For adding a particular person(Student or Teacher) or course!\n";
        s += "-add <person> <filename>                                  : For adding person(Student or Teacher) or course data through the given CSV File!\n";
        s += "-update <object> <filename>                               : For updating the records of particular object database via csv file";
        s += "-update <object> <id> <fieldname> <newValue>              : For updating the particular field of the given object\n";
        s += "-partialSearch <object> <fieldname> <value>               : For searching and printing the details of all the objects that contain the given string partially in the given field\n";
        s += "-numericSearch <object> <fieldname> <value> <operation>   : For searching and printing the object details whose given fieldValues satisfy the condition\n";
        s += "-student Courses <studId>                                : For displaying all the courses that the student is taking\n";
        s += "-rmv <person>                                             : For removing details of all the person(Student or Teacher) or course!\n";
        s += "-rmv <person> <id>                                        : For removing the person(Student or Teacher) or course data with the following id!\n";
        s += "-details <person>                                         : For displaying the details of all the person(Student or Teacher) or courses!\n";
        s += "-sort <person> <fieldName> <order>                        : For displaying the details of all person(Student or Teacher) or course sorted by the\n";
        s += "                                                           given field name\n";
        s += "-search <person> <fieldName> <fieldValue>                 : For searching and printing(if found) the details of the given person(Student and Teacher)\n";
        s += "                                                           with the same fieldValue\n";
        s += "-h                                                        : For displaying all the command line functions!\n";
        return s;
    }
}

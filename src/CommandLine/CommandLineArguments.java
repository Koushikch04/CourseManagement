package CommandLine;

public class CommandLineArguments {

    public String toString() {

        String s = "";
        s += "                                            A GUIDE ON HOW TO USE THIS PROJECT\n";
        s += "OBJECT:-\n";
        s += "        There are total 3 objects:-\n";
        s += "                                    1.Students\n";
        s += "                                              Fields:-\n";
        s += "                                                      1.name\n";
        s += "                                                      2.gender\n";
        s += "                                                      3.dob\n";
        s += "                                                      4.studId\n";
        s += "                                                      5.deptName\n";
        s += "                                    2.Teachers\n";
        s += "                                              Fields:-\n";
        s += "                                                      1.name\n";
        s += "                                                      2.gender\n";
        s += "                                                      3.dob\n";
        s += "                                                      4.teacherId\n";
        s += "                                                      5.deptName\n";
        s += "                                                      6.salary\n";
        s += "                                                      5.title\n";
        s += "                                    3.Courses\n";
        s += "                                              Fields:-\n";
        s += "                                                      1.courseId\n";
        s += "                                                      2.InstructorId\n";
        s += "                                                      3.title\n";
        s += "                                                      4.abbreviation\n";
        s += "                                                      5.deptName\n";
        s += "                                                      6.credits\n";
        s += "IMPORTANT THINGS TO KEEP IN MIND:-\n";
        s += "                                   1.For adding a object, removing a object or updating a object admin authentication is required.\n";
        s += "                                     Admin:-\n";
        s += "                                           UserName:- iiits\n";
        s += "                                           Password:- iiits@2022\n";
        s += "                                   2.The command line arguments are case sensitive so you need to write the parameters correctly!\n";
        s += "                                   3.Operations for numeric search are:-\n";
        s += "                                                                        1. -gt : means greater than or equal to\n";
        s += "                                                                        2. -lt : means lesser than or equal to\n";
        s += "                                   4.Operations for sorting are:-\n";
        s += "                                                                 1.  -asc :  means in ascending order\n";
        s += "                                                                 2.  -desc:  means in descending order\n";
        s+="                                                                   3.  -e   :  means equals to\n";
        s += "                                    5.CSV files for different objects are:";
        s+="                                                                           1.Students.csv\n";
        s+="                                                                           2.Teachers.csv\n";
        s+="                                                                           3.courses.csv\n";
        s += "                                                                                                                                   \n";
        s += "                                              BELOW ARE THE COMMAND LINE ARGUMENTS\n";
        s += "-add <person>                                             : For adding a particular person(Student or Teacher) or course!\n";
        s += "-add <person> <filename>                                  : For adding person(Student or Teacher) or course data through the given CSV File!\n";
        s += "-update <object> <filename>                               : For updating the records of particular object database via csv file\n";
        s += "-update <object> <id> <fieldname> <newValue>              : For updating the particular field of the given object\n";
        s += "-partialSearch <object> <fieldname> <value>               : For searching and printing the details of all the objects that contain the given string partially in the given field\n";
        s += "-numericSearch <object> <fieldname> <value> <operation>   : For searching and printing the object details whose given (int or double) fieldValues satisfy the condition\n";
        s += "-student Courses <studId>                                 : For displaying all the courses that the student is taking\n";
        s += "-rmv <object>                                             : For removing all the details of a object!\n";
        s += "-rmv <object> <id>                                        : For removing the object with the following id!\n";
        s += "-details <person>                                         : For displaying the all details of the object!\n";
        s += "-sort <object> <fieldName> <order>                        : For displaying the all details of the object sorted by the\n";
        s += "                                                            given field name\n";
        s += "-search <object> <fieldName> <fieldValue>                 : For searching and printing(if found) the details of the given object\n";
        s += "                                                            with the given fieldValue\n";
        s += "-h                                                        : For displaying the guide!\n";
        s += "\n";
        s += "Examples:-\n";
        s += "           Adding:-\n";
        s += "                    -add Students Students.csv\n";
        s += "                    -add Teachers\n";
        s += "           Updating:-\n";
        s += "                     -update Students Students.csv\n";
        s += "                     -update Courses c101 InstructorId I101\n";
        s += "           partialSearch:-\n";
        s += "                     -partialSearch Teachers name Dr.\n";
        s += "           numericSearch:-\n";
        s += "                     -numericSearch Teachers salary 1000 -gt\n";
        s += "           for seeing the courses of a student:-\n";
        s += "                     -student Courses S201\n";
        s += "           removing:-\n";
        s += "                      -rmv Courses\n";
        s += "                      -rmv Students S201\n";
        s += "           sorting:-\n";
        s += "                      -sort Students name asc\n";
        s += "           searching:-\n";
        s += "                      -search Students name Sandeep\n";
        s += "           help:-\n";
        s += "                      -h\n";
        return s;
    }
}
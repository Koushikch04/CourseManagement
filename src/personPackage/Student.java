package personPackage;
import java.time.*;

public class Student extends Person{
    private String studID;
    private String branch;

    public Student(String name, String gender, LocalDate dob, String studID, String deptName) {
        super(name, gender, dob);
        this.studID = studID;
        this.branch = deptName;
    }

    public String getStudID() {
        return studID;
    }

    public void setStudID(String studID) {
        this.studID = studID;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String calculateAge() {
        LocalDate curDate = LocalDate.now();
        Period period = Period.between(super.getDob(), curDate);
        String ans = super.getName() + " is " + period.getYears() + " years " + period.getMonths() + " months and " + period.getDays() + " days.";
        return ans;
    }

    public static void addStudent(Student student) {}
    public static void removeStudent(Student student) {}
}


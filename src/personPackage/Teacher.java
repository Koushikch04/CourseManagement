package personPackage;

import java.time.LocalDate;
import java.time.Period;

public class Teacher extends Person{
    private String teacherID;
    private String departmentName;

    public Teacher(String name, String gender, LocalDate dob, String teacherID, String deptName) {
        super(name, gender, dob);
        this.teacherID = teacherID;
        this.departmentName = deptName;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String calculateAge() {
        LocalDate curDate = LocalDate.now();
        Period period = Period.between(super.getDob(), curDate);
        String ans = "Dr. " + super.getName() + " is " + period.getYears() + " years " + period.getMonths() + " months and " + period.getDays() + " days.";
        return ans;
    }

    public static void addTeacher(Teacher teacher) {
        System.out.println("Teacher added");
    }
    public static void removeTeacher(Teacher teacher) {}
}

import personPackage.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Admin admin = new Admin();
        Teacher teacher = new Teacher("Arjit", "Male", LocalDate.of(1990,10,12), "T1010", "CSE");
        System.out.println("Dr. Arjit Roy is 41 years 0 months and 14 days.");
        Teacher.addTeacher(teacher);
        System.out.println(admin.authentication("Nightmare","iiiTs@218" ));
    }
}
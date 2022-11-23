package personPackage;

import AdditionalComponents.Date;

abstract public class Person {
    private String name;
    private String gender;
    private Date dob;

    public Person() {};
    public Person(String name, String gender, Date dob) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob.getYear()+"-"+dob.getMonth()+"-"+dob.getDay();
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    abstract String calculateAge();
}
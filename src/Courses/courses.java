package Courses;
//course(course id, title, dept name, credits)
public class courses {
     private int courseId;
     private String title;
     private String deptName;
     private int credits;
      public courses() {
      }
      public courses(int courseId,String title,String deptName,int credits) {
          setCourseId(courseId);
          setCredits(credits);
          setTitle(title);
          setDeptName(deptName);
      }
    public int getCourseId() {
        return courseId;
    }
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public static void addCourses(int courseId,String title,String deptName,int credits)
    {

    }
    @Override
    public String toString() {
        return "courseId:"+getCourseId()+" title:"+getTitle()+" deptName:"+getDeptName()+" credits:"+getCredits();
    }
}

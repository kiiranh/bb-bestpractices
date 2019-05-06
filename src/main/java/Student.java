import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Student {
    private String name;
    private double gpa;
    private /*final*/ List<String> courses; // prevents mutating pointer, not the list...

    static void isValid(String name, double gpa, List<String> courses) {
        if (name == null || name.isEmpty() || name.isBlank() || gpa < 0 || gpa > 4)
            throw new IllegalArgumentException();

    }

    // DON'T use non-private constructors (unless protected for child classes, but don't use inhertance)
    public Student(String name, double gpa, String ... courses) {
//        String [] theCourses = courses;
//        List<String> theCourses = Arrays.asList(courses);
        List<String> theCourses = List.of(courses);
        isValid(name, gpa, theCourses);
        this.name = name;
        this.gpa = gpa;
        this.courses = theCourses;
    }

    public Student addCourse(String course) {
        List<String> newCourseList = new ArrayList<>(this.courses);
        newCourseList.add(course);

        return new Student(this.name, this.gpa, newCourseList.toArray(new String[]{}));
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        isValid(name, this.gpa, this.courses);
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

//    public void setGpa(double gpa) {
//        this.gpa = gpa;
//    }

    public List<String> getCourses() {
//        return Collections.unmodifiableList(courses);
        return courses; // Big Red Flag, if mutable, just exposed, and bypassed validations
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    static {
        new Student("Fred", 3.7, new String[]{"Math", "Physics"});
        new Student("Fred", 3.7, List.of("Math", "Physics").toArray(new String[]{}));
    }

}

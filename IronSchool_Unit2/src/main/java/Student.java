import java.util.ArrayList;
import java.util.UUID;

public class Student {
    private String studentId;
    private String name;
    private String address;
    private String email;
    private ArrayList<Course> course;


    public Student(String name, String address, String email) {
        this.studentId = generateId();
        this.name = name;
        this.address = address;
        this.email = email;
        this.course = new ArrayList<>();
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Course> getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course.add(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", course=" + course +
                '}';
    }
}

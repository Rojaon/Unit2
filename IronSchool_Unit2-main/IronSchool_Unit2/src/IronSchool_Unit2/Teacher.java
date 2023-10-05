package IronSchool_Unit2;
import java.util.UUID;


public class Teacher {
    private String teacherId;
    private String name;
    private double salary;

    public Teacher(String name, double salary) { // constructor

        this.teacherId = generateTeacherId();
        this.name = name;
        this.salary = salary;
    }

    public String getTeacherId() { // Getter for teacherId
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() { // Getter for name
        return name;
    }

    public void setName(String name) { // Setter for name
        this.name = name;
    }

    public double getSalary() { // Getter for salary
        return salary;
    }

    public void setSalary(double salary) { // Setter for salary
        this.salary = salary;
    }

// Private method to generate a unique teacherId
    private String generateTeacherId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }}
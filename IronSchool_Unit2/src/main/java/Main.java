
import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static String schoolName;
    public static HashMap<String,Teacher> teachers =new HashMap<>();
    public static HashMap<String,Course> courses =new HashMap<>();
    public static HashMap<String,Student> students =new HashMap<>();

    public static double profit;
    public static double totalMoneyEarned;
    public static double totalTeacherSalaries;

    public static void main(String[] args) {

        InputData("Enter Number of Teacher: \n",
                "Enter Number of Courses: \n","Enter Number of Students: \n");

//     ========================= Start JFrame   =========================
        SwingUtilities.invokeLater(CommandMenu::new);


        teachers.forEach((key, value) -> {
            System.out.println("teachers\nKey: " + key + ", Value: " + value);
        });
        courses.forEach((key, value) -> {
            System.out.println("courses\nKey: " + key + ", Value: " + value);
        });
  students.forEach((key, value) -> {
            System.out.println("students\nKey: " + key + ", Value: " + value);
        });

    }


    private static void InputData(String... questions) {
        int switcher = 1;
        int input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter School name: ");
        schoolName = scanner.nextLine();

        for(String question: questions) {
            while (true) {
                System.out.println(question);
                if (scanner.hasNextInt()) {
                    input = scanner.nextInt();
                        createObjects(input,switcher);
                        System.out.println("done with: "+switcher);
                        switcher++;
                    break;
                } else {
                    System.out.println("That's not a valid number. Try again.");
                    scanner.next(); // Clear the invalid input
                }
            }
        }
    }

    private static void createObjects(int number, int switcher){
        Scanner scanner = new Scanner(System.in);
        switch (switcher){

            case 1:
                for (int i =0; i<number; i++){
                    System.out.println("Enter teacher name:\n");
                    String name =  scanner.nextLine();
                    System.out.println("Enter teacher "+name+" salary:\n");
                    double salary =  scanner.nextDouble();
                    scanner.nextLine();
                    Teacher teacherObj = new Teacher(name,salary);
                    teachers.put(teacherObj.getTeacherId(),teacherObj);


                }
                break;
            case 2:
                for (int i =0; i<number; i++){
                    System.out.println("Enter course name:\n");
                    String name =  scanner.nextLine();
                    System.out.println("Enter "+name+" course price:\n");
                    double price =  scanner.nextDouble();
                    scanner.nextLine();
                    Course courseObj = new Course(name,price);
                    courses.put(courseObj.getCourseId(),courseObj);


                }
                break;

            default:
                for (int i =0; i<number; i++){
                    System.out.println("Enter student name:\n");
                    String name =  scanner.nextLine();
                    System.out.println("Enter "+name+" email:\n");
                    String  email =  scanner.nextLine();
                    System.out.println("Enter "+name+" adress:\n");
                    String  address =  scanner.nextLine();
                    Student studentObj = new Student(name,address,email);
                    students.put(studentObj.getStudentId(),studentObj);


                }

        }

    }

    public static void profit(){
        // Show Profit

        totalMoneyEarned = 0.0;
       totalTeacherSalaries = 0.0;
        for (Course course : courses.values()) {
            totalMoneyEarned += course.getMoney_earned();
        }

        for (Teacher teacher : teachers.values()) {
            totalTeacherSalaries += teacher.getSalary();
        }


        System.out.println("totalMoneyEarned:"+totalMoneyEarned+"|| totalTeacherSalaries: "+totalTeacherSalaries);
         profit = totalMoneyEarned - totalTeacherSalaries;
        System.out.println("Total Profit: $" + profit);
    }
}

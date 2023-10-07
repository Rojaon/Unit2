
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static HashMap<String,Teacher> teachers =new HashMap<>();
    public static HashMap<String,Course> courses =new HashMap<>();
    public static HashMap<String,Student> students =new HashMap<>();

    public static void main(String[] args) {

                getInputData("Enter School name: \n", "Enter number of teacher: \n",
                "Enter number of courses: \n","Enter number of Students: \n");

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



    private static void getInputData(String... questions) {
        int switcher = 1;
        Scanner scanner = new Scanner(System.in);
        List<String> inputData = new ArrayList<>();
        for(String question: questions) {
            System.out.println(question);
            inputData.add(scanner.nextLine());
            if(inputData.size() > 1){
            creatObjects(Integer.parseInt(inputData.get(switcher)),switcher);
            System.out.println("done with: "+switcher);
            switcher++;}
        }

//        return inputData;
    }

    private static void creatObjects(int number, int switcher){
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


}

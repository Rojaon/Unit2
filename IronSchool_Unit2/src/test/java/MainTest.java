import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private static HashMap<String,Teacher> teachers =new HashMap<>();
    private static HashMap<String,Course> courses =new HashMap<>();
    private  double profit;
    private double totalMoneyEarned;
    private double totalTeacherSalaries;

    @BeforeAll
    public static void beforeAll() {
        teachers.put("t1",new Teacher("Ahmed Mosa",550));
        teachers.put("t2",new Teacher("Mosa Ahmed",400));
        Course c1 = new Course("Java",400);
        Course c2 = new Course("SQL",350);
        courses.put("c1",c1);
        courses.put("c2",c2);
// when student enroll to a course
        c1.setMoney_earned(c1.getMoney_earned() + c1.getPrice());
        c2.setMoney_earned(c2.getMoney_earned() + c2.getPrice());
    }

    @Test
    public void isEmailValid_correctEmail(){
        boolean isEmailValid = Main.patternMatches("Ariij@gmail.com",Main.regexPattern);
        assertTrue(isEmailValid);
    }
    @Test
    public void isEmailValid_notCorrectEmail(){
        boolean isEmailValid = Main.patternMatches("Ariijgmail",Main.regexPattern);
        assertFalse(isEmailValid);
    }

    @Test
    public void calculate_CorrectProfit(){
        totalMoneyEarned = 0.0;
        totalTeacherSalaries = 0.0;

        for (Course course : courses.values()) {
            totalMoneyEarned += course.getMoney_earned();
        }
        for (Teacher teacher : teachers.values()) {
            totalTeacherSalaries += teacher.getSalary();
        }
        profit = totalMoneyEarned - totalTeacherSalaries;
        assertEquals(-200,profit);
    }

}
# School Management System

This School Management System is an application that allows users to manage teachers, courses, and students. The application provides a simple graphical user interface (GUI) to perform various operations related to school management, such as enrolling students in courses, assigning teachers to courses, looking up course or student information, and more.

## Table of Contents
- [Features](#Features)
   - [Additional Commands](#Additional_Commands)
- [Code Structure](#Code_Structure)
- [How to Use](#How_to_Use)
- [UML](#UML)
- [Contributors](#Contributors)


## Features:
The School Management System provides the following features:

1. Enroll Students: Enroll students in courses by specifying their student ID and the course ID.

2. Assign Teachers: Assign teachers to courses by specifying their teacher ID and the course ID.

3. Show Courses: View a list of all available courses, including their names and prices.

4. Lookup Course: Look up detailed information about a specific course, including its name, price, and assigned teacher (if any).

5. Show Students: View a list of all registered students, including their IDs, names, addresses, and email addresses.

6. Lookup Student: Look up detailed information about a specific student, including their name, email, and address.

7. Show Teachers: View a list of all teachers, including their names and salaries.

8. Lookup Teacher: Look up detailed information about a specific teacher, including their name and salary.

9. Show Profit: Display the total profit earned by the school.
    


### Additional Commands

10. SHOW STUDENTS [COURSE_ID]: Display a list of students enrolled in a specific course. Provide the course ID as an argument to see the enrolled students.

11. SHOW MONEY EARNED: Show the total revenue earned by the school from course fees.

12. SHOW MONEY SPENT: Display the total amount spent by the school, such as teacher salaries and other expenses.

- These additional commands enhance the system's capabilities and provide more detailed information about students, finances, and expenses.


## Code Structure
The code is organized into three main classes:

- The *Teacher*, *Course*, and *Student* classes represent the core entities in the school management system. They contain attributes and methods to manage teachers, courses, and students.

- The *CommandMenu* class handles the graphical user interface and provides methods for user interaction.

- The *Main* class is the entry point for the application. It initializes and manages teacher, course, and student data and launches the user interface.


## How to Use
The School Management System provides a user-friendly graphical interface that allows you to perform various tasks. When you run the program, you'll see a menu with options such as "ENROLL student," "ASSIGN teacher," "SHOW COURSES," and more. Follow these steps to use the application:

1. Start the application by running Main.java.
   
2. Enter the *Teacher*, *Course*, and *Student* information. 

3. The main menu will appear, displaying a list of available actions.

4. Select an option by clicking on it.

5. Follow the prompts and input fields to complete the chosen action.

6. Use the "Go Back" button to return to the main menu after performing an action.

7. You can manage teachers, courses, and students by enrolling, assigning, looking up, and more.


## UML 
   ![School](https://github.com/lateefaha1/IronSchool_Unit2/assets/108286044/a5d80819-b8b9-4e32-849b-eef96f06248f)

   ![School System Class Diagrams](https://github.com/lateefaha1/IronSchool_Unit2/assets/108286044/c5ab887d-ae52-46c0-bef9-02386f71ab57)



## Contributors

- Arijj Qadah
- Dhuha Alsulami
- Huda Ayoub
- Latifah Alkhamis

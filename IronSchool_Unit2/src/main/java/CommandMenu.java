import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class CommandMenu {

    private JFrame menuFrame;
    private JFrame executionFrame;
    private JList<String> menuList;
    private DefaultListModel<String> listModel;
    private JButton selectBtn;
    private JButton executeBtn;
    private  JButton goBackButton;
    public CommandMenu() {
        menuFrame = new JFrame(Main.schoolName+" Menu Navigation");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(450, 400);

        // Get the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calculate the frame's position to center it
        int x = (screenSize.width - menuFrame.getWidth()) / 2;
        int y = (screenSize.height - menuFrame.getHeight()) / 2;

        // Set the new frame location
        menuFrame.setLocation(x, y);

        listModel = new DefaultListModel<>();
        listModel.addElement("ENROLL STUDENT TO COURSE");
        listModel.addElement("ASSIGN TEACHER TO COURSE");
        listModel.addElement("SHOW COURSES");
        listModel.addElement("LOOKUP COURSE");
        listModel.addElement("SHOW STUDENTS");
        listModel.addElement("LOOKUP STUDENT");
        listModel.addElement("SHOW TEACHERS");
        listModel.addElement("LOOKUP TEACHER");
        listModel.addElement("SHOW STUDENTS IN COURSE");
        listModel.addElement("SHOW PROFIT");
        listModel.addElement("SHOW MONEY EARNED");
        listModel.addElement("SHOW MONEY SPENT");

        menuList = new JList<>(listModel);
        menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        menuList.setSelectedIndex(0);

        selectBtn = new JButton("Select");

        menuFrame.add(new JScrollPane(menuList));
        menuFrame.add(selectBtn, BorderLayout.SOUTH);
        menuFrame.setVisible(true);

        executionFrame = new JFrame(Main.schoolName);
        executionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        executionFrame.setLocation(x, y);

        executionFrame.setSize(500, 400);
        executionFrame.setLayout(new FlowLayout());
        goBackButton = new JButton("Go Back");


        selectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = menuList.getSelectedValue();

                switch (selectedOption) {
                    case "ENROLL STUDENT TO COURSE":

                            enrollStudent();

                        break;
                    case "ASSIGN TEACHER TO COURSE":
                        assignTeacher();
                        break;
                    case "SHOW COURSES":
                        showCourses();
                        break;
                    case "LOOKUP COURSE":
                        lookupCourse();
                        break;
                    case "SHOW STUDENTS":
                        showStudents();
                        break;
                    case "LOOKUP STUDENT":
                        lookupStudent();
                        break;
                    case "SHOW TEACHERS":
                        showTeachers();
                        break;
                    case "LOOKUP TEACHER":
                        lookupTeacher();
                        break;
                    case "SHOW STUDENTS IN COURSE":
                    showٍStudentsByCourseId();
                    break;
                    case "SHOW PROFIT":
                    showProfit();
                    break;

                    case "SHOW MONEY EARNED":
                    showMoneyEarned();
                    break;

                    case "SHOW MONEY SPENT":
                    showMoneySpent();
                    break;

                }
            }
        });
    }

    //      ================================================= REFACTOR CODE   =================================================

    private void enrollStudent() {

        System.out.println(Main.students);
        menuFrame.setVisible(false);

        JLabel stLabel = new JLabel("Enter Student Id: ");
        JTextField stIdField = new JTextField(30);
        stIdField.setPreferredSize(new Dimension(150, 25));
//                    ************************************************
        JLabel coLabel = new JLabel("Enter Course Id: ");
        JTextField coIdField = new JTextField(30);
        coIdField.setPreferredSize(new Dimension(150, 25));

        executeBtn= new JButton("Enroll Student");


        executeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String stId = stIdField.getText();
                String coId = coIdField.getText();
                Course courseToEnroll = Main.courses.get(coId);
                Student student = Main.students.get(stId);
                if (courseToEnroll == null || student == null) {
                    JOptionPane.showMessageDialog(null, "Both course and student were not found!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

//                    if student is already enrolled don't add course and don't update earned money
                    if(!student.getCourse().contains(courseToEnroll)) {
                        student.setCourse(courseToEnroll);
                        courseToEnroll.setMoney_earned(courseToEnroll.getMoney_earned() + courseToEnroll.getPrice());
                    }

                    JOptionPane.showMessageDialog(null, "Student enrolled", "Success", JOptionPane.INFORMATION_MESSAGE);
                    menuFrame.setVisible(true);
                    executionFrame.setVisible(false);
                    executionFrame.remove(stLabel);
                    executionFrame.remove(stIdField);
//                    *************************
                    executionFrame.remove(coLabel);
                    executionFrame.remove(coIdField);
                    executionFrame.remove(executeBtn);
                    executionFrame.remove(goBackButton);

                }
            }
        });

        // Create a "Go Back" button
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executionFrame.dispose();
                menuFrame.setVisible(true);

                executionFrame.remove(stLabel);
                executionFrame.remove(stIdField);
//                    *************************
                executionFrame.remove(coLabel);
                executionFrame.remove(coIdField);
                executionFrame.remove(executeBtn);
                executionFrame.remove(goBackButton);
            }
        });

        executionFrame.add(stLabel);
        executionFrame.add(stIdField);
//                    *************************
        executionFrame.add(coLabel);
        executionFrame.add(coIdField);
        executionFrame.add(executeBtn);
        executionFrame.add(goBackButton);
        executionFrame.setVisible(true);
    }

    private void assignTeacher() {

        menuFrame.setVisible(false);

        JLabel teacherLabel = new JLabel("Enter Teacher Id: ");
        JTextField teacherIdField = new JTextField(30);
        teacherIdField.setPreferredSize(new Dimension(150, 25));
//                    ************************************************
        JLabel coLabel = new JLabel("Enter Course Id: ");
        JTextField coIdField = new JTextField(30);
        coIdField.setPreferredSize(new Dimension(150, 25));

        executeBtn= new JButton("Assign Teacher");

        executeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String teacherId = teacherIdField.getText();
                String coId = coIdField.getText();
                Course courseToAssign = Main.courses.get(coId);
                Teacher teacher = Main.teachers.get(teacherId);
                if (courseToAssign == null || teacher == null) {
                    JOptionPane.showMessageDialog(null, "Both course and student were not found!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    courseToAssign.setTeacher(teacher);
                    JOptionPane.showMessageDialog(null, "Teacher Assigned", "Success", JOptionPane.INFORMATION_MESSAGE);
                    menuFrame.setVisible(true);
                    executionFrame.setVisible(false);
                    executionFrame.remove(teacherLabel);
                    executionFrame.remove(teacherIdField);
//                    *************************
                    executionFrame.remove(coLabel);
                    executionFrame.remove(coIdField);
                    executionFrame.remove(executeBtn);

                }
            }
        });


        // Create a "Go Back" button
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executionFrame.dispose();
                menuFrame.setVisible(true);

                executionFrame.remove(teacherLabel);
                executionFrame.remove(teacherIdField);
//                    *************************
                executionFrame.remove(coLabel);
                executionFrame.remove(coIdField);
                executionFrame.remove(executeBtn);
                executionFrame.remove(goBackButton);
            }
        });


        executionFrame.add(teacherLabel);
        executionFrame.add(teacherIdField);
//                    *************************
        executionFrame.add(coLabel);
        executionFrame.add(coIdField);
        executionFrame.add(executeBtn);
        executionFrame.add(goBackButton);
        executionFrame.setVisible(true);
    }

    private void showCourses() {
        menuFrame.setVisible(false);
        JTextArea coursesTextArea = new JTextArea(15, 40);
        coursesTextArea.setEditable(false);
        StringBuilder coursesText = new StringBuilder();

        for (Map.Entry<String, Course> entry : Main.courses.entrySet()) {
            Course course = entry.getValue();
            String courseName = course.getName();
            double coursePrice = course.getPrice();
            coursesText.append("Name: ").append(courseName).append(", Price: ").append(coursePrice).append("\n");
        }

        coursesTextArea.setText(coursesText.toString());

        JScrollPane scrollPane = new JScrollPane(coursesTextArea);

        // Create a "Go back" button

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executionFrame.dispose();
                menuFrame.setVisible(true);
                executionFrame.remove(scrollPane);
                executionFrame.remove(goBackButton);

            }
        });

        executionFrame.add(scrollPane, BorderLayout.CENTER);
        executionFrame.add(goBackButton, BorderLayout.SOUTH);

        executionFrame.setVisible(true);

    }
    private void lookupCourse() {

        menuFrame.setVisible(false);

        JLabel coLabel = new JLabel("Enter Course Id: ");
        JTextField coIdField = new JTextField(30);
        coIdField.setPreferredSize(new Dimension(150, 25));

        executeBtn= new JButton("Lookup");

        executeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("63***" + Main.students);
                String coId = coIdField.getText();
                Course course = Main.courses.get(coId);
                if (course == null) {
                    JOptionPane.showMessageDialog(null, "There's no course with entered ID!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {


                    JPanel coursePanel = new JPanel(new GridLayout(4, 2));

                    coursePanel.add(new JLabel("ID:"));
                    coursePanel.add(new JLabel(course.getCourseId()));

                    coursePanel.add(new JLabel("Name: "));
                    coursePanel.add(new JLabel(course.getName()));

                    coursePanel.add(new JLabel("Price: "));
                    coursePanel.add(new JLabel(String.valueOf(course.getPrice())));

                    coursePanel.add(new JLabel("Teacher: "));
                    coursePanel.add(new JLabel(course.getTeacher() == null ? "Not assiagned" : course.getTeacher().getName()));

                    // Display the panel in a message dialog
                    JOptionPane.showMessageDialog(null, coursePanel, "Course Information", JOptionPane.INFORMATION_MESSAGE);

                    menuFrame.setVisible(true);
                    executionFrame.setVisible(false);
                    executionFrame.remove(coLabel);
                    executionFrame.remove(coIdField);
                    executionFrame.remove(executeBtn);
                }
            }
        });


        // Create a "Go Back" button
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executionFrame.dispose();
                menuFrame.setVisible(true);

                executionFrame.remove(coLabel);
                executionFrame.remove(coIdField);
                executionFrame.remove(executeBtn);
                executionFrame.remove(goBackButton);
            }
        });

        executionFrame.add(coLabel);
        executionFrame.add(coIdField);
        executionFrame.add(executeBtn);
        executionFrame.add(goBackButton);
        executionFrame.setVisible(true);
    }
    private void showStudents() {
        menuFrame.setVisible(false);

        JTextArea studentsTextArea = new JTextArea(15, 40);
        studentsTextArea.setEditable(false);
        StringBuilder studentsText = new StringBuilder();

        for (Map.Entry<String, Student> entry : Main.students.entrySet()) {
            Student student = entry.getValue();
            String studentId = student.getStudentId();
            String studentName = student.getName();
            String studentAddress = student.getAddress();
            String studentEmail = student.getEmail();
            studentsText.append("Student ID: ").append(studentId).append("\n");
            studentsText.append("Name: ").append(studentName).append("\n");
            studentsText.append("Address: ").append(studentAddress).append("\n");
            studentsText.append("Email: ").append(studentEmail).append("\n");
            studentsText.append("\n");
        }

        studentsTextArea.setText(studentsText.toString());

        JScrollPane scrollPane1 = new JScrollPane(studentsTextArea);

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuFrame.setVisible(true);
                executionFrame.dispose();
                executionFrame.remove(scrollPane1);
                executionFrame.remove(goBackButton);
            }
        });

        executionFrame.add(scrollPane1, BorderLayout.CENTER);
        executionFrame.add(goBackButton, BorderLayout.SOUTH);

        executionFrame.setVisible(true);
    }

    private void lookupStudent() {

        menuFrame.setVisible(false);

        JLabel studentLabel = new JLabel("Enter Student Id: ");
        JTextField studentIdField = new JTextField(30);
        studentIdField.setPreferredSize(new Dimension(150, 25));

        executeBtn = new JButton("Lookup");

        executeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("63***" + Main.students);
//                            String teacherId= teacherIdField.getText();
                String studentId = studentIdField.getText();
                Student student = Main.students.get(studentId);
//                            Teacher t = Main.teachers.get(teacherId);
                if (student == null) {
                    JOptionPane.showMessageDialog(null, "There's no student with entered ID!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    JPanel coursePanel = new JPanel(new GridLayout(4, 2));

                    coursePanel.add(new JLabel("ID:"));
                    coursePanel.add(new JLabel(student.getStudentId()));

                    coursePanel.add(new JLabel("Name: "));
                    coursePanel.add(new JLabel(student.getName()));

                    coursePanel.add(new JLabel("Email: "));
                    coursePanel.add(new JLabel(String.valueOf(student.getEmail())));

                    coursePanel.add(new JLabel("Adress: "));
                    coursePanel.add(new JLabel(student.getAddress()));

                    // Display the panel in a message dialog
                    JOptionPane.showMessageDialog(null, coursePanel, "Student Information", JOptionPane.INFORMATION_MESSAGE);

                    menuFrame.setVisible(true);
                    executionFrame.setVisible(false);
                    executionFrame.remove(studentLabel);
                    executionFrame.remove(studentIdField);
                    executionFrame.remove(executeBtn);

                }
            }
        });


        // Create a "Go Back" button
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executionFrame.dispose();
                menuFrame.setVisible(true);

                executionFrame.remove(studentLabel);
                executionFrame.remove(studentIdField);
                executionFrame.remove(executeBtn);
                executionFrame.remove(goBackButton);
            }
        });
        executionFrame.add(studentLabel);
        executionFrame.add(studentIdField);
        executionFrame.add(executeBtn);
        executionFrame.add(goBackButton);
        executionFrame.setVisible(true);
    }
    private void showTeachers() {
        menuFrame.setVisible(false);

        JTextArea teachersTextArea = new JTextArea(15, 40);
        teachersTextArea.setEditable(false);
        StringBuilder teachersText = new StringBuilder();

        for (Map.Entry<String, Teacher> entry : Main.teachers.entrySet()) {
            Teacher teacher = entry.getValue();
            String teacherName = teacher.getName();
            double teacherSalary = teacher.getSalary();
            teachersText.append("Name: ").append(teacherName).append(", Salary: ").append(teacherSalary).append("\n");
        }

        teachersTextArea.setText(teachersText.toString());

        JScrollPane scrollPane2 = new JScrollPane(teachersTextArea);

        // Create a "Go Back" button
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executionFrame.dispose();
                menuFrame.setVisible(true);
                executionFrame.remove(scrollPane2);
                executionFrame.remove(goBackButton);
            }
        });

        executionFrame.add(scrollPane2, BorderLayout.CENTER);
        executionFrame.add(goBackButton, BorderLayout.SOUTH);

        executionFrame.setVisible(true);

    }
    private void lookupTeacher() {
        // The logic to handle "LOOKUP TEACHER"
        System.out.println("LOOKUP");


        menuFrame.setVisible(false);

        JLabel teacherLabel = new JLabel("Enter Teacher Id: ");
        JTextField teacherIdField = new JTextField(30);
        teacherIdField.setPreferredSize(new Dimension(150, 25));


        executeBtn= new JButton("Lookup");

        executeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("63***" + Main.students);
                String teacherId = teacherIdField.getText();
                Teacher teacher = Main.teachers.get(teacherId);
                if (teacher == null) {
                    JOptionPane.showMessageDialog(null, "There's no teacher with entered ID!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    JPanel coursePanel = new JPanel(new GridLayout(3, 2));

                    coursePanel.add(new JLabel("ID:"));
                    coursePanel.add(new JLabel(teacher.getTeacherId()));

                    coursePanel.add(new JLabel("Name: "));
                    coursePanel.add(new JLabel(teacher.getName()));

                    coursePanel.add(new JLabel("Salary: "));
                    coursePanel.add(new JLabel(String.valueOf(teacher.getSalary())));


                    // Display the panel in a message dialog
                    JOptionPane.showMessageDialog(null, coursePanel, "Teacher Information", JOptionPane.INFORMATION_MESSAGE);

                    menuFrame.setVisible(true);
                    executionFrame.setVisible(false);
                    executionFrame.remove(teacherLabel);
                    executionFrame.remove(teacherIdField);
                    executionFrame.remove(executeBtn);

                }
            }
        });

        // Create a "Go Back" button
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executionFrame.dispose();
                menuFrame.setVisible(true);

                executionFrame.remove(teacherLabel);
                executionFrame.remove(teacherIdField);

                executionFrame.remove(executeBtn);
                executionFrame.remove(goBackButton);
            }
        });

        executionFrame.add(teacherLabel);
        executionFrame.add(teacherIdField);
        executionFrame.add(executeBtn);
        executionFrame.add(goBackButton);
        executionFrame.setVisible(true);

    }

    private void showٍStudentsByCourseId() {

        menuFrame.setVisible(false);

        JLabel coLabel = new JLabel("Enter Course Id: ");
        JTextField coIdField = new JTextField(30);
        coIdField.setPreferredSize(new Dimension(150, 25));

        JTextArea studentsTextArea = new JTextArea(15, 40);
        studentsTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(studentsTextArea); // Create it here, so you don't have to recreate it

// Rest of your initializations ...
        executeBtn= new JButton("Show Students");

        executeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> studentsInCourse = new ArrayList<>();
                String coId = coIdField.getText();
                Course course = Main.courses.get(coId);

                if (course == null) {
                    JOptionPane.showMessageDialog(null, "There's no course with entered ID!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    StringBuilder studentsText = new StringBuilder();  // Initialize the StringBuilder here

                    for (Student student: Main.students.values()) {
                        if (student.getCourse().contains(course)) {
                            studentsInCourse.add(student.getName());
                        }
                    }

                    for (String name: studentsInCourse) {
                        studentsText.append("Name: ").append(name).append("\n");
                    }

                    studentsTextArea.setText(studentsText.toString());
                }
            }
        });

// Rest of your code ...

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executionFrame.dispose();
                menuFrame.setVisible(true);
                executionFrame.remove(coLabel);
                executionFrame.remove(coIdField);
                executionFrame.remove(executeBtn);
                executionFrame.remove(scrollPane);  // Add your JScrollPane directly to the frame
                executionFrame.remove(goBackButton);

            }
        });

//        executionFrame.setLayout(new FlowLayout());  // Change to FlowLayout
        executionFrame.add(coLabel);
        executionFrame.add(coIdField);
        executionFrame.add(executeBtn);
        executionFrame.add(scrollPane);  // Add your JScrollPane directly to the frame
        executionFrame.add(goBackButton);
        executionFrame.setVisible(true);


    }
    private void showProfit() {

        Main.profit();
        double profit = Main.profit;

        menuFrame.setVisible(false);

        JLabel profitLabel = new JLabel("Profit: ");
        JLabel showProfitLabel = new JLabel(String.valueOf(profit)+" $");

        // Create a panel for labels and add both labels to it
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelPanel.add(profitLabel);
        labelPanel.add(showProfitLabel);


        // Create a main panel and set its layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executionFrame.dispose();
                menuFrame.setVisible(true);
                executionFrame.remove(mainPanel);
            }
        });


        // Add labelPanel and goBackButton to the mainPanel
        mainPanel.add(labelPanel);
        mainPanel.add(goBackButton);

        // Add the mainPanel to the frame
        executionFrame.add(mainPanel);
        executionFrame.setVisible(true);
    }

    private void showMoneyEarned() {

        Main.profit();
        double totalMoneyEarned = Main.totalMoneyEarned;

        menuFrame.setVisible(false);

        JLabel totalMoneyEarnedLabel = new JLabel("Money Earned: ");
        JLabel showTotalMoneyEarnedLabel = new JLabel(String.valueOf(totalMoneyEarned)+" $");

        // Create a panel for labels and add both labels to it
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelPanel.add(totalMoneyEarnedLabel);
        labelPanel.add(showTotalMoneyEarnedLabel);

        // Create a main panel and set its layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executionFrame.dispose();
                menuFrame.setVisible(true);
                executionFrame.remove(mainPanel);
            }
        });


        // Add labelPanel and goBackButton to the mainPanel
        mainPanel.add(labelPanel);
        mainPanel.add(goBackButton);

        // Add the mainPanel to the frame
        executionFrame.add(mainPanel);
        executionFrame.setVisible(true);
    }

    private void showMoneySpent() {

        Main.profit();
        double totalMoneySpent = Main.totalTeacherSalaries;

        menuFrame.setVisible(false);

        JLabel totalMoneySpentLabel = new JLabel("Money Spent: ");
        JLabel showTotalMoneySpentLabel = new JLabel(String.valueOf(totalMoneySpent)+" $");

        // Create a panel for labels and add both labels to it
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        labelPanel.add(totalMoneySpentLabel);
        labelPanel.add(showTotalMoneySpentLabel);

        // Create a main panel and set its layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executionFrame.dispose();
                menuFrame.setVisible(true);
                executionFrame.remove(mainPanel);
            }
        });



        // Add labelPanel and goBackButton to the mainPanel
        mainPanel.add(labelPanel);
        mainPanel.add(goBackButton);

        // Add the mainPanel to the frame
        executionFrame.add(mainPanel);
        executionFrame.setVisible(true);
    }

}
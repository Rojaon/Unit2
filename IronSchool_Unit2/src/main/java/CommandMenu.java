import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class CommandMenu {

    private JFrame frame;
    private JFrame frame2;
    private JList<String> menuList;
    private DefaultListModel<String> listModel;
    private JButton btn;
    private  JButton goBackButton;
    public CommandMenu() {
        frame = new JFrame("Menu Navigation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        listModel = new DefaultListModel<>();
        listModel.addElement("ENROLL student");
        listModel.addElement("ASSIGN teacher");
        listModel.addElement("SHOW COURSES");
        listModel.addElement("LOOKUP COURSE");
        listModel.addElement("SHOW STUDENTS");
        listModel.addElement("LOOKUP STUDENT");
        listModel.addElement("SHOW TEACHERS");
        listModel.addElement("LOOKUP TEACHER");
        listModel.addElement("SHOW PROFIT");

        menuList = new JList<>(listModel);
        menuList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        menuList.setSelectedIndex(0);

        btn = new JButton("Select");

        frame.add(new JScrollPane(menuList));
        frame.add(btn, BorderLayout.SOUTH);
        frame.setVisible(true);

        frame2 = new JFrame("Frame 2");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(500, 400);
        frame2.setLayout(new FlowLayout());
        goBackButton = new JButton("Go Back");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = menuList.getSelectedValue();

                switch (selectedOption) {
                    case "ENROLL student":
                        enrollStudent();
                        break;
                    case "ASSIGN teacher":
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

                }
            }
        });
    }

    //      ================================================= REFACTOR CODE   =================================================

    private void enrollStudent() {
        frame.setVisible(false);

        JLabel stLabel = new JLabel("Enter Student id: ");
        JTextField stIdField = new JTextField(30);
        stIdField.setPreferredSize(new Dimension(150, 25));
//                    ************************************************
        JLabel coLabel = new JLabel("Enter course id: ");
        JTextField coIdField = new JTextField(30);
        coIdField.setPreferredSize(new Dimension(150, 25));

        JButton addBtn = new JButton("Enroll student");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String stId = stIdField.getText();
                String coId = coIdField.getText();
                Course c = Main.courses.get(coId);
                Student s = Main.students.get(stId);
                if (c == null || s == null) {
                    JOptionPane.showMessageDialog(null, "An error occurred!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    s.setCourse(c);
                    JOptionPane.showMessageDialog(null, "Student enrolled!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.setVisible(true);
                    frame2.setVisible(false);
                    frame2.remove(stLabel);
                    frame2.remove(stIdField);
//                    *************************
                    frame2.remove(coLabel);
                    frame2.remove(coIdField);
                    frame2.remove(addBtn);

                }
            }
        });

        frame2.add(stLabel);
        frame2.add(stIdField);
//                    *************************
        frame2.add(coLabel);
        frame2.add(coIdField);
        frame2.add(addBtn);
        frame2.setVisible(true);
    }

    private void assignTeacher() {

        frame.setVisible(false);

        JLabel teacherLabel = new JLabel("Enter teacher id: ");
        JTextField teacherIdField = new JTextField(30);
        teacherIdField.setPreferredSize(new Dimension(150, 25));
//                    ************************************************
        JLabel coLabel = new JLabel("Enter course id: ");
        JTextField coIdField = new JTextField(30);
        coIdField.setPreferredSize(new Dimension(150, 25));

        JButton addBtn = new JButton("ASSIGN teacher");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String teacherId = teacherIdField.getText();
                String coId = coIdField.getText();
                Course c = Main.courses.get(coId);
                Teacher t = Main.teachers.get(teacherId);
                if (c == null || t == null) {
                    JOptionPane.showMessageDialog(null, "An error occurred!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    c.setTeacher(t);
                    JOptionPane.showMessageDialog(null, "teacher assigned !", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.setVisible(true);
                    frame2.setVisible(false);
                    frame2.remove(teacherLabel);
                    frame2.remove(teacherIdField);
//                    *************************
                    frame2.remove(coLabel);
                    frame2.remove(coIdField);
                    frame2.remove(addBtn);

                }
            }
        });


        frame2.add(teacherLabel);
        frame2.add(teacherIdField);
//                    *************************
        frame2.add(coLabel);
        frame2.add(coIdField);
        frame2.add(addBtn);
        frame2.setVisible(true);
    }

    private void showCourses() {



        frame.setVisible(false);
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
                frame2.dispose();
                frame.setVisible(true);
                frame2.remove(scrollPane);
                frame2.remove(goBackButton);

            }
        });

        frame2.add(scrollPane, BorderLayout.CENTER);
        frame2.add(goBackButton, BorderLayout.SOUTH);

        frame2.setVisible(true);

    }
    private void lookupCourse() {

        frame.setVisible(false);

        JLabel coLabel = new JLabel("Enter course id: ");
        JTextField coIdField = new JTextField(30);
        coIdField.setPreferredSize(new Dimension(150, 25));

        JButton addBtn = new JButton("LOOKUP FOR COURSE");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("63***" + Main.students);
                String coId = coIdField.getText();
                Course c = Main.courses.get(coId);
                if (c == null) {
                    JOptionPane.showMessageDialog(null, "There's no course with entered ID!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {


                    JPanel coursePanel = new JPanel(new GridLayout(4, 2));

                    coursePanel.add(new JLabel("ID:"));
                    coursePanel.add(new JLabel(c.getCourseId()));

                    coursePanel.add(new JLabel("Name: "));
                    coursePanel.add(new JLabel(c.getName()));

                    coursePanel.add(new JLabel("Price: "));
                    coursePanel.add(new JLabel(String.valueOf(c.getPrice())));

                    coursePanel.add(new JLabel("Teacher: "));
                    coursePanel.add(new JLabel(c.getTeacher() == null ? "Not assiagned" : c.getTeacher().getName()));

                    // Display the panel in a message dialog
                    JOptionPane.showMessageDialog(null, coursePanel, "Course Information", JOptionPane.INFORMATION_MESSAGE);

                    frame.setVisible(true);
                    frame2.setVisible(false);
                    frame2.remove(coLabel);
                    frame2.remove(coIdField);
                    frame2.remove(addBtn);
                }
            }
        });

        frame2.add(coLabel);
        frame2.add(coIdField);
        frame2.add(addBtn);

        frame2.setVisible(true);
    }
    private void showStudents() {
        frame.setVisible(false);
//        frame2 = new JFrame("List of Students");
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame2.setSize(500, 400);
//        frame2.setLayout(new BorderLayout()); // Use BorderLayout for better layout management

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
                frame.setVisible(true);
                frame2.dispose();
                frame2.remove(scrollPane1);
                frame2.remove(goBackButton);
            }
        });

        frame2.add(scrollPane1, BorderLayout.CENTER);
        frame2.add(goBackButton, BorderLayout.SOUTH);

        frame2.setVisible(true);
    }

    private void lookupStudent() {

        frame.setVisible(false);

        JLabel studentLabel = new JLabel("Enter student id: ");
        JTextField studentIdField = new JTextField(30);
        studentIdField.setPreferredSize(new Dimension(150, 25));

        JButton addBtn = new JButton("LOOKUP FOR STUDENT");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("63***" + Main.students);
//                            String teacherId= teacherIdField.getText();
                String studentId = studentIdField.getText();
                Student s = Main.students.get(studentId);
//                            Teacher t = Main.teachers.get(teacherId);
                if (s == null) {
                    JOptionPane.showMessageDialog(null, "There's no student with entered ID!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    JPanel coursePanel = new JPanel(new GridLayout(4, 2));

                    coursePanel.add(new JLabel("ID:"));
                    coursePanel.add(new JLabel(s.getStudentId()));

                    coursePanel.add(new JLabel("Name: "));
                    coursePanel.add(new JLabel(s.getName()));

                    coursePanel.add(new JLabel("Email: "));
                    coursePanel.add(new JLabel(String.valueOf(s.getEmail())));

                    coursePanel.add(new JLabel("Adress: "));
                    coursePanel.add(new JLabel(s.getAddress()));

                    // Display the panel in a message dialog
                    JOptionPane.showMessageDialog(null, coursePanel, "Student Information", JOptionPane.INFORMATION_MESSAGE);

                    frame.setVisible(true);
                    frame2.setVisible(false);
                    frame2.remove(studentLabel);
                    frame2.remove(studentIdField);
                    frame2.remove(addBtn);

                }
            }
        });

        frame2.add(studentLabel);
        frame2.add(studentIdField);
        frame2.add(addBtn);
//                    System.out.println("id: "+id);
        frame2.setVisible(true);
    }
    private void showTeachers() {
        frame.setVisible(false);
//        frame2 = new JFrame("List of Teachers");
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame2.setSize(500, 400);
//        frame2.setLayout(new BorderLayout()); // Use BorderLayout for better layout management

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
                frame2.dispose();
                frame.setVisible(true);
                frame2.remove(scrollPane2);
                frame2.remove(goBackButton);
            }
        });

        frame2.add(scrollPane2, BorderLayout.CENTER);
        frame2.add(goBackButton, BorderLayout.SOUTH);

        frame2.setVisible(true);

    }
    private void lookupTeacher() {
        // The logic to handle "LOOKUP TEACHER"
        System.out.println("LOOKUP TEACHER");


        frame.setVisible(false);

        JLabel teacherLabel = new JLabel("Enter teacher id: ");
        JTextField teacherIdField = new JTextField(30);
        teacherIdField.setPreferredSize(new Dimension(150, 25));


        JButton addBtn = new JButton("LOOKUP FOR TEACHER");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("63***" + Main.students);
                String teacherId = teacherIdField.getText();
                Teacher t = Main.teachers.get(teacherId);
                if (t == null) {
                    JOptionPane.showMessageDialog(null, "There's no teacher with entered ID!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    JPanel coursePanel = new JPanel(new GridLayout(3, 2));

                    coursePanel.add(new JLabel("ID:"));
                    coursePanel.add(new JLabel(t.getTeacherId()));

                    coursePanel.add(new JLabel("Name: "));
                    coursePanel.add(new JLabel(t.getName()));

                    coursePanel.add(new JLabel("Salary: "));
                    coursePanel.add(new JLabel(String.valueOf(t.getSalary())));


                    // Display the panel in a message dialog
                    JOptionPane.showMessageDialog(null, coursePanel, "Teacher Information", JOptionPane.INFORMATION_MESSAGE);

                    frame.setVisible(true);
                    frame2.setVisible(false);
                    frame2.remove(teacherLabel);
                    frame2.remove(teacherIdField);
                    frame2.remove(addBtn);

                }
            }
        });


        frame2.add(teacherLabel);
        frame2.add(teacherIdField);
        frame2.add(addBtn);

        frame2.setVisible(true);

    }

}
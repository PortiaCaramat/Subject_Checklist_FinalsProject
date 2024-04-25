package prog2.fingrp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Courses {
    private String courseNo;
    private String title;
    private double units;
    private int grade;

    public Courses(String courseNo, String title, double units) {
        this.courseNo = courseNo;
        this.title = title;
        this.units = units;
        this.grade = -1; // Default grade is -1 (not entered)
    }

    public String getCourseNo() {
        return courseNo;
    }

    public String getTitle() {
        return title;
    }

    public double getUnits() {
        return units;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Course No.: " + courseNo + ", Title: " + title + ", Units: " + units + ", Grade: " + (grade == -1 ? "Not yet entered" : grade);
    }
}

public class GUI extends JFrame {
    private List<Courses> courses = new ArrayList<>();
    private JTextArea outputTextArea;

    public GUI() {
        setTitle("My Checklist Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel menuPanel = new JPanel(new GridLayout(9, 1));
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(i + ". " + getMenuOption(i));
            button.addActionListener(new MenuActionListener(i));
            menuPanel.add(button);
        }

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(menuPanel, BorderLayout.WEST);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private String getMenuOption(int option) {
        switch (option) {
            case 1:
                return "Show subjects for each school term";
            case 2:
                return "Show subjects with grades for each term";
            case 3:
                return "Enter grades for subjects recently finished";
            case 4:
                return "Edit a course";
            case 5:
                return "Add other courses taken";
            case 6:
                return "Display courses with Grade point Average";
            case 7:
                return "Display courses in alphabetical order";
            case 8:
                return "Display courses with grades in Highest to Lowest";
            case 9:
                return "Quit";
            default:
                return "";
        }
    }

    private void showSubjectsForTerm() {
        outputTextArea.setText("");
        for (Courses course : courses) {
            outputTextArea.append(course.toString() + "\n");
        }
    }

    private void showSubjectsWithGrades() {
        outputTextArea.setText("");
        for (Courses course : courses) {
            if (course.getGrade() != -1) {
                outputTextArea.append(course.toString() + "\n");
            }
        }
    }

    private void enterGrades() {
        String input = JOptionPane.showInputDialog("Enter course number:");
        if (input != null && !input.isEmpty()) {
            for (Courses course : courses) {
                if (course.getCourseNo().equalsIgnoreCase(input)) {
                    int grade = Integer.parseInt(JOptionPane.showInputDialog("Enter grade for " + course.getCourseNo() + " - " + course.getTitle()));
                    course.setGrade(grade);
                    break;
                }
            }
        }
    }

    private void editCourse() {
        String input = JOptionPane.showInputDialog("Enter course number:");
        if (input != null && !input.isEmpty()) {
            for (Courses course : courses) {
                if (course.getCourseNo().equalsIgnoreCase(input)) {
                    int grade = Integer.parseInt(JOptionPane.showInputDialog("Enter new grade for " + course.getCourseNo() + " - " + course.getTitle()));
                    course.setGrade(grade);
                    break;
                }
            }
        }
    }

    private void addOtherCourses() {
        String courseNo = JOptionPane.showInputDialog("Enter course number:");
        String title = JOptionPane.showInputDialog("Enter course title:");
        double units = Double.parseDouble(JOptionPane.showInputDialog("Enter course units:"));
        Courses newCourse = new Courses(courseNo, title, units);
        courses.add(newCourse);
    }

    private void displayCoursesWithGPA() {
        // TODO: Implement GPA calculation and display
    }

    private void displayCoursesInAlphabeticalOrder() {
        courses.sort(Comparator.comparing(Courses::getCourseNo));
        showSubjectsForTerm();
    }

    private void displayCoursesWithGradesInDescendingOrder() {
        courses.sort(Comparator.comparing(Courses::getGrade).reversed());
        showSubjectsWithGrades();
    }

    private class MenuActionListener implements ActionListener {
        private int option;

        public MenuActionListener(int option) {
            this.option = option;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (option) {
                case 1:
                    showSubjectsForTerm();
                    break;
                case 2:
                    showSubjectsWithGrades();
                    break;
                case 3:
                    enterGrades();
                    break;
                case 4:
                    editCourse();
                    break;
                case 5:
                    addOtherCourses();
                    break;
                case 6:
                    displayCoursesWithGPA();
                    break;
                case 7:
                    displayCoursesInAlphabeticalOrder();
                    break;
                case 8:
                    displayCoursesWithGradesInDescendingOrder();
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI().setVisible(true));
    }
}

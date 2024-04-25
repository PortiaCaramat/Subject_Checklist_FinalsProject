package prog2.fingrp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Course {
    private String courseNo;
    private String tCSle;
    private double unCSs;
    private int grade;

    public Course(String courseNo, String tCSle, double unCSs) {
        this.courseNo = courseNo;
        this.tCSle = tCSle;
        this.unCSs = unCSs;
        this.grade = -1; // Default grade is -1 (not entered)
    }



    public String getCourseNo() {
        return courseNo;
    }

    public String getTCSle() {
        return tCSle;
    }

    public double getUnCSs() {
        return unCSs;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Course No.: " + courseNo + ", Title: " + tCSle + ", Grade: " + (grade == -1 ? "Not yet entered" : grade);
    }
}

public class GUI extends JFrame {
    private List<List<Course>> coursesByTerm = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private JTextArea outputTextArea;
    private int currentTermIndex = 0;

    public GUI() {
        setTitle("My Checklist Management");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        JButton nextTermButton = new JButton("Next Term");
        nextTermButton.addActionListener(e -> displayNextTermCourses());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(nextTermButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);


        displayCurrentTermCourses();
    }

    private void initializeSampleData() {
        List<Course> firstYearterm1Courses = new ArrayList<>();
        firstYearterm1Courses.add(new Course("CS 111", "Introduction to Computing", 2.0));
        firstYearterm1Courses.add(new Course("CS 111L", "Introduction to Computing (Lab)", 1.0));
        firstYearterm1Courses.add(new Course("CS 112", "Computer Programming 1", 2.0));
        firstYearterm1Courses.add(new Course("CS 112L", "Computer Programming 1 (Lab)", 1.0));
        firstYearterm1Courses.add(new Course("CS 113", "Discrete Mathematics", 3.0));
        firstYearterm1Courses.add(new Course("GART", "Art Appreciation", 3.0));
        firstYearterm1Courses.add(new Course("GSELF", "Understanding the Self", 3.0));
        firstYearterm1Courses.add(new Course("GHIST", "Readings in Philippine History", 3.0));
        firstYearterm1Courses.add(new Course("FIT HW", "Physical Activity Towards Health and Fitness (Health and Wellness)", 2.0));
        firstYearterm1Courses.add(new Course("CFE 101", "God’s Journey with His People", 3.0));
        coursesByTerm.add(firstYearterm1Courses);

        List<Course> firstYearterm2Courses = new ArrayList<>();
        firstYearterm2Courses.add(new Course("CS 121", "Digital Logic Design", 3.0));
        firstYearterm2Courses.add(new Course("CS 122", "Computer Programming 2", 2.0));
        firstYearterm2Courses.add(new Course("CS 122L", "Computer Programming 2 (Lab)", 1.0));
        firstYearterm2Courses.add(new Course("CS 123", "Architecture and Organization", 2.0));
        firstYearterm2Courses.add(new Course("CS 123L", "Architecture and Organization (Lab)", 1.0));
        firstYearterm2Courses.add(new Course("GENVI", "Environmental Science", 3.0));
        firstYearterm2Courses.add(new Course("GPCOM", "Purposive Communication", 3.0));
        firstYearterm2Courses.add(new Course("GSELF", "Understanding The Self", 3.0));
        firstYearterm2Courses.add(new Course("FIT CS", "Physical Activity Towards Health and Fitness (Combative Sports)", 2.0));
        firstYearterm2Courses.add(new Course("CFE 102", "Christian Morality in Our Times", 3.0));
        coursesByTerm.add(firstYearterm2Courses);

        List<Course> secondYearterm1Courses = new ArrayList<>();
        secondYearterm1Courses.add(new Course("CS 211", "Data Structures", 2.0));
        secondYearterm1Courses.add(new Course("CS 211L", "Data Structures (Lab)", 1.0));
        secondYearterm1Courses.add(new Course("CS 212", "Operating Systems", 2.0));
        secondYearterm1Courses.add(new Course("CS 212L", "Operating Systems (Lab)", 1.0));
        secondYearterm1Courses.add(new Course("CS 213", "Human Computer Interaction)", 1.0));
        secondYearterm1Courses.add(new Course("GRVA", "Reading Visual Art", 3.0));
        secondYearterm1Courses.add(new Course("GSTS", "Science, Technology, and Society", 3.0));
        secondYearterm1Courses.add(new Course("GCWORLD", "The Contemporary World", 3.0));
        secondYearterm1Courses.add(new Course("NSTP-CWTS 1", "Foundations Of Service", 3.0));
        secondYearterm1Courses.add(new Course("FIT OA", "Physical Activity Towards Health and Fitness (Outdoor And Adventure Activities)", 2.0));
        secondYearterm1Courses.add(new Course("CFE 103", "Catholic Foundation Of Mission", 3.0));
        coursesByTerm.add(secondYearterm1Courses);

        List<Course> secondYearterm2Courses = new ArrayList<>();
        secondYearterm2Courses.add(new Course("CS 212", "Information Management", 2.0));
        secondYearterm2Courses.add(new Course("CS 212L", "Information Management (Lab)", 1.0));
        secondYearterm2Courses.add(new Course("CS 222", "Computer Programming 3", 2.0));
        secondYearterm2Courses.add(new Course("CS 222L", "Computer Programming 3 (Lab)", 1.0));
        secondYearterm2Courses.add(new Course("CS 223", "Automata and Formal Languages", 3.0));
        secondYearterm2Courses.add(new Course("GCWORLD", "The Contemporary World", 3.0));
        secondYearterm2Courses.add(new Course("GETHICS", "Ethics", 3.0));
        secondYearterm2Courses.add(new Course("NSTP-CWTS 2", "Social Awareness and Empowerment for Service", 3.0));
        secondYearterm2Courses.add(new Course("FIT AQ", "Physical Activity Towards Health and Fitness (Aquatics)", 2.0));
        secondYearterm2Courses.add(new Course("CFE 104", "CICM Missionary Identity", 3.0));
        coursesByTerm.add(secondYearterm1Courses);

        List<Course> thirdYearterm1Courses = new ArrayList<>();
        thirdYearterm1Courses.add(new Course("CS 311", "Applications Development", 2.0));
        thirdYearterm1Courses.add(new Course("CS 311L", "Applications Development (Lab)", 1.0));
        thirdYearterm1Courses.add(new Course("CS 312", "Computer Programming 3", 2.0));
        thirdYearterm1Courses.add(new Course("CS 222L", "Computer Programming 3 (Lab)", 1.0));
        thirdYearterm1Courses.add(new Course("CS 223", "Automata and Formal Languages", 3.0));
        thirdYearterm1Courses.add(new Course("GCWORLD", "The Contemporary World", 3.0));
        thirdYearterm1Courses.add(new Course("GETHICS", "Ethics", 3.0));
        thirdYearterm1Courses.add(new Course("NSTP-CWTS 2", "Social Awareness and Empowerment for Service", 3.0));
        thirdYearterm1Courses.add(new Course("FIT AQ", "Physical Activity Towards Health and Fitness (Aquatics)", 2.0));
        thirdYearterm1Courses.add(new Course("CFE 105A", "CICM in Action: Justice, Peace, Integrity of Creation, Indigenous Peoples and Interreligious Dialogue", 2.0));
        coursesByTerm.add(thirdYearterm1Courses);

        List<Course> thirdYearterm2Courses = new ArrayList<>();
        thirdYearterm2Courses.add(new Course("CS 321", "Artificial Intelligence", 2.0));
        thirdYearterm2Courses.add(new Course("CS 321L", "Data Science", 2.0));
        thirdYearterm2Courses.add(new Course("CS 322", "Data Science (Lab)", 1.0));
        thirdYearterm2Courses.add(new Course("CS 323", "Modeling and Simulation", 2.0));
        thirdYearterm2Courses.add(new Course("CS 323L", "Modeling and Simulation (Lab)", 1.0));
        thirdYearterm2Courses.add(new Course("CS 324", "Methods of Research in Computer Science", 3.0));
        thirdYearterm2Courses.add(new Course("CS 325", "Structure of Programming Languages", 3.0));
        thirdYearterm2Courses.add(new Course("CFE 105B", "CICM in Action: Environmental Planning & Management, and Disaster Risk Reduction Management", 2.0));
        coursesByTerm.add(thirdYearterm2Courses);

        List<Course> fourthYearterm1Courses = new ArrayList<>();
        fourthYearterm1Courses.add(new Course("CS 411", "CS Thesis 1", 3.0));
        fourthYearterm1Courses.add(new Course("CS 412", "Information Assurance And Security", 3.0));
        fourthYearterm1Courses.add(new Course("CS 413", "Professional Practice And Cyberethics", 3.0));
        fourthYearterm1Courses.add(new Course("CSE 15", "Data Mining", 2.0));
        fourthYearterm1Courses.add(new Course("CSE 15L", "Data Mining (Lab)", 1.0));
        fourthYearterm1Courses.add(new Course("CSE 25", "Ux Concepts And Design (Elective)", 3.0));
        coursesByTerm.add(fourthYearterm1Courses);

        List<Course> fourthYearterm2Courses = new ArrayList<>();
        fourthYearterm2Courses.add(new Course("CFE 106B", "Embracing The CICM Mission", 2.0));
        fourthYearterm2Courses.add(new Course("CS 421", "CS Thesis 2", 3.0));
        fourthYearterm2Courses.add(new Course("CS 422", "Distributed Computing", 3.0));
        fourthYearterm2Courses.add(new Course("FOR LANG 1", "Foreign Language 1", 3.0));
        fourthYearterm2Courses.add(new Course("CSE 26", "Field Trips And Seminars (Elective)", 3.0));
        fourthYearterm2Courses.add(new Course("CSE 30", "Special Topics 1 (Elective)", 3.0));
        fourthYearterm2Courses.add(new Course("CSE 31", "Special Topics 2 (Elective)", 3.0));
        coursesByTerm.add(fourthYearterm2Courses);

    }

    private void displayCurrentTermCourses() {
        List<Course> currentTermCourses = coursesByTerm.get(currentTermIndex);
        outputTextArea.setText("");
        outputTextArea.append(getTermHeader(currentTermIndex + 1));

        for (Course course : currentTermCourses) {
            outputTextArea.append(course.toString() + "\n");
        }
    }



    private void displayNextTermCourses() {
        currentTermIndex++;
        if (currentTermIndex < coursesByTerm.size()) {
            outputTextArea.append("\n\n");
            displayCurrentTermCourses();
        } else {
            JOptionPane.showMessageDialog(this, "No more terms available.");
        }
    }


        private String getTermHeader ( int term){
            return String.format("Year = %d Term = %s\n%-8s %-40s %s\n",
                    (term - 1) / 2 + 1,
                    term % 2 == 1 ? "First Semester" : "Second Semester",
                    "Course No", "Descriptive title", "Units");
        }


        public static void main (String[]args){
            SwingUtilities.invokeLater(() -> new GUI().setVisible(true));
        }
    }



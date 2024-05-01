package prog2.fingrp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


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


        //displayCurrentTermCourses();
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

    private String getTermHeader (int term){
        return String.format("Year = %d Term = %s\n%-8s %-40s %s\n",
                (term - 1) / 2 + 1,
                term % 2 == 1 ? "First Semester" : "Second Semester",
                "Course No", "Descriptive title", "Units"); //if term is odd, it's the first sem?
    }

    public static void main (String[]args){
        SwingUtilities.invokeLater(() -> new GUI().setVisible(true));
    }
    
}





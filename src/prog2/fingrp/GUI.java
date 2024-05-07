package prog2.fingrp;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.List;

public class
GUI extends JFrame {

        public static String intToString (int term)  {
                switch (term) {
                    case 1:
                        return "First Semester";
					case 2:
                        return "Second Semester";
                    case 3:
                        return "Short Term";
                    default:
                        return "how?";
                }
        }


        // For reference only
        public void showCurriculum() {
            DatReadWrite<Course> courseRead = new DatReadWrite<>();
            DatReadWrite<CourseGrade> persCourse = new DatReadWrite<>();

            try {
                List<Course> courses = courseRead.read("src\\prog2\\fingrp\\DATA\\Curriculum.dat"); //changed coursesCurriculum to Curriculum.dat file path
                Scanner scanner = new Scanner(System.in);
                System.out.print("Course Curriculum \n");
                System.out.print("-------------------------------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("%-20s%-100s%n", "Year = 1", "Term = First Semester");
                System.out.printf("%-20s%-100s%-20s%n", "Course number", "Descriptive title", "Units");
                System.out.print("-------------------------------------------------------------------------------------------------------------------------------------------------\n");
                System.out.println(courses.get(0));

                for (int i = 1; i < courses.size(); i++) {
                    if (courses.get(i).getTerm() != (courses.get(i - 1).getTerm())) {
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine(); // Wait for user to press Enter

                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.printf("%-20s%-100s%n", "Year = " + courses.get(i).getYear(), "Term = " + intToString(courses.get(i).getTerm()));
                        System.out.printf("%-20s%-100s%-20s%n", "Course number", "Descriptive title", "Units");
                        System.out.print("-------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    }
                    System.out.println(courses.get(i));
                }
                scanner.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public void displayAlphabetically(){
            DatReadWrite<Course> courseRead = new DatReadWrite<>();
            DatReadWrite<CourseGrade> persCourse = new DatReadWrite<>();

            try {
                List<Course> courses = courseRead.read("src\\prog2\\fingrp\\DATA\\Curriculum.dat");

                // Sort the courses alphabetically by descriptive title
                Collections.sort(courses, Comparator.comparing(Course::getTitle));

                Scanner scanner = new Scanner(System.in);
                System.out.print("Display courses in alphabetical order \n");
                System.out.print("-------------------------------------------------------------------------------------------------------------------------------------------------\n");
                System.out.println(courses.get(0));

                for (int i = 1; i < courses.size(); i++) {
                    if (courses.get(i).getTerm() != (courses.get(i - 1).getTerm())) {
                    }
                    System.out.println(courses.get(i));
                }

                scanner.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public void displayHighToLow(){

        }

        public GUI() {
            //empty lmao
        }

        public static void main(String[] args) {
            try {
                GUI program = new GUI();

                Scanner kbd = new Scanner(System.in);
                int choice = kbd.nextInt();

                switch (choice) {
                    case 1:
                        program.showCurriculum();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:
                        program.displayAlphabetically();
                        break;
                    case 8:

                        break;
                    case 9:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter  valid number");
            } catch Exception e();
            System.out.println("An error occurred" + e.getMessage());
            e.printStackTrace();
        }
}




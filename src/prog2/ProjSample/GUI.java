package ProjSample;
import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.List;


public class  GUI extends JFrame {

    // Variables for courses
    private List<Course> coursesCurriculum = new ArrayList<>();
    private List<CourseGrade> coursesData = new ArrayList<>();

    // GUi components

    //IO variables
    private BufferedReader inputReader;
    private PrintWriter printer;

    public void readCourseCurriculum(){

        try {
            inputReader = new BufferedReader( new FileReader("Curriculum.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String lineOfText="x";
        String[] lineArray;
        int yr;
        String trm;
        String cCode;
        String cDes;
        int unit;


        try {
            lineOfText= inputReader.readLine();
            while ( lineOfText != null){
                lineArray= lineOfText.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                yr = Integer.parseInt(lineArray[0]);
                trm = lineArray[1];
                cCode = lineArray[2];
                cDes= lineArray[3];
                unit= Integer.parseInt(lineArray[4]);
                coursesCurriculum.add(new Course(yr, trm, cCode, cDes, unit));
                lineOfText = inputReader.readLine();
            }
            inputReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readCourseData() throws FileNotFoundException{
        String lineOfText="x";
        inputReader = new BufferedReader( new FileReader("CoursesData.txt"));
        String[] lineArray;
        int yr;
        String trm;
        String cCode;
        String cDes;
        int unit;
        int grades;


        try {
            lineOfText= inputReader.readLine();
            while ( lineOfText != null){
                lineArray= lineOfText.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                yr = Integer.parseInt(lineArray[0]);
                trm = lineArray[1];
                cCode = lineArray[2];
                cDes= lineArray[3];
                unit= Integer.parseInt(lineArray[4]);
                grades= Integer.parseInt(lineArray[5]);

                coursesData.add(new CourseGrade(yr, trm, cCode, cDes, unit,grades));
                lineOfText = inputReader.readLine();
            }
            inputReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // for saving course data
    public void writeCourseData() throws FileNotFoundException{
        try {
            printer = new PrintWriter(new FileWriter("CourseData.txt", true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<CourseGrade> data =coursesData;
        String lineOfText;
        for(int i =1; i< data.size(); i++){
            printer.println(data.get(i).getYear()+","+ data.get(i).getTerm()+","+ data.get(i).getCode()+","+
                    data.get(i).getTitle()+","+ data.get(i).getUnit()+","+ data.get(i).getGrade());
        }
        printer.close();
    }

    // for saving edited course title to text file
    public void rewriteCourseCurriculum() throws FileNotFoundException{
        try {
            printer = new PrintWriter(new FileWriter("CourseCurriculum.txt", true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Course> data =coursesCurriculum;
        String lineOfText;
        for(int i =1; i< data.size(); i++){
            printer.println(data.get(i).getYear()+","+ data.get(i).getTerm()+","+ data.get(i).getCode()+","+
                    data.get(i).getTitle()+","+ data.get(i).getUnit());
        }
        printer.close();
    }


    // For reference only
    public void showCurriculum(){
        List<Course> courses = coursesCurriculum;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Course Curriculum \n");
        System.out.print("-------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("%-20s%-100s%n", "Year = 1", "Term = First Semester");
        System.out.printf("%-20s%-100s%-20s%n", "Course number", "Descriptive title","Units" );
        System.out.print("-------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.println(courses.get(0).toString());
        for (int i = 1; i < courses.size(); i++) {
            if (!courses.get(i).getTerm().equals(courses.get(i - 1).getTerm())) {
                System.out.println("Press Enter to continue...");
                scanner.nextLine(); // Wait for user to press Enter

                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("%-20s%-100s%n", "Year = "+ courses.get(i).getYear(), "Term = " + courses.get(i).getTerm());
                System.out.printf("%-20s%-100s%-20s%n", "Course number", "Descriptive title","Units" );
                System.out.print("-------------------------------------------------------------------------------------------------------------------------------------------------\n");
            }

            System.out.println(courses.get(i).toString());
        }

        scanner.close();
    }

    public GUI(){
        System.out.print("code");
    }

        public static void main (String[]args){
        GUI program= new GUI();
            try {
                program.writeCourseData();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        program.showCurriculum();

        }
    }



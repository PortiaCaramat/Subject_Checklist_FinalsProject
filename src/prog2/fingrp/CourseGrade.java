package prog2.fingrp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// still needs modifications
// changed grade to double
public class CourseGrade extends Course implements Serializable {
    private String grade;
    private boolean complete;

    public CourseGrade(){
        super(1,1, "","",1);
        grade = "Not Finished";
    }

    public CourseGrade(int year,int term,String code,String title,int unit, String grade){
        super(year, term, code, title, unit);
        this.grade = grade;
    }

    public CourseGrade(Course course, String grade) {
        super(course.getYear(), course.getTerm(), course.getCode(), course.getTitle(), course.getUnit());
        this.grade = grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


    public String getGrade(){
        return grade;
    }

    public boolean isComplete() {
        return complete;
    }

    //calculates the GPA
    public double calculateGPA (List<CourseGrade> courseGrades){
        double totalWeightedGrades = 0.0;
        int totalUnits = 0;

        // Calculate the total weighted grades and total units
        for (CourseGrade courseGrade : courseGrades) { //keeps looping until it reaches the end
            double grade = Double.parseDouble(courseGrade.getGrade());
            if (grade != -1.0) {
                int units = courseGrade.getUnit(); //obtains the units value from the Course object

                /*
                calculates the GPA where the sum of the weighted grades of the subjects are divided
                by the sum of units of the subjects. The weighted grade of the subject is obtained by
                multiplying the final grade of the subject by the units of the subject.

                GPA = totalWeightedGrades / total Units
                 */
                double weightedGrade = grade * units;
                totalWeightedGrades += weightedGrade;
                totalUnits += units;
            }
        }

        // Calculate the GPA
        if (totalUnits > 0) { //if greater than zero, calculates GPA
            double gpa = totalWeightedGrades / totalUnits;
            return gpa;
        } else {
            return 0.0; // Return 0.0 if there are no units
        }
    }

    //sort courses alphabetically
    //called by and passing over a List and a boolean
    public List<CourseGrade> sortCoursesByTitle(List<CourseGrade> courseGrades, boolean sortAlphabetically) {
        if (sortAlphabetically) {
            // create a custom Comparator to compare course titles
            Comparator<CourseGrade> courseComparator = new Comparator<CourseGrade>() {
                @Override
                public int compare(CourseGrade c1, CourseGrade c2) {
                    return c1.getTitle().compareTo(c2.getTitle());
                }
            };

            // Create a new ArrayList to store the sorted courses
            List<CourseGrade> sortedCourses = new ArrayList<>(courseGrades);

            // Sort the courses in the new ArrayList using the custom Comparator
            sortCourses(sortedCourses, courseComparator);

            return sortedCourses;
        } else {
            return new ArrayList<>(courseGrades);
        }
    }

    // Custom sorting method
    private void sortCourses(List<CourseGrade> courses, Comparator<CourseGrade> comparator) {
        int n = courses.size();


        //BubbleSort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(courses.get(j), courses.get(j + 1)) > 0) {
                    // Swap elements
                    CourseGrade temp = courses.get(j);
                    courses.set(j, courses.get(j + 1));
                    courses.set(j + 1, temp);
                }
            }
        }
    }

    public String toString(){
        return String.format("%-20s%-100s%-20s%-30s",getCode(),getTitle(), getUnit(),grade);}


}

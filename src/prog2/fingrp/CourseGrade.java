package prog2.fingrp;

import java.io.Serializable;

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

    public String toString(){
        return String.format("%-20s%-100s%-20s%-30s",getCode(),getTitle(), getUnit(),grade);}


}

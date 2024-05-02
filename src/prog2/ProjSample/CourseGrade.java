package ProjSample;
import java.util.Objects;


// still needs modifications
public class CourseGrade extends Course{
    private int grade;

    public CourseGrade(){
        super(1,"", "","",1);
        grade=0;
    }

    public CourseGrade(int year,String term,String code,String title,int unit, int grade){
        super(year, term, code, title, unit);
        this.grade= grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade(){
        return grade;
    }

    public String toString(){
        return String.format("%-20s%-100s%-20s%-30s",getCode(),getTitle(), getUnit(),grade);}


}

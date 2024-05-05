package prog2.finalgroup;

public class Course {
    private String code;
    private String title;
    private int units;
    private int grade;
    public Course() {
        code = "";
        title = "";
        units = 0;
        grade = 0;
    }
    public Course(String code, String title, int units) {
        this.code = code;
        this.title = title;
        this.units = units;
    }
    public Course(String code, String title, int units, int grade) {
        this.code = code;
        this.title = title;
        this.units = units;
        this.grade = grade;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getUnits() {
        return units;
    }

    public int getGrade() {
        return grade;
    }
    public String toString() {
        return String.format("%-10s %-70s %5d", code, title, units);
    }
}

package prog2.finalgroup;

public class CourseNameSorter extends Course implements Comparable<Course>{
    public CourseNameSorter(String code, String title, int units){
        super(code, title, units);
    }
    @Override
    public int compareTo(Course other) {
        return (this.getTitle().compareTo(other.getTitle()));
    }
    public String toString () {
        return super.toString();
    }
}

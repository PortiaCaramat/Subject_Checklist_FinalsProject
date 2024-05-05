package prog2.fingrp;

//delete later
@Deprecated
public class CourseNameSorter extends Course implements Comparable<Course>{
    @Override
    public int compareTo(Course other) {
        return (this.getTitle().compareTo(other.getTitle())); //no point in having this when the String class has one
    }

    public String toString () {
        return super.toString();
    }
}

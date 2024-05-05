package prog2.fingrp;

public class CourseGradeSorter extends Course implements Comparable<Course>{
    @Override
    public int compareTo(Course other) {
        if (this.getGrade() == other.getGrade()) {
            return 0;
        } else if (this.getGrade() > other.getGrade()) {
            return 1;
        } else {
            return -1;
        }
    }
}

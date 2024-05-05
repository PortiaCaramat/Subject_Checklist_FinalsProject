package prog2.fingrp;

/*
*
* */
public class CourseGradeSorter extends CourseGrade implements Comparable<CourseGrade>{
    @Override
    public int compareTo(CourseGrade other) {
        if (this.getGrade() == other.getGrade()) {
            return 0;
        } else if (this.getGrade() > other.getGrade()) {
            return 1;
        } else {
            return -1;
        }
    }
}

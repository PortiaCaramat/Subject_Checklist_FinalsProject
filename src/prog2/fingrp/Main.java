package prog2.fingrp;
import java.util.Scanner;
import java.io.*;
public class Main {
    static Course course = new Course("Discrete Structures", "9302", 3, 87.1, false);
    public static void main(String[] args) throws FileNotFoundException {
       FileToCourses sem = new FileToCourses("C:\\Users\\Sean\\Documents\\Subject_Checklist_FinalsProject\\src\\prog2\\fingrp\\Curriculum\\f1s1.tsv");
       sem.printCourses();
    }


}

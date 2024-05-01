package prog2.fingrp;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final File folder = new File("src\\prog2\\fingrp\\DATA\\year2\\read_only");

        for (Course course: DatReadWrite.readFolder(folder)) {
            System.out.println(course);
            System.out.println();
        }

    }
}

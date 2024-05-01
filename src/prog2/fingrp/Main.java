package prog2.fingrp;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final File folder = new File("src\\prog2\\fingrp\\DATA\\year2\\read_only");

        //writeToFolder(folder);
        //readFolder(folder);
        System.out.println(DatReadWrite.read(folder.getPath() + "\\sem3.dat").get(1));
    }


    static void writeToFolder(File folder) throws IOException {
        int i = 1;
        for(final File fileEntry: folder.listFiles()) {
            FileToCourses sem = new FileToCourses(fileEntry.getPath());

            DatReadWrite.write(sem.toCourse(), folder.getPath() + "\\sem" + i + ".dat");
            i++;
        }
    }

    static void readFolder(File folder) throws IOException, ClassNotFoundException {
        int i = 1;
        for(final File fileEntry: folder.listFiles()) {
            DatReadWrite.read(folder.getPath() + "\\sem" + i + ".dat");
            i++;
        }
    }
}

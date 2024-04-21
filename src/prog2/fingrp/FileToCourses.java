package prog2.fingrp;
import java.io.*;
import java.util.ArrayList;

public class FileToCourses {
	FileReader fr;
	BufferedReader br;
	static ArrayList<Course> courses = new ArrayList<>();

	FileToCourses(String fileName) throws IOException {
		//check if input file is a tsv
		if (isTSV(fileName)) throw new IOException("File is not tsv");

		fr = new FileReader(fileName);
		br = new BufferedReader(fr);

		try {
			String line;
			while ((line = br.readLine()) != null) {
				String[] courseString = line.split("\t");
				courses.add(extractToCourse(courseString));
			}
 		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static Course extractToCourse(String[] data) {
		String code = data[0];
		String title = data[1];
		int units = Integer.parseInt(data[2]);
		return new Course(title, code, units, false);
	}

	private boolean isTSV(String fileName) {
		if (fileName == null) throw new NullPointerException("File cannot be null");
		int dotIndex = fileName.indexOf(".");

		return fileName.substring(dotIndex).equalsIgnoreCase("tsv");
	}

	public void printCourses() {
		for(Course c : courses) {
			System.out.println(c);
			System.out.println();
		}
	}
}

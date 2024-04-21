package prog2.fingrp;
import java.io.*;
import java.util.ArrayList;

public class FileToCourses {
	FileReader fr;
	BufferedReader br;
	static ArrayList<Course> courses = new ArrayList<>();

	FileToCourses(String fileName) throws FileNotFoundException {
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

	public void printCourses() {
		for(Course c : courses) {
			System.out.println(c);
			System.out.println();
		}
	}
}

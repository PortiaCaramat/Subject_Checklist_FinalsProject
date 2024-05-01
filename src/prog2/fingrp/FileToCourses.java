package prog2.fingrp;
import java.io.*;
import java.util.ArrayList;

public class FileToCourses {
	FileReader fr;
	BufferedReader br;
	final private String fileName;


	FileToCourses(String fileName) throws IOException {
		this.fileName = fileName;
	}

	public ArrayList<Course> toCourse() throws IOException{
		ArrayList<Course> courses = new ArrayList<>();

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

		return courses;
	}

	private static Course extractToCourse(String[] data) {
		String code = data[0];
		String title = data[1];
		int units = Integer.parseInt(data[2]);
		return new Course(title, code, units);
	}

}

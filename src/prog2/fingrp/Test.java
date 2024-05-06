package prog2.fingrp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Test {

	static DatReadWrite<Course> courseDat = new DatReadWrite<>();
	static DatReadWrite<CourseGrade> gradeDat = new DatReadWrite<>();

	public static void main(String[] args) {


//		try {
//			gradeDat.write(courseGradeList(), "src\\prog2\\fingrp\\DATA\\CurriculumPersonal.dat");
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException(e);
//		}


		try {
			for (CourseGrade cg : gradeDat.read("src\\prog2\\fingrp\\DATA\\CurriculumPersonal.dat")) {
				System.out.println(cg);
				System.out.println();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	public static ArrayList<CourseGrade> courseGradeList() throws IOException, ClassNotFoundException {
		ArrayList<CourseGrade> grades = new ArrayList<>();
		for (Course c: courseDat.read("src\\prog2\\fingrp\\DATA\\Curriculum.dat")) {
			grades.add(new CourseGrade(c, "Not finished"));
		}
		return grades;
	}


}

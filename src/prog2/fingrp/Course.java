package prog2.fingrp;

public class Course {
	private String title;
	private String code;
	private int unit;
	private double grade;
	private boolean complete;

	public Course() {
		this.title = null;
		this.code = null;
		this.unit = 0;
		this.grade = 0.0;
		this.complete = false;
	}

	public Course(String title, String code, int units, double grade, boolean complete) {
		this.title = title;
		this.code = code;
		this.unit = units;
		this.grade = grade;
		this.complete = complete;
	}


	//setters

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	//getters


	public String getTitle() {
		return title;
	}

	public String getCode() {
		return code;
	}

	public int getUnit() {
		return unit;
	}

	public double getGrade() {
		return grade;
	}

	public boolean isComplete() {
		return complete;
	}

	@Override
	public String toString() {
		return "Course title= " + title +
				"\nCourse Code= "+ code +
				"\nUnits= " + unit +
				"\nGrade= " + grade +
				"\nComplete?= " + complete;
	}
}

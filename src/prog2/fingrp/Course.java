package prog2.fingrp;

import java.io.Serializable;

public class Course implements Serializable{
	private String title;
	private String code;
	private int unit;
	private double grade;
	private boolean complete;

	public Course() {
		title = null;
		code = null;
		unit = 0;
		grade = 0.0;
		complete = false;
	}

	public Course(String title, String code, int units) {
		this.title = title;
		this.code = code;
		this.unit = units;
		this.grade = 0.0;
		complete = false; // if grade is not given, assume that course is incomplete
	}

	public Course(String title, String code, int units, double grade) {
		this.title = title;
		this.code = code;
		this.unit = units;
		this.grade = grade;
		complete = true; // if grade is given, assume that course is complete
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
				"\nGrade=" + grade +
				"\nComplete?= " + complete;

	}
}

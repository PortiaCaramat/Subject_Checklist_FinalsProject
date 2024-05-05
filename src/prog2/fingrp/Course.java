package prog2.fingrp;

import java.io.Serializable;

import static java.lang.String.format;

public class Course implements Serializable {
	private int year;
	private int term;
	private String title;
	private String code;
	private int unit;

	public Course() {
		this.year= 1;
		this.term= 1;
		this.title = null;
		this.code = null;
		this.unit = 0;
	}

	public Course(int year, int term, String code, String title, int unit) {
		this.year = year;
		this.term = term;
		this.title = title;
		this.code = code;
		this.unit = unit;
	}


	//setters

	public void setYear(int year){this.year =year;}
	public void setTerm(int term){this.term= term;}
	public void setTitle(String title) {
		this.title = title;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}
	//getters
	public int getYear(){return year;}

	public int getTerm(){return term;}
	public String getTitle() {
		return title;
	}

	public String getCode() {
		return code;
	}

	public int getUnit() {
		return unit;
	}


	@Override
	public String toString() {
		return format("%-20s%-100s%-22s%n", code,title,unit) ;
	}
}

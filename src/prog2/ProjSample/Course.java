package ProjSample;

import static java.lang.String.format;

public class Course {

	private int year;
	private String term;
	private String title;
	private String code;
	private int unit;

	public Course() {
		this.year= 1;
		this.term= "";
		this.title = null;
		this.code = null;
		this.unit = 0;
	}

	public Course(int year, String term,String code, String title, int unit) {
		this.year = year;
		this.term = term;
		this.title = title;
		this.code = code;
		this.unit = unit;
	}


	//setters

	public void setYear(int year){this.year =year;}
	public void setTerm(String term){this.term= term;}
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

	public String getTerm(){return term;}
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

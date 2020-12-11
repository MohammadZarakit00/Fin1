package model;

import java.util.ArrayList;

public class Course {

	private ArrayList<WrittenExam> courseExamList = new ArrayList<>();

	private String courseCode;
	
	private String name;
	
	private String credits;

	public Course(String courseCode){
		if(courseCode.startsWith("C") && courseCode.length() == 6){
			this.courseCode = courseCode;
		} else {
			System.out.println("Fel format på coursecode");
		}

	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

}

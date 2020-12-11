package model;

import java.util.ArrayList;

public class Course {

	private ArrayList<WrittenExam> courseExamList = new ArrayList<>();

	private String courseCode;
	
	private String name;
	
	private int credits;

	public Course(String courseCode){
		if(courseCode.startsWith("C") && courseCode.length() == 6){
			this.courseCode = courseCode;
		} else {
			System.out.println("Fel format på coursecode");
		}
	}

	public void addExam(WrittenExam writtenExam){
		courseExamList.add(writtenExam);
		writtenExam.setCurrentCourse(this); //kopplar denna kursen till en Exam

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

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

}

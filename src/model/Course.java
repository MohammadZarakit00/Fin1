package model;

import java.util.ArrayList;

public class Course {

	private ArrayList<WrittenExam> courseExamList = new ArrayList<>();

	private String courseCode;
	
	private String name;
	
	private int credits;


	/*
	Borde kanske ha flera nästlade if-satser i constructorn så att vi kan se i vilket steg
	det går fel.
	 */
	public Course(String courseCode, String name, int credits){
		if(credits > 0 && credits <= 100 && courseCodeCheck(courseCode)) {
			this.courseCode = courseCode;
			this.name = name;
			this.credits = credits;
		}
	}

	/*
	Kan baka in credits-check i samma metod för att minska koden i konstruktorn.
	 */
	public Boolean courseCodeCheck(String courseCode){
		return courseCode.startsWith("C") && courseCode.length() == 6;
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


	/*
	Onödigt pga constructor?
	 */
	public void setCredits(int credits) {
		if(credits > 0 && credits <= 100) {
			this.credits = credits;
		} else {
			System.out.println("Antal credits för course är för lågt eller högt");
		}
	}

}

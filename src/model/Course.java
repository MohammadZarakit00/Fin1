package model;

import java.util.ArrayList;

public class Course {

	private ArrayList<WrittenExam> courseExamList = new ArrayList<>();

	private String courseCode;

	private String name;

	private double credits;


	/*
	Borde kanske ha flera nästlade if-satser i constructorn så att vi kan se i vilket steg
	det går fel.
	 */
	public Course(String courseCode, String name, double credits){
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
		String subString = courseCode.substring(1);
		int courseNr = Integer.parseInt(subString);
		return courseCode.startsWith("C") && courseCode.length() == 6 && (courseNr >= 10000 && courseNr <= 99999);
	}


	public void addExam(WrittenExam writtenExam){
		courseExamList.add(writtenExam);
		writtenExam.setCurrentCourse(this); //kopplar denna kursen till en Exam
		if(!WrittenExamRegister.getExamRegInstance().containsExam(writtenExam.getExamID())) {
			WrittenExamRegister.getExamRegInstance().add(writtenExam); //Läggs till i externt register
		}
	}

	public WrittenExam findExam(String examId){
		for(WrittenExam exam : courseExamList){
			if(exam.getExamID().equals(examId)){
				return exam;
			}
		}
		return null;
	}

	public WrittenExam removeExam(String examId){
		WrittenExam tmpExam = findExam(examId);
		if(courseExamList.contains(tmpExam)){
			courseExamList.remove(tmpExam);
			return tmpExam;
		} else {
			return null;
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

	public double getCredits() {
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

package model;

import java.util.ArrayList;

public class Student {

	private String studentId;
	
	private String name;

	private ArrayList<WrittenExam> examList = new ArrayList<>();

	public Student(String studentId, String name){
		if(studentId.startsWith("S") && studentId.length() == 6){ //Kollar kraven för studentId
			this.name = name;
		} else {
			System.out.println("Not valid input");
		}
	}

	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addExam(WrittenExam exam){
		examList.add(exam);
	}

	public void removeExam(WrittenExam exam){
		if(examList.contains(exam)) {
			examList.remove(exam);
		} else {
			System.out.println("Provet är ej registrerat hos denna student");
		}
	}

}

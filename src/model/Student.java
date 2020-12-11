package model;

import java.util.ArrayList;

public class Student {

	private String studentId;
	
	private String name;

	private ArrayList<WrittenExam> examList = new ArrayList<>();

	public Student(String studentId, String name){
		this.studentId = studentId;
		this.name = name;
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
		examList.remove(exam);
	}

}

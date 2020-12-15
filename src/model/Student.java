package model;

import java.util.HashMap;

public class Student {

	private String studentId;
	private String name;
	private HashMap<WrittenExam, Result> examResultMap = new HashMap<>();

	public Student(String studentId, String name){
		if(studentValidCheck(studentId, name)){ //Kollar kraven för studentId
			this.studentId = studentId;
			this.name = name;
			System.out.println("Det funkar");
		} else {
			System.out.println("Not valid input");
		}
	}

	public HashMap<WrittenExam, Result> getExamResultMap() {
		return examResultMap;
	}
	public Boolean studentValidCheck(String studentId, String name){
		return studentId.startsWith("S") && studentId.length() == 6 && !name.isEmpty();
	}
	public void setExamResultMap(HashMap<WrittenExam, Result> examResultMap) {
		this.examResultMap = examResultMap;
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

	public void addExam(WrittenExam exam, Result result){
		examResultMap.put(exam, result);
	}
	public void removeExam(WrittenExam exam){
		if(examResultMap.containsKey(exam)) {
			examResultMap.remove(exam);
		} else {
			System.out.println("Provet är ej registrerat hos denna student");
		}
	}

}

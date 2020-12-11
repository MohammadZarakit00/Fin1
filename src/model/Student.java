package model;

import java.util.ArrayList;

public class Student {
	
	private ArrayList<Student> sList = new ArrayList<Student>();
	
	private String studentId;
	
	private String name;
	
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
	
	public void addStudent(Student s) {
		sList.add(s);
	}
	
	public Student findStudent(String studentId) {
		for (Student tmpS : sList) {
			if (tmpS != null) {
				return tmpS;
			}
		}
		return null;
	}
	
	public Student deleteStudent(String studentId) {
		if (sList.contains(findStudent(studentId))) {
			sList.remove(findStudent(studentId));
			System.out.println(studentId + " was deleted from the system.");
		}
		return null;
	}
	

}

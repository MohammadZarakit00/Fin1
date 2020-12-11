package model;

import java.util.ArrayList;

public class WrittenExam {
	
	private String examID;
	
	private String date;
	
	private String location;
	
	private String time;
	
	private double maxPoints = 100;
	
	public ArrayList<Student> sList = new ArrayList<Student>();

	public String getExamID() {
		return examID;
	}
	public void setExamID(String examID) {
		this.examID = examID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getMaxPoints() {
		return maxPoints;
	}
	public void setMaxPoints(double maxPoints) {
		this.maxPoints = maxPoints;
	}
	
	public void addStudent(Student s) {
		sList.add(s);
	}
	
	public Student findStudent(Student studentId) {
		for (Student tmpId : sList) {
			if (sList.contains(tmpId)) {
				return studentId;
			}
		}
		return null;
	}

}

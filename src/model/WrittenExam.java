package model;

import java.util.ArrayList;

public class WrittenExam {
	
	private String examID;
	
	private String date;
	
	private String location;
	
	private String time;
	
	private double maxPoints = 100;

	private Course currentCourse; 

	public Course getCurrentCourse() {
		return currentCourse;
	}

	public void setCurrentCourse(Course currentCourse) {
		this.currentCourse = currentCourse;
	}

	private ArrayList<Student> sList = new ArrayList<>();
	private ArrayList<Course> courseList = new ArrayList<Course>();

	public WrittenExam(String examID){
		if(checkExamIdInput(examID)){
			this.examID = examID;
		} else {
			System.out.println("Fel format på examId");
		}
	}

	public Boolean checkExamIdInput(String examID){
		String subString = examID.substring(1);
		int examIdNumber = Integer.parseInt(subString);
		return examID.startsWith("E") && examID.length() == 6 && (examIdNumber >= 10000 && examIdNumber <= 99999);
	}

	public ArrayList<Student> getsList() {
		return sList;
	}
	public void setsList(ArrayList<Student> sList) {
		this.sList = sList;
	}
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
	
	public void addStudent(Student student, Result result) {
		student.addExam(this, result); //Dubbelkopplar
		sList.add(student);
	}
	
	public Student findStudent(String studentId) {
		for (Student tmpStudent : sList) {
			if (tmpStudent.getStudentId().equals(studentId)) {
				return tmpStudent;
			}
		}
		return null;
	}


	/*
	Fundera vidare kring deleteStudents returtyp, är det nödvändigt att returnera
	en student? Bättre med boolean eller void?
	 */
	public Student deleteStudent(String studentId) {
		Student tmpStudent = findStudent(studentId);
		if(sList.contains(tmpStudent)){
			sList.remove(tmpStudent);
			tmpStudent.removeExam(this);
			return tmpStudent;
		} else {
			System.out.println("Student finns ej på detta prov");
		}
		return null;
	}
	
	public void addCourse(Course course) {
		courseList.add(course);
	}

}

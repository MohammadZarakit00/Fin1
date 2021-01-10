package model;

import java.util.ArrayList;

public class StudentRegister {

    private static StudentRegister studentRegisterInstance;
    private ArrayList<Student> studentRegister = new ArrayList<>();

    public static StudentRegister getStudentRegInstance(){
        if(studentRegisterInstance == null){
            studentRegisterInstance = new StudentRegister();
        }
        return studentRegisterInstance;
    }

    private StudentRegister(){
        studentRegister = new ArrayList<>();
    }

    public ArrayList<Student> getStudentList(){
        return this.studentRegister;
    }

    public void add(Student student){
        studentRegister.add(student);
    }

    public void remove(String student){
        studentRegister.remove(findStudent(student));
    }
    
    public Student findStudent(String student) {
    	for (Student s : studentRegister) {
    		if (s.getStudentId().equals(student)) {
    			return s;
    		}
    	}
    	return null;
    }

	public boolean containsStudent(String student) {
		return findStudent(student) != null;
	}

}

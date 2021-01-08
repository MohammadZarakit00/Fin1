package model;

import java.util.ArrayList;

public class StudentRegister {

    private static StudentRegister studentRegisterInstance;
    private ArrayList<Student> studentList = null;

    public static StudentRegister getStudentRegInstance(){
        if(studentRegisterInstance == null){
            studentRegisterInstance = new StudentRegister();
        }
        return studentRegisterInstance;
    }

    private StudentRegister(){
        studentList = new ArrayList<>();
    }

    public ArrayList<Student> getStudentList(){
        return this.studentList;
    }

    public void add(Student student){
        studentList.add(student);
    }

    public void remove(Student student){
        studentList.remove(student);
    }

}

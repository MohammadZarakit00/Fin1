package model;

import java.util.HashMap;

public class Student {

    private String studentId;
    private String name;
    private HashMap<WrittenExam, Result> examResultMap = new HashMap<>();

    public Student(String studentId, String name) {
        if (studentValidCheck(studentId)) { //Kollar kraven för studentId
            this.studentId = studentId;
            this.name = name;
        }
    }

    public HashMap<WrittenExam, Result> getExamResultMap() {
        return examResultMap;
    }

    public Boolean studentValidCheck(String studentId) {
        String subString = studentId.substring(1);
        int studentIdNr = Integer.parseInt(subString);
        return studentId.startsWith("S") && studentId.length() == 6 && (studentIdNr >= 10000 && studentIdNr <= 99999);
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


    /*
    addExam-method that checks for duplicate exam and student in Singleton-register.
     */
    public void addExam(WrittenExam exam, Result result) {
        examResultMap.put(exam, result);
        exam.addStudent(this);
        if (!WrittenExamRegister.getExamRegInstance().containsExam(exam.getExamID())) {
            WrittenExamRegister.getExamRegInstance().add(exam);
        }
        if (!StudentRegister.getStudentRegInstance().containsStudent(this.studentId)) {
            StudentRegister.getStudentRegInstance().add(this);
        }
    }

    public Result getResult(WrittenExam exam) {
        return this.getExamResultMap().get(exam);
    }


    public void removeExam(WrittenExam exam) {
        if (examResultMap.containsKey(exam)) {
            examResultMap.remove(exam);
        } else {
            System.out.println("Provet är ej registrerat hos denna student");
        }
    }

    public int getPointsFromExam(WrittenExam exam) {
        return examResultMap.get(exam).getResult();
    }
}

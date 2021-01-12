package model;

import java.util.ArrayList;

public class CourseRegister {

    private static CourseRegister courseRegisterInstance;
    private ArrayList<Course> courseRegister = new ArrayList<>();


    public static CourseRegister getCourseRegInstance() {
        if (courseRegisterInstance == null) {
            courseRegisterInstance = new CourseRegister();
        }
        return courseRegisterInstance;
    }

    public ArrayList<Course> getCourseRegister() {
        return courseRegister;
    }

    public void setCourseRegister(ArrayList<Course> courseRegister) {
        this.courseRegister = courseRegister;
    }

    public void add(Course course) {
        if (course != null && !this.containsCourse(course.getCourseCode())) {
            courseRegister.add(course);
        }
    }

    public void deleteCourse(String course) {
        Course tmpCourse = findCourse(course);
        for(WrittenExam exam : tmpCourse.getCourseExamList()){
            exam.setCurrentCourse(null);
            for(Student s : exam.getStudentList()){
                s.removeExam(exam);
            }
            courseRegister.remove(tmpCourse);
            exam.getStudentList().clear();
            WrittenExamRegister.getExamRegInstance().remove(exam.getExamID());
        }

    }

    public Course findCourse(String course) {
        for (Course c : courseRegister) {
            if (c.getCourseCode().equals(course)) {
                return c;
            }
        }
        return null;
    }

    public Boolean containsCourse(String course) {
        return findCourse(course) != null;
    }

    public Boolean checkExamUnique(String examId) {
        boolean unique = true;
        for (Course c : courseRegister) {
            if (c.containsExam(examId)) {
                unique = false;
            }
        }
        return unique;
    }
}


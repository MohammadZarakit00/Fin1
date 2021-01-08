package model;

import java.util.ArrayList;

public class CourseRegister {

    private static CourseRegister courseRegisterInstance;
    private ArrayList<Course> courseRegister = new ArrayList<>();


    public static CourseRegister getCourseRegInstance(){
        if(courseRegisterInstance == null){
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
        if (course != null) {
            courseRegister.add(course);
        }
    }

    public void remove(String course) {
        courseRegister.remove(findCourse(course));
    }

    public Course findCourse(String course){
        for(Course c : courseRegister){
            if(c.getCourseCode().equals(course)){
                return c;
            }
        }
        return null;
    }

    public Boolean containsCourse(String course){
        return findCourse(course) != null;
    }
}


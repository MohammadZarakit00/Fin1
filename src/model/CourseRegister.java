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

    public void remove(Course c) {
        courseRegister.remove(c);
    }
}


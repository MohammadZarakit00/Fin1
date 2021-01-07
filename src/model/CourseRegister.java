package model;

import java.util.ArrayList;

public class CourseRegister {

    private ArrayList<Course> courseRegister = new ArrayList<>();

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


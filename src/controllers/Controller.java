package controllers;

import application.Loader;
import application.Main;
import model.CourseRegister;

public class Controller {

    private CourseRegister courseRegister = new CourseRegister();

    public CourseRegister getCourseRegister() {
        return courseRegister;
    }

    public void setCourseRegister(CourseRegister courseRegister) {
        this.courseRegister = courseRegister;
    }

}

package controllers;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Course;
import model.CourseRegister;
import model.StudentRegister;

public class CourseManagementController {

    private CourseRegister courseRegister = CourseRegister.getCourseRegInstance();
    private StudentRegister studentRegister = StudentRegister.getStudentRegInstance();


    @FXML
    TextField tfId = new TextField();
    @FXML
    TextField tfName = new TextField();
    @FXML
    TextField tfCredits = new TextField();
    @FXML
    TextArea taErrorText = new TextArea();
    @FXML
    TextArea outPutArea = new TextArea();
    @FXML
    Button btnAddCourse = new Button();
    @FXML
    Button btnFindCourse = new Button();
    @FXML
    Button btnUpdateCourse = new Button();
    @FXML
    Button btnRemoveCourse = new Button();
    @FXML
    Button btnGenerateCourseCode = new Button();

    //Adds a course with the necessary information. Refuses if any field is incorrectly entered.
    @FXML
    public void btnAddCourse(ActionEvent event) {
        taErrorText.clear();
        outPutArea.clear();
        String tmpId = tfId.getText();
        String tmpName = tfName.getText();
        String tmpCredit = tfCredits.getText();

        if (tmpId.isEmpty() || tmpName.isEmpty() || tmpCredit.isEmpty()) {
            taErrorText.setText("Please fill in all of the fields before adding a course. ");
        } else {

            try {
                double tmpCredits = Double.parseDouble(tfCredits.getText());
                Course course = new Course(tmpId, tmpName, tmpCredits);
                if (!course.courseCodeCheck(tmpId)) {
                    taErrorText.setText("You must enter a valid course code. A course code starts with a capital 'C' and is followed by 5 numbers. E.g. C51236, C19923, et cetera. ");
                } else if (courseRegister.containsCourse(tmpId)) {
                    taErrorText.setText("A course with that ID is already registered. ");
                } else if (tmpCredit.isEmpty()) {
                    taErrorText.setText("You must also enter the number of credits this course is worth, e.g. 10, 30, 7.5, et cetera. ");
                } else if (tmpCredits > 100.0 || tmpCredits < 0) {
                    taErrorText.setText("Input is not accepted. Course credits input must be a number between 0 and 100. ");
                } else {
                    courseRegister.add(new Course(tmpId, tmpName, tmpCredits));
                    outPutArea.setText("Course " + tmpName + " with course code " + tmpId + " worth " + tmpCredits + " credits was added to the list.");
                    taErrorText.clear();
                }
            } catch (NumberFormatException e) {
                taErrorText.setText("Input is not accepted. Course credits input must be a number between 0 and 100. ");
            }
        }

    }

    @FXML
    public void btnUpdateCourse(ActionEvent event) {
        taErrorText.clear();
        outPutArea.clear();
        String tmpName = tfName.getText();
        String tmpStringCredits = tfCredits.getText();

        if (tmpName.isEmpty() || tmpStringCredits.isEmpty()) {
            taErrorText.setText("You must enter the name and credits fields to update a Course. ");
        } else {

            try {
                double tmpCredits = Double.parseDouble(tfCredits.getText());
                if (tmpCredits > 100.0 || tmpCredits < 0) {
                    taErrorText.setText("Input is not accepted. Course credits input must be a number between 0 and 100. ");
                } else {
                    for (Course c : courseRegister.getCourseRegister()) {
                        c.setName(tmpName);
                        c.setCredits(tmpCredits);
                    }
                }
                outPutArea.setText("Updated course name " + tmpName + ", and credits " + tmpCredits + ". ");
                taErrorText.clear();
            } catch (NumberFormatException e) {
                taErrorText.setText("Input is not accepted. Course credits input must be a number between 0 and 100. ");
            }
        }
    }

    //Generates a random course code 
    @FXML
    public void btnGenerateCourseCode(ActionEvent event) {
        Random courseGen = new Random();
        int courseCode = courseGen.nextInt(99999 + 1 - 10000) + 10000;
        tfId.clear();
        tfId.setText("C" + courseCode);
        String tmpId = tfId.getText();
        if (courseRegister.containsCourse(tmpId)) {
            tfId.clear();
            tfId.setText("C" + courseGen.nextInt(courseCode));

        }
    }

    //Removes a course if it exists, as well as all its exams. WIP
    @FXML
    public void btnRemoveCourse(ActionEvent event) {
        taErrorText.clear();
        outPutArea.clear();
        String tmpId = tfId.getText();
        if (tmpId.trim().isEmpty()) {
            taErrorText.setText("Please enter a Course-ID");
        } else if (courseRegister.findCourse(tmpId) == null) {
            taErrorText.setText("Course " + tmpId + " is not registered in the system.");
        } else {
            courseRegister.deleteCourse(tmpId);
            outPutArea.setText("The course " + tmpId + " was removed from the register along with its exams. ");
            taErrorText.clear();
        }
    }

    //Finds a course with the given ID.
    @FXML
    public void btnFindCourse(ActionEvent event) {
        taErrorText.clear();
        String tmpId = tfId.getText();
        if (tmpId.isEmpty()) {
            taErrorText.setText("Please enter a Course-ID");
        } else if (courseRegister.findCourse(tmpId) == null) {
            taErrorText.setText("Course " + tmpId + " is not registered in the system.");
        } else {
            Course tmpCourse = courseRegister.findCourse(tmpId);
            if (!tmpCourse.courseCodeCheck(tmpId)) {
                taErrorText.setText("Course-ID is not valid, it should start with a C and be followed by 5 numbers between 10000 and 99999," +
                        ", for example C12345, C10009");
            } else if (tmpCourse.getCourseCode().equals(tmpId)) {
                outPutArea.setText("The course " + tmpCourse.getName() + " with course code " + tmpCourse.getCourseCode() + " was found in the register. ");
                taErrorText.clear();
            } else {
                outPutArea.setText("The course " + tmpId + " does not exist in the register. ");
            }
        }
    }
}



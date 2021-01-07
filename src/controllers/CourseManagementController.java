package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Course;

import java.awt.*;

public class CourseManagementController {


    @FXML
    TextField tfId = new TextField();
    @FXML
    TextField tfName = new TextField();
    @FXML
    TextField tfCredits = new TextField();
    @FXML
    TextArea outPutArea = new TextArea();

    @FXML
    Button btnAddCourse = new Button();
    @FXML
    Button btnFindCourse = new Button();
    @FXML
    Button btnRemoveCourse = new Button();
/*
    @FXML
    public void btnAddCourse (ActionEvent event){
        String tmpId = tfId.getText();
        String tmpName = tfName.getText();
        try {
            int tmpCredits = Integer.parseInt(tfCredits.getText());
            courseRegister.add(new Course(tmpId, tmpName, tmpCredits));
            outPutArea.setText("Course " + tmpName + " with course code " + tmpId + " worth " + tmpCredits + " credits was added to the list.");
        } catch (NumberFormatException e) {
            outPutArea.setText("Input is not accepted. Course credits input must be a number. ");
        }
    }

    @FXML
    public void btnRemoveCourse (ActionEvent event){
        String tmpId = tfId.getText();
        for (Course c : courseRegister) {
            if (c.getCourseCode().equals(tmpId)) {
                courseRegister.remove(c);
                ta.setText(tmpId + " was removed from the register.");
            } else {
                ta.setText(tmpId + " does not exist in the register.");
            }
        }
    }
*/



}

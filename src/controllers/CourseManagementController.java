package controllers;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Course;
import model.CourseRegister;
import model.StudentRegister;

public class CourseManagementController extends Controller {
	
    private CourseRegister courseRegister = CourseRegister.getCourseRegInstance();
    private StudentRegister studentRegister = StudentRegister.getStudentRegInstance();


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
    @FXML
    Text courseError = new Text();

    @FXML
    Button btnGenerateCourseCode = new Button();

    

   
    
    //Adds a course with the necessary information. Refuses if any field is incorrectly entered.
    @FXML
    public void btnAddCourse (ActionEvent event){
        String tmpId = tfId.getText();
        String tmpName = tfName.getText();
        try {
        	if (courseRegister.getCourseRegister().contains(tmpId)) {
        		outPutArea.setText(tmpId + " already exists in the database. "); 
        	}
            int tmpCredits = Integer.parseInt(tfCredits.getText());
            courseRegister.add(new Course(tmpId, tmpName, tmpCredits));
            outPutArea.setText("Course " + tmpName + " with course code " + tmpId + " worth " + tmpCredits + " credits was added to the list.");
        	
        	} catch (NumberFormatException e) {
            courseError.setText("Input is not accepted. Course credits input must be a number. ");
            
        }
    }

    //Generates a random course code 
    @FXML
    public void btnGenerateCourseCode(ActionEvent event){
        Random courseGen = new Random();
        int courseCode = courseGen.nextInt(99999 + 1 - 10000)+10000;
        tfId.clear();
        tfId.setText("C" + courseCode);
    //Checks if the generated course code already exists and rolls again until a unique value is reached.
    //Might need a LinkedHashSet to check duplicates more elegantly.
        String tmpId = tfId.getText();
        for (Course c : courseRegister.getCourseRegister()) {
        	if (courseRegister.containsCourse(tmpId)) {
        		tfId.clear();
        		tfId.setText("C" + courseGen.nextInt(courseCode));        		
        	}
        }     	  
    }
    
    //Removes a course if it exists.
    @FXML
    public void btnRemoveCourse (ActionEvent event){
        String tmpId = tfId.getText();
        if(courseRegister.containsCourse(tmpId)){
            courseRegister.remove(tmpId);
            outPutArea.setText("The course " + tmpId + " was removed from the register. ");
        } else {
            outPutArea.setText("The course " + tmpId + " does not exist in the register. ");
        }
    }

    //Finds a course with the given ID.
    @FXML
    public void btnFindCourse(ActionEvent event){
        String tmpId = tfId.getText();
        for(Course c : courseRegister.getCourseRegister()){
            if(c.getCourseCode().equals(tmpId)){
                outPutArea.setText(c.getName());
            } else {
                outPutArea.setText("The course " + tmpId + " does not exist in the register. ");
            }
        }
    }
}

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
import model.WrittenExam;

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
    TextArea taErrorText = new TextArea();
    @FXML
    TextArea outPutArea = new TextArea();
    @FXML
    Button btnAddCourse = new Button();
    @FXML
    Button btnFindCourse = new Button();
    @FXML
    Button btnRemoveCourse = new Button();
   

    @FXML
    Button btnGenerateCourseCode = new Button();

    

   
    
    //Adds a course with the necessary information. Refuses if any field is incorrectly entered.
    @FXML
    public void btnAddCourse (ActionEvent event){     
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
         	} else if (courseRegister.containsCourse(tmpId)) { //explosionsssssss
        	 taErrorText.setText("A course with that ID is already registered. ");
         	} else if (tmpCredit.isEmpty()) {
        	taErrorText.setText("You must also enter the number of credits this course is worth, e.g. 10, 30, 7.5, et cetera. ");               	
         	} else if (tmpCredits > 100.0 || tmpCredits < 0 ) {
         	taErrorText.setText("Input is not accepted. Course credits input must be a number between 0 and 100. ");	       	
         	} else {         
            courseRegister.add(new Course(tmpId, tmpName, tmpCredits));
            outPutArea.setText("Course " + tmpName + " with course code " + tmpId + " worth " + tmpCredits + " credits was added to the list.");
         	}
         } catch (NumberFormatException e) {
        	 taErrorText.setText("Input is not accepted. Course credits input must be a number between 0 and 100. ");
         	}
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
    
    //Removes a course if it exists, as well as all its exams.
    @FXML
    public void btnRemoveCourse (ActionEvent event){    	
        String tmpId = tfId.getText();
        Course course = courseRegister.findCourse(tmpId);
        if(tmpId.isEmpty()) {
        	taErrorText.setText("To remove a course you must enter its course code. ");
        } else {
        		if (courseRegister.containsCourse(tmpId)) {        		     				
        				course.getCourseExamList().clear();        			
        			}        		
        courseRegister.remove(tmpId);
        outPutArea.setText("The course " + tmpId + " was removed from the register along with its exams. ");
        }           
        taErrorText.setText("The course " + tmpId + " does not exist in the register. ");
        }

    //Finds a course with the given ID.
    @FXML
    public void btnFindCourse(ActionEvent event){
        String tmpId = tfId.getText();
        Course tmpCourse = courseRegister.findCourse(tmpId);      
            if(tmpCourse.getCourseCode().equals(tmpId)){
                outPutArea.setText("The course " + tmpCourse.getName() + " with course code " + tmpCourse.getCourseCode() + " was found in the register. " );
            } else {
                outPutArea.setText("The course " + tmpId + " does not exist in the register. ");
            }
        }
    }
}


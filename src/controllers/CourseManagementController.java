package controllers;

import java.awt.Label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Course;
import model.CourseRegister;

public class CourseManagementController extends Controller {

    private int courseCodeGen = 10000;
    public final CourseRegister courseRegister = super.getCourseRegister();

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
    Button btnGenerateCourseCode = new Button();
    @FXML
    TextField errorBox = new TextField();
    @FXML
    Text courseError = new Text();
   

    @FXML
    public void btnAddCourse (ActionEvent event){
    	boolean courseCodeCheck = false;
        String tmpId = tfId.getText();
        String tmpName = tfName.getText();
        if (courseCodeCheck == true) {
        try {
            int tmpCredits = Integer.parseInt(tfCredits.getText());
            courseRegister.add(new Course(tmpId, tmpName, tmpCredits));
            outPutArea.setText("Course " + tmpName + " with course code " + tmpId + " worth " + tmpCredits + " credits was added to the list.");
        } catch (NumberFormatException e) {
            courseError.setVisible(true);
			courseError.setText("Credits must be a number. ");
        }
        }
        else {
        	courseError.setVisible(true);
        	courseError.setText("Course code is not in a valid format. ");
        }
    }

    @FXML
    public void btnGenerateCourseCode(ActionEvent event){
        tfId.clear();
        tfId.setText("C" + courseCodeGen);
        courseCodeGen++;
    }

    @FXML
    public void btnRemoveCourse (ActionEvent event){
        String tmpId = tfId.getText();
        for (Course c : courseRegister.getCourseRegister()) {
            if (c.getCourseCode().equals(tmpId)) {
                courseRegister.remove(c);
                outPutArea.setText(tmpId + " was removed from the register.");
            } else {
            	courseError.setVisible(true);
                courseError.setText(tmpId + " does not exist in the register. Try again. ");                
            }
        }
    }

    @FXML
    public void btnFindCourse(ActionEvent event){
        String tmpId = tfId.getText();
        for(Course c : courseRegister.getCourseRegister()){
            if(c.getCourseCode().equals(tmpId)){
                outPutArea.setText(c.getName());
            } else {
            	courseError.setVisible(true);
                courseError.setText("Course can not be removed since it does not exist. ");
            }
        }
    }
}

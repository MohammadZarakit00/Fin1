package controllers;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Course;
import model.CourseRegister;

public class CourseManagementController extends Controller {

   /* public CourseManagementController(CourseRegister courseRegister){
        this.courseRegister = courseRegister;

    }*/

    private HomePageController homePageController;
    private int courseCodeGen = 10000;
    private CourseRegister courseRegister;
    private Main main;

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


    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void btnAddCourse (ActionEvent event){
        String tmpId = tfId.getText();
        String tmpName = tfName.getText();
        try {
            int tmpCredits = Integer.parseInt(tfCredits.getText());
            courseRegister.add(new Course(tmpId, tmpName, tmpCredits));
            outPutArea.setText("Course " + tmpName + " with course code " + tmpId + " worth " + tmpCredits + " credits was added to the list.");
            super.setCourseRegister(courseRegister);
        } catch (NumberFormatException e) {
            outPutArea.setText("Input is not accepted. Course credits input must be a number. ");
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
                outPutArea.setText(tmpId + " does not exist in the register.");
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
                outPutArea.setText("Kursen finns ej");
            }
        }
    }
}

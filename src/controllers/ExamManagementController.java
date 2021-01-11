package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Course;
import model.CourseRegister;
import model.WrittenExam;
import model.WrittenExamRegister;

public class ExamManagementController extends Controller {

	private CourseRegister courseRegister = CourseRegister.getCourseRegInstance();
	private WrittenExamRegister examRegister = WrittenExamRegister.getExamRegInstance();

	private Main main;

	@FXML
	ComboBox courseChoiceBox = new ComboBox(FXCollections.observableArrayList(courseRegister.getCourseRegister()));
	@FXML
	Button btnExamId = new Button();
	
	
	/*@FXML
	Button btnAddExam = new Button();
	@FXML
	Button btnRemoveExam = new Button();
	@FXML
	Button btnMeanResult = new Button();
	@FXML
	Button btnMedianResult = new Button();
	@FXML
	Button btnNbrPassedExam = new Button();
	@FXML
	Button btnAddStudentToExam = new Button();
	*/
	@FXML
	TextField tfId = new TextField();
	@FXML
	TextField tfDate = new TextField();
	@FXML
	TextField tfLocation = new TextField();
	@FXML
	TextField tfTime = new TextField();
	@FXML
	TextArea outPutArea = new TextArea();
	
	/*@FXML
	public void initialize(URL location, ResourceBundle resources){
		courseChoiceBox.setItems((ObservableList) CourseRegister.getCourseRegInstance());

	}*/

	//Im missing something here, can't figure out how to add the exam TO the course...
	/*@FXML
	public void btnAddExam(ActionEvent event) {
			String tmpIdExam = tfId.getText();
			String tmpIdDate = tfDate.getText();
			String tmpIdLocation = tfLocation.getText();
			String tmpIdTime = tfTime.getText();
			CourseRegister currentCourse = CourseRegister.getCourseRegInstance();
		examRegister.add(new WrittenExam(tmpIdExam, tmpIdDate, tmpIdLocation, tmpIdTime, course)); //this one is wonk supreme. needs to define exam FOR the given course
		outPutArea.setText("Exam " + tmpIdExam + " was added for the course " + currentCourse + ". ");
	} */
	
	//Same as above. Remove FROM a course.
	@FXML
	public void btnRemoveExam(ActionEvent event) {
		String tmpId = tfId.getText();
		if(examRegister.containsExam(tmpId)) {
			examRegister.remove(tmpId);
			outPutArea.setText("The exam " + tmpId + " was removed from the course. ");
		}
		else {
			outPutArea.setText("The exam " + tmpId + " does not exist in the register. ");
		}
	}
	
	
	@FXML
	public void btnMeanResult(ActionEvent event) {
		String tmpExamId = tfId.getText();
		for (WrittenExam e : examRegister.getExamRegister()) {
			if (e.getExamID().equals(tmpExamId)) {
				outPutArea.setText("Mean result for this exam is " + e.getMeanResult());
			}
			else {
				outPutArea.setText("No exam exists with this ID. Please try another. ");
			}
		}
	}
	
	@FXML
	public void btnMedianResult(ActionEvent event) {
		String tmpExamId = tfId.getText();
		for (WrittenExam e : examRegister.getExamRegister()) {
			if (e.getExamID().equals(tmpExamId)) {
				outPutArea.setText("Median result for this exam is " + e.getMedianResult());
			}
			else {
				outPutArea.setText("No exam exists with this ID. Please try another. ");
				}
			}
		}
	
	@FXML
	public void btnNbrPassedExam(ActionEvent event) {
		String tmpExamId = tfId.getText();
		for (WrittenExam e : examRegister.getExamRegister()) {
			if (e.getExamID().equals(tmpExamId)) {
				outPutArea.setText(e.nbrPassedExam() + " passed the exam.");
			}
			else {
				outPutArea.setText("No exam exists with this ID. Please try another. ");
			}
		}
	}
		

	@FXML
	public void btnGenerateExamId(ActionEvent event) {
		Random examGen = new Random();
		int examId = examGen.nextInt(99999 + 1 - 10000) + 10000;
		tfId.setText("E" + examId);
	}
}

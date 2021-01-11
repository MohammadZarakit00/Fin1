package controllers;

import java.net.URL;
import java.util.*;

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
import javafx.scene.layout.Border;
import javafx.scene.text.Text;
import model.Course;
import model.CourseRegister;
import model.WrittenExam;
import model.WrittenExamRegister;

import static javafx.collections.FXCollections.observableArrayList;

public class ExamManagementController extends Controller implements Initializable {

	private CourseRegister courseRegister = CourseRegister.getCourseRegInstance();
	private WrittenExamRegister examRegister = WrittenExamRegister.getExamRegInstance();


	@FXML
	ComboBox courseChoiceBox = new ComboBox();
	//@FXML
	//Button btnGenerateExamId = new Button();
	
	
//	@FXML
//	Button btnAddExam = new Button();
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
	@FXML
	Text errorText = new Text();
	@FXML
	TextArea taError = new TextArea();
	
	@FXML
	public void initialize(URL location, ResourceBundle resources){
		System.out.println("Kör initialize");
		ArrayList<String> tmpList = new ArrayList<>();
		for(Course c : courseRegister.getCourseRegister()){
			tmpList.add(c.getCourseCode() + ": " + c.getName());
		}
		courseChoiceBox.setItems(FXCollections.observableArrayList(tmpList));
	}


	//Im missing something here, can't figure out how to add the exam TO the course...
	@FXML
	public void btnAddExam(ActionEvent event) {
		String tmpIdExam = tfId.getText();
		String tmpIdDate = tfDate.getText();
		String tmpIdLocation = tfLocation.getText();
		String tmpIdTime = tfTime.getText();
		Course tmpCourse = (Course) courseChoiceBox.getValue();
		WrittenExam newExam = new WrittenExam(tmpIdExam, tmpIdDate, tmpIdLocation, tmpIdTime, tmpCourse);
		if(!newExam.checkExamIdInput(tmpIdExam)){

		}
		examRegister.add(new WrittenExam(tmpIdExam, tmpIdDate, tmpIdLocation, tmpIdTime, tmpCourse)); //this one is wonk supreme. needs to define exam FOR the given course
		outPutArea.setText("Exam " + tmpIdExam + " was added for the course " + tmpCourse.getName() + ". ");
	}
	
	//Same as above. Remove FROM a course.
	@FXML
	public void btnRemoveExam(ActionEvent event) {
		String tmpId = tfId.getText();
		if(examRegister.containsExam(tmpId)) {
			examRegister.remove(tmpId);
			outPutArea.setText("The exam " + tmpId + " was removed from the course. ");
		} else {
			outPutArea.setText("The exam " + tmpId + " does not exist in the register. ");
		}
	}
	
	
	@FXML
	public void btnMeanResult(ActionEvent event) {
		String tmpExamId = tfId.getText();
		for (WrittenExam e : examRegister.getExamRegister()) {
			if (e.getExamID().equals(tmpExamId)) {
				outPutArea.setText("Mean result for this exam is " + e.getMeanResult());
			} else {
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

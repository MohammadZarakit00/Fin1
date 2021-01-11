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
import javafx.scene.text.Text;
import model.Course;
import model.CourseRegister;
import model.Student;
import model.StudentRegister;
import model.WrittenExam;
import model.WrittenExamRegister;

import static javafx.collections.FXCollections.observableArrayList;

public class ExamManagementController extends Controller implements Initializable {

	private CourseRegister courseRegister = CourseRegister.getCourseRegInstance();
	private WrittenExamRegister examRegister = WrittenExamRegister.getExamRegInstance();
	private StudentRegister studentRegister = StudentRegister.getStudentRegInstance();

	
	
	@FXML
	ComboBox courseChoiceBox = new ComboBox();
	@FXML
	ComboBox studentChoiceBox = new ComboBox();
	@FXML
	Button btnGenerateExamId = new Button();
	
	
	@FXML
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
	@FXML
	Button btnRegisterResult = new Button();

	@FXML
	TextField tfId = new TextField();
	@FXML
	TextField tfDate = new TextField();
	@FXML
	TextField tfLocation = new TextField();
	@FXML
	TextField tfTime = new TextField();
	@FXML
	TextField tfScore = new TextField();
	@FXML
	TextArea outPutArea = new TextArea();
	@FXML
	Text errorText = new Text();
	
	//Fills out drop down menus with courses and students respectively, to choose when adding exam to courses or registering results for students.
	public void initialize(URL location, ResourceBundle resources){
		System.out.println("Kör initialize");
		ArrayList<String> tmpCourseList = new ArrayList<>();
		for(Course c : courseRegister.getCourseRegister()){
			tmpCourseList.add(c.getCourseCode() + ": " + c.getName());
		}
		courseChoiceBox.setItems(FXCollections.observableArrayList(tmpCourseList));
		
		ArrayList<String> tmpStudentList = new ArrayList<>();
		for(Student s : studentRegister.getStudentRegister()) {
			tmpStudentList.add(s.getStudentId() + ": " + s.getName());
		}
		studentChoiceBox.setItems(FXCollections.observableArrayList(tmpStudentList));
	}

	
	@FXML
	public void btnAddExam(ActionEvent event) {
			String tmpIdExam = tfId.getText();
			String tmpIdDate = tfDate.getText();
			String tmpIdLocation = tfLocation.getText();
			String tmpIdTime = tfTime.getText();
			Course currentCourse = (Course) courseChoiceBox.getValue();//almost..... but not quite. class cast exception, cant cast to Course
		examRegister.add(new WrittenExam(tmpIdExam, tmpIdDate, tmpIdLocation, tmpIdTime, currentCourse)); //this one is wonk supreme. needs to define exam FOR the given course
		outPutArea.setText("Exam " + tmpIdExam + " was added to the course " + currentCourse + ". ");
	} 
	
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
		WrittenExam exam = examRegister.findExam(tmpExamId);
			if (exam != null) {
				outPutArea.setText("Mean result for this exam is " + exam.getMeanResult());
			}
			else {
				outPutArea.setText("No exam exists with this ID. Please try another. ");
			}
		}
	
	
	@FXML
	public void btnMedianResult(ActionEvent event) {
		String tmpExamId = tfId.getText();
		WrittenExam exam = examRegister.findExam(tmpExamId);
			if (exam != null) {				
				outPutArea.setText("Median result for this exam is " + exam.getMedianResult());
			}
			else {
				outPutArea.setText("No exam exists with this ID. Please try another. ");
				}
			}
		
	
	@FXML
	public void btnNbrPassedExam(ActionEvent event) {
		String tmpExamId = tfId.getText();
		WrittenExam exam = examRegister.findExam(tmpExamId);
			if (exam != null) {
				outPutArea.setText(exam.nbrPassedExam() + " passed the exam.");
			}
			else {
				outPutArea.setText("No exam exists with this ID. Please try another. ");
			}
		}
	
	@FXML
	public void btnRegisterResult(ActionEvent event) {
		WrittenExam exam = null;
		String tmpExamId = tfId.getText();
		String tmpScore = tfScore.getText();
		String tmpStudentId = (String) studentChoiceBox.getValue(); //cant cast, idkwtf to put here
		if (tmpExamId == null || tmpScore == null || tmpStudentId == null) {
			exam.setStudentResult(tmpStudentId, Integer.parseInt(tmpScore)); //gotta work in examId somehow.
			outPutArea.setText("Score of " + tmpScore + " registered on the exam " + tmpExamId + " for student " + tmpStudentId);
		} else {
			outPutArea.setText("You must enter an exam ID, a score, and choose for which student you wish to register." );
		}
	}
	
		
	@FXML
	public void btnGenerateExamId(ActionEvent event) {
		Random examGen = new Random();
		int examId = examGen.nextInt(99999 + 1 - 10000) + 10000;
		tfId.setText("E" + examId);
		
	}
	
	
	
}

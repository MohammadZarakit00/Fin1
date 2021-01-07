package controllers;

import java.awt.Button;
import java.awt.TextField;
import java.awt.TextArea;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Course;
import model.CourseRegister;
import model.WrittenExam;

public class ExamManagementController {
	
	private ArrayList<WrittenExam> examRegister = new ArrayList<>();
	
	//WORK IN PROGRESS, no lists can exist before we fix the main/controller issue
	/*
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
	public void btnAddExam(ActionEvent event) {
			String tmpIdExam = tfId.getText();
			String tmpIdDate = tfDate.getText();
			String tmpIdLocation = tfLocation.getText();
			String tmpIdTime = tfTime.getText();
			Course currentCourse = Course.getCourseRegister();
		examRegister.add(new WrittenExam(tmpIdExam, tmpIdDate, tmpIdLocation, tmpIdTime, currentCourse)); //this one is wonk supreme. needs to define exam FOR the given course
		outPutArea.setText("Exam " + tmpIdExam + " was added for the course " + currentCourse + ". ");
		
		
	}
	
	@FXML
	public void btnRemoveExam(ActionEvent event) {
		
	}
	
	@FXML
	public void btnMeanResult(ActionEvent event) {
		String tmpExamId = tfId.getText();
		for (WrittenExam e : examRegister) {
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
		for (WrittenExam e : examRegister) {
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
		for (WrittenExam e : examRegister) {
			if (e.getExamID().equals(tmpExamId)) {
				outPutArea.setText(e.nbrPassedExam() + " passed the exam.");
			}
			else {
				outPutArea.setText("No exam exists with this ID. Please try another. ");
			}
		}
	}
		*/

}

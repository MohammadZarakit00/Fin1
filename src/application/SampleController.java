package application;

import javafx.scene.control.TextField;
import model.Course;
import model.Student;
import model.WrittenExam;

import java.util.ArrayList;

import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class SampleController {

	private ArrayList<Student> studentRegister = new ArrayList<Student>();
	private ArrayList<Course> courseRegister = new ArrayList<Course>();
	private ArrayList<WrittenExam> examRegister = new ArrayList<>();

	@FXML
	Button btnAddStudent = new Button();
	@FXML
	Button btnFindStudent = new Button();
	@FXML
	Button btnDeleteStudent = new Button();
	@FXML
	Button btnAddCourse = new Button();
	@FXML
	Button btnFindCourse = new Button();
	@FXML
	Button btnRemoveCourse = new Button();
	@FXML
	Button btnAddExam = new Button();

	@FXML
	TextArea ta = new TextArea();
	@FXML
	TextField tfId = new TextField();
	@FXML
	TextField tfIdExam = new TextField();
	@FXML
	TextField tfName = new TextField();
	@FXML
	TextField tfCredits = new TextField();
	@FXML
	TextField tfDate = new TextField();
	@FXML
	TextField tfLocation = new TextField();
	@FXML
	TextField tfTime = new TextField();

	@FXML
	Button btnScene2;

	public void handleBtn1() throws Exception {

		Parent root = FXMLLoader.load(this.getClass().getResource("/Homepage.fxml"));

		Stage window = (Stage) btnScene2.getScene().getWindow();

		window.setScene(new Scene(root, 800, 600));
	}

		@FXML
		public void btnAddStudent(ActionEvent event) {
		Student student = null;
		String tmpId = tfId.getText();
		String tmpName = tfName.getText();
		//if (tfId.getText().equals(student)) { //this function tries to check the "student" validity, i.e. if the ID is correct etc. still working on it
			studentRegister.add(new Student(tmpId, tmpName));
			ta.setText(tmpName + " was added to the register. ");
		//} else {
		//	ta.setText("Input is not accepted. Please note that student ID must contain 6 characters and start with an 'S.'");
	//	}
	}
	@FXML
	public String btnFindStudent(ActionEvent event) {
		String tmpId = tfId.getText();
		for (Student s : studentRegister) {
			if (s.getStudentId().equals(tmpId)) {
				ta.setText("Found student " + s.getName() + " with ID " + s.getStudentId() + ". ");
			}
			else {
				ta.setText("No student found with given identification. ");
			}
		}
		return tmpId;
	}


		@FXML
		public void btnDeleteStudent (ActionEvent event){
			String tmpId = tfId.getText();
			for (Student s : studentRegister) { //den här raden exploderar i errormeddelanden men fungerar vid action. oklart varför.
				if (s.getStudentId().equals(tmpId)) {
					studentRegister.remove(s);
					ta.setText("Student " + tmpId + " was removed from the system. ");
				} else {
					ta.setText("No student found with given identification. ");
				}
			}
		}
		@FXML
		public void btnAddCourse (ActionEvent event){
			String tmpId = tfId.getText();
			String tmpName = tfName.getText();
			try {
				int tmpCredits = Integer.parseInt(tfCredits.getText());
				courseRegister.add(new Course(tmpId, tmpName, tmpCredits));
				ta.setText("Course " + tmpName + " with course code " + tmpId + " worth " + tmpCredits + " credits was added to the list.");
			} catch (NumberFormatException e) {
				ta.setText("Input is not accepted. Course credits input must be a number. ");
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

	/*	@FXML
		public void btnAddExam (ActionEvent event) {

		WrittenExam writtenExam;
			String tmpIdExam = tfIdExam.getText();
			String tmpIdDate = tfDate.getText();
			String tmpIdLocation = tfLocation.getText();
			String tmpIdTime = tfTime.getText();
			Course tmpCourse = tfId.getText().toString(); //w i p
		examRegister.add(new WrittenExam(tmpIdExam, tmpIdDate, tmpIdLocation, tmpIdTime, tmpCourse)); //this one is wonk supreme. needs to define exam FOR the given course
		ta.setText("Exam " + tmpIdExam + " was added for the course " + tmpCourse + ". ");
		}
		*/

	}




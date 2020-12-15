package application;

import javafx.scene.control.TextField;
import model.Course;
import model.Result;
import model.Student;
import model.WrittenExam;
import model.StudentTest;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SampleController {
	
	@FXML
	Button btnStudentManagement = new Button();
	
	public void btnStudentManagement(ActionEvent event) throws Exception {
		
	Parent root = FXMLLoader.load(this.getClass().getResource("/Sample.fxml"));
	Stage window = (Stage) btnStudentManagement.getScene().getWindow();
	window.setScene(new Scene (root));
	}
	

	private ArrayList<Student> studentRegister = new ArrayList<Student>();
	private ArrayList<Course> courseRegister = new ArrayList<Course>();

	@FXML
	Button btnAddStudent = new Button();
	@FXML
	Button btnFindStudent = new Button();
//	@FXML
	//Button btnDeleteStudent = new Button();
	@FXML
	Button btnAddCourse = new Button();
	@FXML
	Button btnFindCourse = new Button();
	@FXML
	Button btnRemoveCourse = new Button();
	@FXML
	TextArea ta = new TextArea();
	@FXML
	TextField tfId = new TextField();
	@FXML
	TextField tfName = new TextField();
	@FXML
	TextField tfCredits = new TextField();

	@FXML
	public void btnAddStudent(ActionEvent event) {
		String tmpId = tfId.getText();
		String tmpName = tfName.getText();
		studentRegister.add(new Student(tmpId, tmpName));

	}

	@FXML
	public void btnAddCourse(ActionEvent event) {
		String tmpId = tfId.getText();
		String tmpName = tfName.getText();
		try {
			int tmpCredits = Integer.parseInt(tfCredits.getText());
			courseRegister.add(new Course(tmpId, tmpName, tmpCredits));
			ta.setText("Course " + tmpName + " with course code " + tmpId + " worth " + tmpCredits + " credits was added to the list.");
		} catch (NumberFormatException e) {
			ta.setText("Input is not accepted. Try a number. ");
		}
	}

	@FXML
	public void btnRemoveCourse(ActionEvent event) {
		String tmpId = tfId.getText();
		for (Course c : courseRegister) {
			if (c.getCourseCode().equals(tmpId)) {
				courseRegister.remove(c);
				ta.setText(tmpId + " was removed from the register.");
			} else {
				ta.setText(tmpId + " doesnt exist in the register.");
			}
		}
	}




/*@FXML
	public String btnFindStudent(ActionEvent event) {
		WrittenExam writtenExam = sList.findStudent(tfId.getText());
		if (studentRegister.contains(student)) {
			ta.setText(student.getName() + student.getStudentId());
		}
		return null;
	}
	*/

}


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
	
	//private ArrayList<Student> studentRegister = new ArrayList<Student>();
	private ArrayList<Course> courses = new ArrayList<>();
	WrittenExam testExam = new WrittenExam("E00001");
	
	@FXML
	Button btnAddStudent = new Button();
	@FXML
	Button btnFindStudent = new Button();
	@FXML
	Button btnDeleteStudent = new Button();
	@FXML
	TextArea ta = new TextArea();
	@FXML
	TextField tfId = new TextField();
	@FXML
	TextField tfName = new TextField();
	
	@FXML
	public void btnAddStudent(ActionEvent event) {
		String tmpId = tfId.getText();
		String tmpName = tfName.getText();
		testExam.addStudent(new Student(tmpId, tmpName));

	}
	
	@FXML
	public String btnFindStudent(ActionEvent event) {
		String tmpId = tfId.getText();
		if (tfId.getText().equals(tmpId)) {
			ta.setText(tmpId);
			
		}
		return null;
		
	}
	
}


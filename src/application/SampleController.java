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
	
	private ArrayList<Student> studentRegister = new ArrayList<Student>();
	
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
		studentRegister.add(new Student(tmpId, tmpName));

	}
	
	@FXML
	public void btnFindStudent(ActionEvent event) {
		String tmpId = tfId.getText();
		
	}
	
}

